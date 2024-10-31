package models;
import interfaces.AVL_IF;
import interfaces.Filme_IF;

public class AVL extends BST implements AVL_IF{

    @Override
    public void insert(Filme_IF element) {
        if (element != null) {
            insertAux(this.root, element);
        }
    }

    @Override
    protected void insertAux(BTNode node, Filme_IF element) {
        if (node.isEmpty()) {
            node.setFilme(element);
            node.setLeft(new BTNode(node));
            node.setRight(new BTNode(node));
        } else {
            if (node.getFilme().compareTo(element) < 0) {
                insertAux(node.getLeft(), element);
            } else {
                insertAux(node.getRight(), element);
            }

            rebalance(node);
        }
    }


    private void rebalance(BTNode node) {
        System.out.println(node);
        System.out.println();

        int nodeBalance = calculateBalance(node);

        if (Math.abs(nodeBalance) > 1){
            int nodeRightBalance = calculateBalance(node.getRight());
            int nodeLeftBalance = calculateBalance(node.getLeft());

            if (nodeBalance > 0 && nodeLeftBalance >= 0) {
                rightRotation(node);
            } else if (nodeBalance < 0 && nodeRightBalance <= 0) {
                leftRotation(node);
            } else if (nodeBalance > 0 &&  nodeLeftBalance < 0) {
                leftRotation(node.getLeft());
                rightRotation(node);
            } else if (nodeBalance < 0 && nodeRightBalance > 0) {
                rightRotation(node.getRight());
                leftRotation(node);
            }
        }
    }

    private void rebalanceUpDelete(BTNode node) {
        BTNode aux = node.getParent();
        
        while (!aux.isEmpty()) { 
            rebalance(aux);
            aux = aux.getParent();
        }
    }


    private int calculateBalance(BTNode node) {
        return heightAux(node.getLeft()) - heightAux(node.getRight());
    }

    private void rightRotation(BTNode node) {

        BTNode pivot = node.getLeft();

        node.setLeft(pivot.getRight());
        pivot.getRight().setParent(node);

        pivot.setRight(node);
        pivot.setParent(node.getParent());

        if (!pivot.getParent().isEmpty()) {
            pivot.getParent().setLeft(pivot);
        }

        node.setParent(pivot);
        
        if (node == this.root) {
            this.root = pivot;
        }

    }
    
    private void leftRotation(BTNode node) {

        BTNode pivot = node.getRight();

        node.setRight(pivot.getLeft());
        pivot.getLeft().setParent(node);

        pivot.setLeft(node);
        pivot.setParent(node.getParent());

        if (!pivot.getParent().isEmpty()) {
            pivot.getParent().setRight(pivot);
        }

        node.setParent(pivot);
        
        if (node == this.root) {
            this.root = pivot;
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

                if (aux == root) {
                    root = new BTNode();
                    
                }else if (auxParent.getLeft() == aux) {
                    auxParent.setLeft(new BTNode(auxParent));
                
                } else {
                    auxParent.setRight(new BTNode(auxParent));
                }

                rebalanceUpDelete(node);
                
            } else if ((aux.getLeft().isEmpty() && !aux.getRight().isEmpty()) 
            || (!aux.getLeft().isEmpty() && aux.getRight().isEmpty())) {

                if (aux != root) {
                    
                    if (auxParent.getLeft() == aux) {
                        
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

                rebalanceUpDelete(node);
                
            } else {
                
                BTNode successor = successor(aux);
                removeAux(successor);
                aux.setFilme(successor.getFilme());
            }
        }
    }
}
