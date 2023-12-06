package referenceBasedTreeImplementation;

/**
 * Tree Search
 * Contains methods for searching a tree
 */

import java.time.temporal.TemporalAdjusters;
import java.util.NoSuchElementException;
import java.util.Comparator;

import exceptions.TreeException;
import utilities.BSTreeADT;

public class TreeSearch<E extends Comparable<E>> implements Comparable<TreeSearch<E>>  {
    
    private BSTreeNode<E> value = null;

    private TreeSearch(BSTreeNode<E> value){
        this.value = value;
    }

    public static <E extends Comparable<E>> BSTreeNode<E> searchTree(MyBSTree<E> tree, BSTreeNode<E> entry, BSTreeNode<E> currentNode) {
        TreeSearch<E> _dummy = new TreeSearch<E>(currentNode);
        try{
            //Search Method
            int comparison = _dummy.value.compareTo(currentNode);

            if(comparison == 0){
                return currentNode;
            }else if (comparison < 0){
                return searchTree(tree, entry, currentNode.getLeftBranch());
            }else{
                return searchTree(tree, entry, currentNode.getRightBranch());
            }
        } catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public int compareTo(TreeSearch<E> other){
        return this.value.compareTo(other.value);
    }
}
