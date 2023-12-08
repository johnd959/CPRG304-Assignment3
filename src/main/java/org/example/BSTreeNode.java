package org.example;

public class BSTreeNode<E extends Comparable <? super E>> {
    private E data;
    private BSTreeNode<E> parent;
    private BSTreeNode<E> right;
    private BSTreeNode<E> left;

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public BSTreeNode<E> getParent() {
        return parent;
    }

    public void setParent(BSTreeNode<E> parent) {
        this.parent = parent;
    }

    public BSTreeNode<E> getRight() {
        return right;
    }

    public void setRight(BSTreeNode<E> right) {
        this.right = right;
    }

    public BSTreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(BSTreeNode<E> left) {
        this.left = left;
    }

    public BSTreeNode()
    {

    }

    public BSTreeNode(E data)
    {
        setData(data);
    }
}
