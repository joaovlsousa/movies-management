package models;

import java.util.ArrayList;

import interfaces.BST_IF;
import interfaces.Filme_IF;

public class BST implements BST_IF {
    protected BTNode root;

    public BST() {
        this.root = new BTNode();
    }

    @Override
    public void insert(Filme_IF element) {
        if (root != null && element != null) {            
            if (root.isEmpty()) {
                root.setFilme(element);
            } else {
                BTNode aux = root;

                while (!aux.isEmpty()) {
                    if (aux.getFilme().compareTo(element) < 0) {
                        aux = aux.getLeft();
                    } else {
                        aux = aux.getRight();
                    }
                }

                aux = aux.getParent();

                if (aux.getFilme().compareTo(element) < 0) {
                    aux.setLeft(new BTNode(element, aux));
                } else {
                    aux.setRight(new BTNode(element, aux));
                }
            }
        }
    }

    @Override
    public Filme_IF remove(long id) throws Exception {
        if (this.size() == 0) {
            throw new Exception("A arvore esta vazia");
        }
 
        Filme_IF filme = this.search(id);

        if (filme == null) {
            return null;
        }

        removeAux(searchNode(id));
        return filme;
    }

    private void removeAux(BTNode node) throws Exception {
        BTNode aux = node;
        BTNode auxParent = aux.getParent();

        if (!aux.isEmpty()) {
            // se é folha
            if (aux.getLeft().isEmpty() && aux.getRight().isEmpty()) {
                if (auxParent.getLeft().getFilme().compareTo(aux.getFilme()) == 0) {
                    auxParent.setLeft(new BTNode(auxParent));
                
                } else {
                    auxParent.setRight(new BTNode(auxParent));
                }
                
            } else if ((aux.getLeft().isEmpty() && !aux.getRight().isEmpty()) 
            || (!aux.getLeft().isEmpty() && aux.getRight().isEmpty())) {

                if (aux.getFilme().compareTo(root()) != 0) {
                    
                    if (auxParent.getLeft().getFilme().compareTo(aux.getFilme()) == 0) {
                        
                        if (!aux.getLeft().isEmpty()) {
                            aux.getLeft().setParent(auxParent);
                            auxParent.setLeft(aux.getLeft());

                        } else {
                            aux.getRight().setParent(auxParent);
                            auxParent.setLeft(aux.getRight());
                        }
                    } else {

                        if (!aux.getLeft().isEmpty()) {
                            aux.getLeft().setParent(auxParent);
                            auxParent.setRight(aux.getLeft());

                        } else {

                            aux.getRight().setParent(auxParent);
                            auxParent.setRight(aux.getRight());
                        }
                    }

                } else {
                    if (aux.getLeft().isEmpty()) {
                        root = aux.getRight();
                        root.setParent(new BTNode(null));
                        
                    } else {
                        root = aux.getLeft();
                        root.setParent(new BTNode(null));
                        
                    }
                }
            } else {
                
                BTNode successor = successor(aux);
                removeAux(successor);
                aux.setFilme(successor.getFilme());
            }
        }

    }

    @Override
    public Filme_IF search(long id) throws Exception {
        if (this.root == null || this.root.isEmpty()) {
            throw new Exception("A arvore está vazia");
        }

        Filme_IF filmeAux = new Filme();
        filmeAux.setID(id);

        BTNode aux = root;

        while (!aux.isEmpty() && aux.getFilme().compareTo(filmeAux) != 0) {
            if (aux.getFilme().compareTo(filmeAux) < 0) {
                aux = aux.getLeft();
            } else {
                aux = aux.getRight();
            }
        }

        return aux.getFilme();
    }

    public BTNode searchNode(long id) throws Exception {
        if (this.root == null || this.root.isEmpty()) {
            throw new Exception("A arvore está vazia");
        }

        Filme_IF filmeAux = new Filme();
        filmeAux.setID(id);

        BTNode aux = root;

        while (!aux.isEmpty() && aux.getFilme().compareTo(filmeAux) != 0) {
            if (aux.getFilme().compareTo(filmeAux) < 0) {
                aux = aux.getLeft();
            } else {
                aux = aux.getRight();
            }
        }

        if (aux.isEmpty()) {
            return new BTNode();
        }

        return aux;
    }
    
    @Override
    public Filme_IF root() throws Exception {
        if (root.isEmpty()) {
            throw new Exception("A arvore está vazia");
        }

        return root.getFilme();
    }

