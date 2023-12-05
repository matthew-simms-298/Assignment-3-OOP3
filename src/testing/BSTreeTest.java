package testing;

import static org.junit.Assert.*;

import org.junit.Test;
import referenceBasedTreeImplementation.*;
public class BSTreeTest<E> {

	MyBSTree tree = new MyBSTree();
	@Test
	public void testAdd() {
		BSTreeNode<E> root = new BSTreeNode<>(1, null, root.getLeftBranch(), null);
		tree.add(root);
		BSTreeNode<E> nodeA = new BSTreeNode<>(2, null, null, root);
		tree.add(nodeA);
		BSTreeNode<E> nodeB = new BSTreeNode<>(3, null, null, root);
		tree.add(nodeB);
	}

}
