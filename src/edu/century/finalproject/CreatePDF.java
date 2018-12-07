package edu.century.finalproject;
/**public class CreatePDF from the package edu.century.finalproject
 * 
 *  Century College, CSCI 2082 Fall 2018.
 *  CreatePDF.java, Programming Final Project.
 *  
 *  @author (Ping) Nalongsone Danddank
 *  @version 1.0
 *  @since 11/16/2018
 * */
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;


public class CreatePDF {
	
	private static final String DEST = "Response.pdf";
	private String filePath;
	private String userName;
	private PdfWriter writer;
	private PdfDocument pdf;
	private Document document;
	private Table table;
	private int count;
	
	
	/*public CreatePDF(String userName)
	 * @Descriptions 
	 * 		to construct and set user name by defeat file path. 
	 * @Parameter: 
	 * 		userName - String.
	 * @Precondition : userName not null.
	 * @Postcondition
	 * @Return
	 * @Thorws 	: null exception.
	 * */
	public CreatePDF(String userName, String email) {
	setFilePath(userName+"_"+DEST);
	this.userName = userName;
	initPdf(filePath, userName, email);
	}
	
	/*public CreatePDF(String filePath, String userName)
	 * @Descriptions 
	 * 		to construct and set user name and file path. 
	 * @Parameter: 
	 * 		filePath - String.
	 * 		userName - String.
	 * @Precondition : userName and filePath not null.
	 * @Postcondition
	 * @Return
	 * @Thorws 	: null exception.
	 * */
	public CreatePDF(String filePath, String userName, String email) {
		setFilePath(filePath);
		this.userName = userName;
		initPdf(filePath, userName, email);
	}
	
	/* public void setFilePath(String dest)
	 * @Descriptions 
	 * 		to set dest to FilePath. 
	 * @Parameter : dest - String
	 * @Precondition : dest must not null.
	 * @Postcondition
	 * @Return 
	 * @Thorws 	
	 * */
	public void setFilePath(String dest) {
		this.filePath = dest;
	}
	public String getFilePath() {
		return this.filePath;
	}
	/* public void initPdf(String dest, String userName)
	 * @Descriptions 
	 * 		to initiate PDF document to create a pdf file. 
	 * @Parameter : 
	 * 		dest - String
	 * 		userName - String
	 * @Precondition : dest  and userName must not null.
	 * @Postcondition
	 * @Return 
	 * @Thorws 	: FileNotFoundException
	 * */
	public void initPdf(String dest, String userName, String email){
		//Initialize PDF writer
        try {
			writer = new PdfWriter(dest);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Initialize PDF document
        pdf = new PdfDocument(writer);
        // Initialize document
        document = new Document(pdf);
        document.add(new Paragraph("USER NAME:	" + userName));
        document.add(new Paragraph("Email:\t\t\t\t" + email +"\n"));
        document.add(new Paragraph("Created Date:\t" + new Date().toString() +"\n\n"));
        count = 0;
        table = new Table(3);
        table.setWidth(UnitValue.createPercentValue(100));
        table.addCell(new Cell().add(new Paragraph(" ORDER ")));    
        table.addCell(new Cell().add(new Paragraph(" QUESTIONS ")));
        table.addCell(new Cell().add(new Paragraph(" ANSWERS ")));
	}
	
	/* public void add(ResponseList responses)
	 * @Descriptions 
	 * 		to add questions and answers to pdf file. 
	 * @Parameter : 
	 * 		responses - ResponseList
	 * 		
	 * @Precondition : responses  and question must not null.
	 * @Postcondition
	 * @Return 
	 * @Thorws 	: ResponseList null
	 * */
	public void add(ResponseList responses) {	
		ResponseNode cursor = responses.getHead();
		
		for(cursor = responses.getHead(); cursor.getLink() != null; cursor = cursor.getLink()) {
		
		    table.addCell(new Cell().add(new Paragraph(String.valueOf(++count))));
		    table.addCell(new Cell().add(new Paragraph(cursor.getQuestion()+" ")));
		    table.addCell(new Cell().add(new Paragraph(cursor.getAnswer()))); 
		}
		
		close("\n\t"+this.userName + ", you may qualify for the following benefit(s): " + cursor.getQuestion() +".");
	}
	
	/* public void close(String lastAnswer)
	 * @Descriptions 
	 * 		add the last question and close the processing. 
	 * @Parameter : 
	 * 		lastAnswer - String
	 * @Precondition : lastQ must not null.
	 * @Postcondition
	 * @Return 
	 * @Thorws 	: IOException
	 * */
	public void close(String lastAnswer) {
		document.add(table);
		document.add(new Paragraph(lastAnswer));
		//Close document
		document.close();
	}
	
	/* public void openPDF()
	 * @Descriptions 
	 * 		open the pdf file. 
	 * @Parameter : 
	 * @Precondition :
	 * @Postcondition
	 * @Return 
	 * @Thorws 	: IOException
	 * */
	public void openPDF() {
		   if (Desktop.isDesktopSupported()) {
			   File file = new File(filePath);
		      //  file.getParentFile().mkdirs();
	        	try {
					Desktop.getDesktop().open(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	}
	public void delectPDF() {

		try {
			Files.delete(Paths.get(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
