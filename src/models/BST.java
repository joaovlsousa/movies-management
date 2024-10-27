package models;

import interfaces.BST_IF;
import interfaces.Filme_IF;

public class BST implements BST_IF{

    protected BTNode root;

    public BST() {
        this.root = new BTNode();
    }

    @Override
    public Filme_IF remove(long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
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
    public boolean isEmpty() {
        return this.root.isEmpty();
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        if (this.root.isEmpty() || this.root == null) {
            throw new UnsupportedOperationException("A arvore está vazia");
        }
        BTNode aux = root;
        Filme_IF filmeAux = new Filme();
        filmeAux.setID(id);

        while (!aux.isEmpty()) {
            if (aux.getFilme().compareTo(filmeAux) > 0) {
                aux = aux.getLeft();

            } else {
                aux = aux.getRight();
            }
        }
        aux = aux.getParent();

        if (aux.getFilme().compareTo(filmeAux) == 0) {
            return aux.getFilme();
        
        } else {
            return null;
        }

    }

    @Override
    public Filme_IF root() throws Exception {
        if (root.isEmpty()) {
            throw new UnsupportedOperationException("A arvore está vazia");
        }
        return root.getFilme();
    }

    @Override
    public int height() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isComplete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Filme_IF[] preOrder() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Filme_IF[] order() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Filme_IF[] postOrder() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public BTNode treeMinimum(BTNode node) {
        BTNode aux = node;
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
    
}