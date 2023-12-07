package referenceBasedTreeImplementation;

public class BSTreeNode<E> implements Comparable<BSTreeNode<E>> {
    private E nodeData;
    private BSTreeNode<E> leftBranch;
    private BSTreeNode<E> rightBranch;

    
    
    public BSTreeNode() {}
    
    public BSTreeNode(E nodeData) {
        this.nodeData = nodeData;

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
    
    @Override
    public int compareTo(BSTreeNode<E> other){
        return this.compareTo(other);
    }
}