package org.example;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BST<E extends Comparable <? super E>>  implements BSTreeADT{

    private int count;
    private BSTreeNode<E> root;

    public BST()
    {

    }


    @Override
    public BSTreeNode getRoot() {
        return this.root;
    }

    @Override
    public int getHeight() {
        return trHeight(this.root);
    }

    private int trHeight(BSTreeNode<E> visiting)
    {
        if (visiting == null)
        {
            return 0;
        }

        int leftHeight = trHeight(visiting.getLeft());
        int rightHeight = trHeight(visiting.getRight());

        if(leftHeight > rightHeight)
        {
            return leftHeight + 1;
        }
        else
        {
            return rightHeight + 1;
        }
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void clear() {
        this.root = null;
        this.count = 0;
    }

    @Override
    public boolean contains(Comparable entry) throws NullPointerException {
        return trContains(entry, this.root);
    }

    private boolean trContains(Comparable entry, BSTreeNode<E> visiting)
    {
        boolean found = false;
        if (visiting == null)
            return false;

        if (visiting.getData().equals(entry))
            return true;

        if (visiting.getData().compareTo((E) entry) > 0)
            found = trContains(entry, visiting.getLeft());

        else
            found = trContains(entry, visiting.getRight());

        return found;
    }


    @Override
    public BSTreeNode search(Comparable entry) throws NullPointerException {
        return trSearch(entry, this.root);
    }

    private BSTreeNode<E> trSearch(Comparable entry, BSTreeNode<E> visiting)
    {
        BSTreeNode<E> found = null;
        if (visiting == null)
            return null;

        if (visiting.getData().compareTo((E) entry) == 0)
            return visiting;

        if (visiting.getData().compareTo((E) entry) > 0)
            found = trSearch(entry, visiting.getLeft());
        else
            found = trSearch(entry, visiting.getRight());

        return found;
    }

    @Override
    public boolean add(Comparable newEntry) throws NullPointerException {
        int count = this.count;
        if (this.count == 0)
        {
            this.root = new BSTreeNode<>((E) newEntry);
            this.count++;
            return true;
        }
        tradd(this.root, newEntry);
        return count < this.count;
    }

    private void tradd(BSTreeNode visiting, Comparable newEntry)
    {
        if(visiting.getData().compareTo(newEntry) < 0)
        {
            if(visiting.getRight() != null)
            {
                tradd(visiting.getRight(), newEntry);
            }
            else
            {
                visiting.setRight(new BSTreeNode(newEntry));
                count++;
            }
        }
        else
        {
            if(visiting.getLeft() != null)
            {
                tradd(visiting.getLeft(), newEntry);
            }
            else
            {
                visiting.setLeft(new BSTreeNode(newEntry));
                count++;
            }
        }
    }

    @Override
    public BSTreeNode removeMin() {
        BSTreeNode<E> visiting = this.root;
        BSTreeNode<E> temp;
        while(visiting.getLeft().getLeft() != null)
        {
            visiting = visiting.getLeft();
        }
        temp = visiting.getLeft();
        if(visiting.getLeft().getRight() != null)
            visiting.setLeft(visiting.getLeft().getRight());
        else
            visiting.setLeft(null);
        count--;
        return temp;
    }

    @Override
    public BSTreeNode removeMax() {
        BSTreeNode<E> visiting = this.root;
        BSTreeNode<E> temp;
        while(visiting.getRight().getRight() != null)
        {
            visiting = visiting.getRight();
        }
        temp = visiting.getRight();
        if (visiting.getRight().getLeft() != null)
            visiting.setRight(visiting.getRight().getLeft());
        else
            visiting.setRight(null);
        count--;
        return temp;
    }

    @Override
    public Iterator inorderIterator() {
        return new BSTIterator(this, 0);
    }

    private class BSTIterator implements Iterator
    {
        BST<E>  tree;
        ArrayList<E> arr;
        int current;
        public BSTIterator(BST<E> tree, int order)
        {
            this.tree = tree;
            this.arr = new ArrayList<>();
            switch (order)
            {
                case -1:
                {
                    PRIterate(this.tree.getRoot());
                    break;
                }
                case 0:
                {
                    INIterate((this.tree.getRoot()));
                    break;
                }
                case 1:
                {
                    POIterate(this.tree.getRoot());
                    break;
                }
                default:
                {
                    throw new IllegalArgumentException("Please choose -1 for VLR\n" +
                            "Please choose 0 for LVR\n" +
                            "Please choose 1 for LRV");
                }
            }
            current = 0;
        }

        private void INIterate(BSTreeNode<E> visiting)
        {
            if (visiting == null)
                return;

            INIterate(visiting.getLeft());
            arr.add(visiting.getData());
            INIterate(visiting.getRight());
        }
        private void PRIterate(BSTreeNode<E> visiting)
        {
            if (visiting == null)
                return;

            arr.add(visiting.getData());
            PRIterate(visiting.getLeft());
            PRIterate(visiting.getRight());
        }
        private void POIterate(BSTreeNode<E> visiting)
        {
            if (visiting == null)
                return;

            POIterate(visiting.getLeft());
            POIterate(visiting.getRight());
            arr.add(visiting.getData());
        }

        @Override
        public boolean hasNext() {
            return current != tree.count;
        }

        @Override
        public Object next() throws NoSuchElementException {
            return arr.get(current++);
        }
    }

    @Override
    public Iterator preorderIterator() {
        return new BSTIterator(this, -1);
    }

    @Override
    public Iterator postorderIterator() {
        return new BSTIterator(this, 1);
    }
}
