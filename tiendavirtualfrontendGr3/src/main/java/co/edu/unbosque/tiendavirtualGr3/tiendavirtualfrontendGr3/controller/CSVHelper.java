package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
	public static String TYPE = "text/csv";
	
	public static boolean hasCSVFormat(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}
	public static List<String[]> csvToTutorials(InputStream is){
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser (fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());){			    
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			
			List<String[]> records = new ArrayList<>();	
			for (CSVRecord record:csvRecords) {
				String[] line = new String[record.size()];
				for (int i = 0; i < line.length; i++) {
					line[i]=record.get(i);
				}
				records.add(line);
			}
		return records;	
		} catch (IOException e) {
			throw new RuntimeException("Fail to parse CSV file: "+e.getMessage());
		}
				
	}

}
