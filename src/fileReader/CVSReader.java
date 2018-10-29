package fileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import edu.century.finalproject.BTNode;

public class CVSReader {

	
	/**TODO
	 * @description 
	 * 	Takes a String that represents the location on disk of a CSV file that contains the stored question flow and then loads it into a tree 
	 * @param target
	 * 	the target location on disk of the CSV file
	 * @return
	 * @throws IOException
	 * 	can throw a IOException if the target file can't be read
	 */
	public static BTNode<String> readFile(String target) throws IOException{
		
		String[][] CVSArray = readIn(target);
		
		
		
		
		return null;
		
	}

	
	/**
	 * @description
	 * 	loads the target CVS file into a 2D array
	 * @param target
	 * @return
	 * @throws FileNotFoundException 
	 */
	private static String[][] readIn(String target) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(target));
		Stack<String> initalReadStack = new Stack<String>();
		String line;
		while((line = reader.readLine()) != null) {
			initalReadStack.push(line);
		}
		
		String[][] finalArray = parseStack(initalReadStack.clone(), ',');
		
		reader.close();
		return finalArray;
	}


	/**
	 * @description
	 * 	parses stack of strings into a 2D array based on the passed separator
	 * @param stack
	 * @param separator
	 * @post
	 * 	will destroy the stack you pass it
	 * @return
	 */
	private static String[][] parseStack(Stack<String> stack, char separator) {
		int stackSize = stack.getCount();
		String[][] output = new String[stackSize][4];
		stack = stack.getReversed();
		String line;
		for(int i = 0; i <= stackSize; i++) {
			line = stack.pop();
			output[i] = line.split("(" + separator + ")");
		}
		return output;
	}
}
