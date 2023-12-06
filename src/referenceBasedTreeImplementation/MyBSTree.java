package referenceBasedTreeImplementation;

import java.util.NoSuchElementException;

import exceptions.TreeException;
import utilities.BSTreeADT;
import utilities.Iterator;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deadcode, unused, typeSafety")

public class MyBSTree<E extends Comparable<? super E>> implements BSTreeADT<E>, Iterator<E>{
    // these are placeholders and are subject to change if need be
    private int size;
    private int height;
    private BSTreeNode<E> node;
    
    @Override
    public BSTreeNode<E> getRoot() throws TreeException {
        BSTreeNode<E> rootNode = new BSTreeNode<>();
        
        if (rootNode.isTreeNodeEmpty()==false) {
            throw new TreeException("Tree is empty");
        }
        else {
            return rootNode;
        }
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
        node.setRootBranch(null);
    }

    @Override
    public boolean contains(E entry) throws TreeException {
        if(node.isTreeNodeEmpty()==false){
            throw new TreeException("Tree Is empty");
        }else{
            Iterator<E> iter = inorderIterator();
            List<E> group = new ArrayList<>();
            while(iter.hasNext()){group.add(iter.next());}
            return group.contains(entry);
        }
    }

    public BSTreeNode<E> search(E entry){
        return node;
    }

    @Override
    public boolean add(E newEntry) throws NullPointerException {
        try {
            if (node.getRootBranch() == null) {
                BSTreeNode<E> rootNode = new BSTreeNode<E>();
                rootNode.setRootBranch(rootNode);
                rootNode.setNodeData(newEntry);
            }
            else if (node.getLeftBranch() == null) {
                BSTreeNode<E> newLeftNode = new BSTreeNode<E>();
                newLeftNode.setLeftBranch(newLeftNode);
                newLeftNode.setNodeData(newEntry);
            }
            else {
                BSTreeNode<E> newRightNode = new BSTreeNode<E>();
                newRightNode.setLeftBranch(newRightNode);
                newRightNode.setNodeData(newEntry);
            }
            return true;
        }
        catch (NullPointerException error) {
            return false;
        }
    }

    @Override
    public Iterator<E> inorderIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inorderIterator'");
    }

    @Override
    public Iterator<E> preorderIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'preorderIterator'");
    }

    @Override
    public Iterator<E> postorderIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postorderIterator'");
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
    }

    @Override
    public E next() throws NoSuchElementException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }

}