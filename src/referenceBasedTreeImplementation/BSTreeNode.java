package referenceBasedTreeImplementation;

public class BSTreeNode<E> implements Comparable<BSTreeNode<E>> {
    private E nodeData;
    private BSTreeNode<E> leftBranch;
    private BSTreeNode<E> rightBranch;
    private BSTreeNode<E> rootBranch;

    
    
    public BSTreeNode() {}
    
    public BSTreeNode(E nodeData, BSTreeNode<E> rightBranch, BSTreeNode<E> leftBranch, BSTreeNode<E> rootBranch) {
        this.nodeData = nodeData;
        this.rightBranch = rightBranch;
        this.leftBranch = leftBranch;
        this.rootBranch = rootBranch;
    }

    public boolean isTreeNodeEmpty(){
        if (this.nodeData == null) {
            return true;

        }
        else {
            return false;
        }
    }

    public E getNodeData(){
        return nodeData;
    }

    public void setNodeData(E nodeData) {
        this.nodeData = nodeData;
    }
    public BSTreeNode<E> getLeftBranch() {
        return leftBranch;
    }

    public void setLeftBranch(BSTreeNode<E> leftBranch) {
        this.leftBranch = leftBranch;
    }

    public BSTreeNode<E> getRightBranch() {
        return rightBranch;
    }

    public void setRightBranch(BSTreeNode<E> rightBranch) {
        this.rightBranch = rightBranch;
    }

    public BSTreeNode<E> getRootBranch() {
        return rootBranch;
    }

    public void setRootBranch(BSTreeNode<E> rootBranch) {
        this.rootBranch = rootBranch;
    }

    @Override
    public int compareTo(BSTreeNode<E> other){
        return this.compareTo(other);
    }
}