package models;

import interfaces.BST_IF;
import interfaces.Filme_IF;
import java.util.ArrayList;

public class BST implements BST_IF {
    protected BTNode root;

    public BST() {
        this.root = new BTNode();
    }

    @Override
    public void insert(Filme_IF element) {
        if (root != null) {            
            if (root.isEmpty()) {
                root.setFilme(element);
    
            } else {
                BTNode aux = root;

                while (!aux.isEmpty()) {
                    if (aux.getFilme().compareTo(element) > 0) {
                        aux = aux.getLeft();

                    } else {
                        aux = aux.getRight();
                    }
                }

                aux = aux.getParent();

                if (aux.getFilme().compareTo(element) > 0) {
                    aux.setLeft(new BTNode(element, aux));
                
                } else {
                    aux.setRight(new BTNode(element, aux));
                }
            }
        }

    }
  
    
    @Override
    public Filme_IF remove(long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        if (this.root.isEmpty() || this.root == null) {
            throw new UnsupportedOperationException("A arvore está vazia");
        }

        Filme_IF filmeAux = new Filme();
        filmeAux.setID(id);

        BTNode aux = root;

        while (!aux.isEmpty()) {
            if (aux.getFilme().compareTo(filmeAux) < 0) {
                aux = aux.getLeft();
            } else {
                aux = aux.getRight();
            }
        }

        aux = aux.getParent();

        if (aux.getFilme().compareTo(filmeAux) == 0) {
            return aux.getFilme();
        }

        return null;
    }

    @Override
    public Filme_IF root() throws Exception {
        if (root.isEmpty()) {
            throw new UnsupportedOperationException("A arvore está vazia");
        }

        return root.getFilme();
    }

    @Override
    public boolean isEmpty() {
        return this.root.isEmpty();
    }

    @Override
    public int height() {
        throw new UnsupportedOperationException("Not supported yet.");
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Filme_IF[] preOrder() {
        if (!root.isEmpty()) {
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
        if (!node.isEmpty()) {           
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
        if (!node.getRight().isEmpty() && node.getRight() != null) {
            return treeMinimum(node);
        }
        BTNode aux = node;
        BTNode auxParent = aux.getParent();

        while (!auxParent.isEmpty() && aux == auxParent.getRight()) { 
            aux = auxParent;
            auxParent = auxParent.getParent();
        }

        return auxParent;
    }

    public BTNode predecessor(BTNode node) {
        if (!node.getLeft().isEmpty() && node.getLeft() != null) {
            return treeMaximum(node);
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
