package referenceBasedTreeImplementation;

import java.util.NoSuchElementException;
import java.util.Stack;

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

    public BSTreeNode<E> getRoot() {
        return root;
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
        	root = addHelper(root, new BSTreeNode<E>(newEntry));
        	return true;
        }
        catch (NullPointerException error) {
            return false;
        }
    }

    public Iterator<E> inorderIterator() {
        Stack<BSTreeNode<E>> stack = new Stack<>();
        BSTreeNode<E> curr = root;
    
        // First node to be visited will be the leftmost node
        while (curr != null) {
            stack.push(curr);
            curr = curr.getLeftBranch();
        }
    
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }
    
            @Override
            public E next() {
                BSTreeNode<E> node = stack.pop();
                E result = node.getNodeData();
                if (node.getRightBranch() != null) {
                    node = node.getRightBranch();
    
                    while (node != null) {
                        stack.push(node);
                        node = node.getLeftBranch();
                    }
                }
                return result;
            }
        };
    }

    public Iterator<E> preorderIterator() {
        Stack<BSTreeNode<E>> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
    
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }
    
            @Override
            public E next() {
                BSTreeNode<E> node = stack.pop();
                E result = node.getNodeData();
    
                // Push right child first so that left child is processed first (LIFO order)
                if (node.getRightBranch() != null) {
                    stack.push(node.getRightBranch());
                }
                if (node.getLeftBranch() != null) {
                    stack.push(node.getLeftBranch());
                }
    
                return result;
            }
        };
    }
    

    public Iterator<E> postorderIterator() {
        Stack<BSTreeNode<E>> stack1 = new Stack<>();
        Stack<BSTreeNode<E>> stack2 = new Stack<>();
        if (root != null) {
            stack1.push(root);
        }
    
        // First push root to first stack and then push all elements from first stack to second stack while pushing left and right children of popped item to first stack
        while (!stack1.isEmpty()) {
            BSTreeNode<E> node = stack1.pop();
            stack2.push(node);
    
            if (node.getLeftBranch() != null) {
                stack1.push(node.getLeftBranch());
            }
            if (node.getRightBranch() != null) {
                stack1.push(node.getRightBranch());
            }
        }
    
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return !stack2.isEmpty();
            }
    
            @Override
            public E next() {
                BSTreeNode<E> node = stack2.pop();
                return node.getNodeData();
            }
        };
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
        		return root.getRightBranch().getNodeData();
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