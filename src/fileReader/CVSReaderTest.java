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
		fail("Not yet implemented");
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
