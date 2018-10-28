package edu.century.finalproject;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class Driver {


public static void main(String[] args) {
		
		ArrayList<String[]> arr2D = new ArrayList<>();
		BTNode<String> veteran;
		try {
			Scanner read = new Scanner(new File("veteran.csv"));
			final int size = 4;
			while(read.hasNextLine()) {
			String[] line = new String[size];
			String lineCSV = read.nextLine();
			String [] csvL =lineCSV.split("\t");
			for (int i=0; i < csvL.length; i++) {
				line[i] = csvL[i];
			}
		
			arr2D.add(line);	
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		veteran = new BTNode<>(arr2D.get(0)[0], arr2D.get(0)[1]);
		for(String[] rows : arr2D) {
			if(rows[2]!=null && rows[3] != null) {
			//System.out.println(rows[0]+"\t" +rows[1]+"\t"+rows[2]+"\t"+rows[3]);
			String leftData = "";
			String rightData = "";
			for(String[] rowf : arr2D) {
				if(rows[2].equals(rowf[0])){
					leftData = rowf[1];
				}
				if(rows[3].equals(rowf[0])){
					rightData = rowf[1];
				}
			}
				
			veteran.insert(rows[0], rows[2], leftData, rows[3], rightData);
			}
		}
		veteran.printYN();		
	}



	
}
