package fileReader;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.century.finalproject.BTNode;

class CVSReaderTest {

	@Test
	void testReadFile() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateTree() {
		Stack<String> testStack = new Stack<String>();
		testStack.push("H,Have you served on Active Duty for purposes other than training?,Q002,Q001");
		testStack.push("Q001,Other flowchart,,");
		testStack.push("Q002,Did you receive an honorable discharge?,Q003,Q004");
		testStack.push("Q003,Did you serve for at least 90 days of aggregate Active Duty after Sept. 11 2001?,Q008,Q005");
		String[][] CSVArray = CSVReader.parseStack(testStack, ",");
		BTNode actual = CSVReader.createTree(CSVArray);
		
		BTNode expected = new BTNode("Have you served onActive Duty for purposes other than training?");
		expected.setRight(new BTNode("Other flowchart"));
		BTNode two = new BTNode("Did you receive an honorable discharge?");
		expected.setLeft(two);
		BTNode three = new BTNode("Did you serve for at least 90 days of aggregte Active Duty after Sept. 11 2001?");
		two.setLeft(three);
		
		BTNode expCursor = expected;
		BTNode actCursor = actual;
		
		while(expCursor.getLeft() != null) {
			assertEquals(expCursor.getData(), actCursor.getData());
			expCursor = expCursor.getLeft();
			actCursor = actCursor.getLeft();
		}
		
		
	}

	@Test
	void testReadIn() {
		String target = "D:/GitHub/CSCI2082/FinalProject/src/fileReader/TestVeteran.csv";
		Stack<String> testStack = new Stack<String>();
		testStack.push("H,Have you served on Active Duty for purposes other than training?,Q002,Q001");
		testStack.push("Q001,Other flowchart,,");
		testStack.push("Q002,Did you receive an honorable discharge?,Q003,Q004");
		testStack.push("Q003,Did you serve for at least 90 days of aggregate Active Duty after Sept. 11 2001?,Q008,Q005");
		String[][] expected = CSVReader.parseStack(testStack, ",");
		try {
			String[][] actual = CSVReader.readIn(target);
			
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 4; j++) {
					assertEquals(actual[i][j],expected[i][j]);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	void testParseStack() {
		Stack<String> testStack = new Stack<String>();
		testStack.push("H,Have you served on Active Duty for purposes other than training?,Q002,Q001");
		testStack.push("Q001,Other flowchart,,");
		testStack.push("Q002,Did you receive an honorable discharge?,Q003,Q004");
		testStack.push("Q003,Did you serve for at least 90 days of aggregate Active Duty after Sept. 11 2001?,Q008,Q005");
		
		String[][] actual = CSVReader.parseStack(testStack, ",");
		
		String[][] expected = {{"H","Have you served on Active Duty for purposes other than training?","Q002","Q001"},
				{"Q001","Other flowchart",null,null},
				{"Q002","Did you receive an honorable discharge?","Q003","Q004"},
				{"Q003","Did you serve for at least 90 days of aggregate Active Duty after Sept. 11 2001?","Q008","Q005"}};
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 4; j++) {
				assertEquals(actual[i][j],expected[i][j]);
			}
		}

		
	}
	
	
	@Test
	void testFindLink() {
		int expected = 1;
		int actual = CSVReader.findLink("001");
		assertEquals(expected,actual);
	}

}
