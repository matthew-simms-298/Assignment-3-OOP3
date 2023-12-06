package testing;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import referenceBasedTreeImplementation.*;

public class BSTreeTest<E> {

	MyBSTree tree = new MyBSTree();

	@Test
	public void testAdd() throws IOException {
		BufferedReader bufferedReaderTextFile = new BufferedReader(new FileReader("src/utilities/textfile.txt"));
		String line = bufferedReaderTextFile.readLine();

		while (line != null) {
			if (line != "") {
                line = bufferedReaderTextFile.readLine();
                //Save line to MyBSTree 
                assertEquals("Failed", true, tree.add(line));
            }
		}
		bufferedReaderTextFile.close();
	}

}


