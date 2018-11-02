package fileReader;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class CVSReaderTest {

	@Test
	void testReadFile() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateTree() {
		fail("Not yet implemented");
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
		String[][] actual = CSVReader.parseStack(testStack, ",");
		String[][] expected = {{"H","Have you served on Active Duty for purposes other than training?","Q002","Q001"},{"Q001","Other flowchart",null,null}};
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
