package testing;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import exceptions.TreeException;
import referenceBasedTreeImplementation.*;

public class BSTreeTest<E extends Comparable<? super E>> {

	MyBSTree<String> tree = new MyBSTree<String>();
	
	public void fillTree() throws IOException {
		BufferedReader bufferedReaderTextFile = new BufferedReader(new FileReader("src/utilities/textfile.txt"));
		String line = bufferedReaderTextFile.readLine();

		while (line != null) {
				tree.add(line);
                line = bufferedReaderTextFile.readLine();
		}
		bufferedReaderTextFile.close();
	}
	
	@Test
	public void testAdd() throws IOException {
		
		boolean  newLine = tree.add("This is a new line for the story");		

		assertEquals("Couldn't add new Node", true, newLine);
	}
	
	@Test
	public void testSearch() throws IOException {
		
		String lineToSearch = tree.search("this is a line").toString();
		
		assertEquals("I don't know how you could find this lol", tree.next(), lineToSearch);
	}
	
	@Test
	public void testContains() throws TreeException {
		
		boolean notReal = tree.contains("A Line to search");
		boolean alsoNotReal = tree.contains("another line");
		
		assertEquals("How did you find this?", false, notReal);
		assertEquals("Wait how?", false, alsoNotReal);
	}
	
	@Test
	public void testIsEmpty() {
		tree.clear();
		assertEquals("Tree is not empty", true, tree.isEmpty());
	}

}


