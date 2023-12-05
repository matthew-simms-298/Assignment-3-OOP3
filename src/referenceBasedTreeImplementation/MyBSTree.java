package referenceBasedTreeImplementation;

import exceptions.TreeException;
import utilities.BSTreeADT;
import utilities.Iterator;

public class MyBSTree implements BSTreeADT{
    // these are placeholders and are subject to change if need be
    private int size;
    private int height;
    @Override
    public BSTreeNode getRoot() throws TreeException {
        BSTreeNode node = new BSTreeNode();
        return node;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size > 0) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public boolean contains(Comparable entry) throws TreeException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public BSTreeNode search(Comparable entry) throws TreeException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public boolean add(Comparable newEntry) throws NullPointerException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public Iterator inorderIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inorderIterator'");
    }

    @Override
    public Iterator preorderIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'preorderIterator'");
    }

    @Override
    public Iterator postorderIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postorderIterator'");
    }

}