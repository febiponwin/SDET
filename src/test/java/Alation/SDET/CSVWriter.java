package Alation.SDET;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class CSVWriter {
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String FILE_HEADER = "No,BookName,Author,PaperBack,HardCover,Kindle";

	
	public static void writeCSV(List<List<String>> details,String fileName) {
		
		
		FileWriter fileWriter = null;
		
		try {
			fileWriter = new FileWriter(fileName);
			fileWriter.append(FILE_HEADER.toString());
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			for(List<String> row:details) {
				
				for(int i=0;i<row.size();i++) {
					fileWriter.append(row.get(i));
					if(i!=(row.size()-1)) {//this block of code is to omit having comma after the last value
					fileWriter.append(COMMA_DELIMITER);
					}
				}
				
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
			

		}catch(Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		}finally {
			try {
				fileWriter.flush();
				fileWriter.close();
				
			}catch(IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();

			}
		}
		
		
		
	}
	

}
