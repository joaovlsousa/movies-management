package models;

import interfaces.Filme_IF;

public class BTNode {

    private Filme_IF filme;
    private BTNode left;
    private BTNode right;
    private BTNode parent;
    
    public BTNode() {
        this.filme = null;
        this.parent = new BTNode(null);    
        this.left = new BTNode(this);
        this.right = new BTNode(this);
    }

    public BTNode(BTNode parent) {
        this.filme = null;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }

    public BTNode(Filme_IF filme, BTNode parent) {
        this.filme = filme;
        this.parent = parent;    
        this.left = new BTNode(this);
        this.right = new BTNode(this);
    }
    
    public boolean isEmpty() {
        return this.filme == null;
    }

    public BTNode getLeft() {
        return this.left;
    } 

    public Filme_IF getFilme() {
        return this.filme;
    }

    public BTNode getRight() {
        return this.right;
    }

    public BTNode getParent() {
        return this.parent;
    }

    public void setFilme(Filme_IF filme) {
        this.filme = filme;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }

    public void setParent(BTNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Noh Vazio";
        }
        return "filme: "+ this.filme +
        "\nNoh Esquedo: "+ this.left.filme+
        "\nNoh Direito: "+ this.right.filme+
        "\nNoh Pai: "+ this.parent.filme;
    }

    protected int size(BTNode node) {
        if (node == null || node.isEmpty()) {
            return 0;
        
        } else {
            return 1 + size(node.getLeft()) + size(node.getRight());
        }
    }

}