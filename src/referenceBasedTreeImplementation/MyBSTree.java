package referenceBasedTreeImplementation;

import java.util.NoSuchElementException;

import exceptions.TreeException;
import utilities.BSTreeADT;
import utilities.Iterator;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deadcode, unused, typeSafety")

public class MyBSTree<E extends Comparable<? super E>> implements BSTreeADT<E>, Iterator<E>{
    private int size;
    private int height;
    private BSTreeNode<E> root;

    public BSTreeNode<E> getRoot() throws TreeException {
        BSTreeNode<E> rootNode = new BSTreeNode<>();
        
        if (rootNode.isTreeNodeEmpty()==false) {
            throw new TreeException("Tree is empty");
        }
        else {
            return rootNode;
        }
    }

    public int getHeight() {
        return height;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size > 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public boolean contains(E entry) throws TreeException {
        if(root.isTreeNodeEmpty()==false){
            throw new TreeException("Tree Is empty");
        }else{
            Iterator<E> iter = inorderIterator();
            List<E> group = new ArrayList<>();
            while(iter.hasNext()){group.add(iter.next());}
            return group.contains(entry);
        }
    }
    
    public BSTreeNode<E>  searchHelper(BSTreeNode<E> node, E data) {
    	if (root == null) {
    		return null;
    	}
    	else if (root.getNodeData() == data) {
    		return node;
    	}
    	else if (root.getLeftBranch() != null) {
    		return searchHelper(root.getLeftBranch(), data);
    	}
    	else { // if right is not null
    		return searchHelper(root.getRightBranch(), data);
    	}
    }

    public BSTreeNode<E> search(E entry){
        return searchHelper(root, entry);
    }
    
    public BSTreeNode<E> addHelper(BSTreeNode<E> root, BSTreeNode<E> node) {
    	E data = node.getNodeData();
    	
    	if (root == null) {
    		root = node;
    		return root;
    	}
    	else if (root.getLeftBranch() == null) {
    		root.setLeftBranch(addHelper(root.getLeftBranch(), node));
    	}
    	else {
    		root.setRightBranch(addHelper(root.getRightBranch(), node));
    	}
    	return root;
    }

    public boolean add(E newEntry) throws NullPointerException {
        try {
        	root = addHelper(root, new BSTreeNode(newEntry));
        	return true;
        }
        catch (NullPointerException error) {
            return false;
        }
    }

    public Iterator<E> inorderIterator() {
    	return null;
    }

    public Iterator<E> preorderIterator() {
    	return null;
    }

    public Iterator<E> postorderIterator() {
    	return null;
    }

    public boolean hasNext() {
    	if (root == null) {
    		return false;
    	}
    	else if (root.getLeftBranch() == null) {
    		return false;
    	}
    	else if (root.getRightBranch() == null) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }

    @Override
    public E next() throws NoSuchElementException {
        try {
        	if (hasNext() == true) {
        		return root.getNodeData();
        	}
        	else {
        		return null;
        	}
        }
        catch (NoSuchElementException error) {
        	return null;
        }
    }

}