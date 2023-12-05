package referenceBasedTreeImplementation;

public class BSTreeNode<E> {
    private BSTreeNode node;
    private String nodeData;

    public BSTreeNode() {}
    
    public BSTreeNode(BSTreeNode node, String nodeData) {
        this.node = node;
        this.nodeData = nodeData;
    }
}