    @Override
    public boolean isEmpty() {
        return this.root.isEmpty();
    }

    @Override
    public int height() {
        return heightAux(root) - 1;
    }

    public int heightAux(BTNode node) {
        if (node.isEmpty()) {
            return 0;
        }
        return 1 + maxHeight(heightAux(node.getLeft()), heightAux(node.getRight()));
    }

    private int maxHeight(int x, int y) {
        return (x > y) ? x : (y > x) ? y : x;
    }

    @Override
    public int size() {
        return size(root);
    }

    protected int size(BTNode node) {
        if (node == null || node.isEmpty()) {
            return 0;
        
        } else {
            return 1 + size(node.getLeft()) + size(node.getRight());
        }
    }

    @Override
    public boolean isComplete() {
        return Math.pow(2, height()+1) - 1 == size();
    }

    @Override
    public Filme_IF[] preOrder() {
        if (root != null && !root.isEmpty()) {
            ArrayList<Filme_IF> filmes = new ArrayList<Filme_IF>();
            preOrderAux(root, filmes);

            return filmes.toArray(new Filme_IF[0]);

        } else {
            return null;
        }
    }

    private void preOrderAux(BTNode node, ArrayList<Filme_IF> filmes) {
        if (node != null && !node.isEmpty()) {
            filmes.add(node.getFilme());
            preOrderAux(node.getLeft(), filmes);
            preOrderAux(node.getRight(), filmes);
        }
    }   

    @Override
    public Filme_IF[] order() {
        if (root != null && !root.isEmpty()) {
            ArrayList<Filme_IF> filmes = new ArrayList<Filme_IF>();
            orderAux(root, filmes);

            return filmes.toArray(new Filme_IF[0]);
            
        } else {
            return null;
        }
    }

    private void orderAux(BTNode node, ArrayList<Filme_IF> filmes) {
        if (node != null && !node.isEmpty()) {           
            orderAux(node.getLeft(), filmes);
            filmes.add(node.getFilme());
            orderAux(node.getRight(),filmes);       
        }
    }

    @Override
    public Filme_IF[] postOrder() {
        if (root != null && !root.isEmpty()) {
            ArrayList<Filme_IF> filmes = new ArrayList<Filme_IF>();
            postOrderAux(root, filmes);

            return filmes.toArray(new Filme_IF[0]);

        } else {
            return null;
        }
    }
 
    private void postOrderAux(BTNode node, ArrayList<Filme_IF> filmes) {
        if (node != null && !node.isEmpty()) {
            postOrderAux(node.getLeft(), filmes);
            postOrderAux(node.getRight(), filmes);
            filmes.add(node.getFilme());
        }
    }

    public BTNode treeMinimum(BTNode node) {
        BTNode aux = node;

        while (!aux.getLeft().isEmpty()) {
            aux = aux.getLeft();
        }

        return aux;
    }

    public BTNode treeMinimum() {
        BTNode aux = root;
        while (!aux.getLeft().isEmpty()) {
            aux = aux.getLeft();
        }
        return aux;
    }
    
    public BTNode treeMaximum(BTNode node) {
        BTNode aux = node;

        while (!aux.getRight().isEmpty()) {
            aux = aux.getRight();
        }

        return aux;
    }
    
    public BTNode treeMaximum() {
        BTNode aux = root;
        while (!aux.getRight().isEmpty()) {
            aux = aux.getRight();
        }
        return aux;
    }

    public BTNode successor(BTNode node) {
        if (node.getRight() != null && !node.getRight().isEmpty()) {
            return treeMinimum(node.getRight());
        }
        BTNode aux = node;
        BTNode auxParent = aux.getParent();

        while (!auxParent.isEmpty() && auxParent.getRight() == aux) { 
            aux = auxParent;
            auxParent = auxParent.getParent();
        }

        return auxParent;
    }
    // auxParent.getRight().getFilme().compareTo(aux.getFilme()) == 0

    public BTNode predecessor(BTNode node) {
        if (node.getLeft() != null && !node.getLeft().isEmpty()) {
            return treeMaximum(node.getLeft());
        }
        BTNode aux = node;
        BTNode auxParent = aux.getParent();

        while (!auxParent.isEmpty() && aux == auxParent.getLeft()) {
            aux = auxParent;
            auxParent = auxParent.getParent();
        }
        
        return auxParent;
    }

    public void visitNode(BTNode node) {
        System.out.println(node.getFilme());
    }
}
