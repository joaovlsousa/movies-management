package models;

import interfaces.Filme_IF;

public class BTNode {
    private Filme_IF filme;
    private BTNode left;
    private BTNode right;
    private BTNode parent;
    private int altura;
    
    public BTNode() {
        this.filme = null;
        this.parent = new BTNode(null);    
        this.left = new BTNode(this);
        this.right = new BTNode(this);
        this.altura = -1;
    }

    public BTNode(BTNode parent) {
        this.filme = null;
        this.parent = parent;
        this.left = null;
        this.right = null;
        this.altura = -1;
    }

    public BTNode(Filme_IF filme, BTNode parent) {
        this.filme = filme;
        this.parent = parent;    
        this.left = new BTNode(this);
        this.right = new BTNode(this);
        this.altura = -1;
    }
    
    public boolean isEmpty() {
        return this.filme == null;
    }

    public boolean isNIL() {
        if (this.filme == null && this.left == null && this.right == null && this.parent != null) {
            return true;
        }

        if (this.filme == null && this.parent == null) {
            return true;
        }

        return false;
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

        return "filme: " + this.filme +
        "\nNoh Esquedo: " + this.left.filme +
        "\nNoh Direito: " + this.right.filme +
        "\nNoh Pai: " + this.parent.filme;
    }

    protected int size(BTNode node) {
        if (node == null || node.isEmpty()) {
            return 0;
        
        } else {
            return 1 + size(node.getLeft()) + size(node.getRight());
        }
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

}