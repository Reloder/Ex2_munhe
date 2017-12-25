import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/**
 * This class represent a csv file which contain records of gps wifi data.
 *
 */
public class CsvFile {
	
	private ArrayList<Record> records = new ArrayList<Record>(); // records list
	private String file_path; // the file path
	public boolean isColumnSpace = true; // if there is a column space between the each wifi data and another in the csv file
	
	
	public CsvFile(String path_txt,boolean isColumnSpace) throws IOException {
		this.isColumnSpace = isColumnSpace;
		this.file_path = path_txt;
		readCsvFile(path_txt);
	}
	
	private CsvFile() {
		
	}
	
	/**
	 * Read the csv file and store his data in the class fields
	 * @param path_txt = the path to the csv file in the system
	 * @throws IOException
	 */
	private void readCsvFile(String path_txt) throws IOException {
		File csv = new File(path_txt);
		
		FileReader filereader= new FileReader(csv);
		@SuppressWarnings("resource")
		BufferedReader br=new BufferedReader(filereader);
		String line;
		
		while((line = br.readLine()) != null)
		{
			Record record = new Record(line,isColumnSpace);
			records.add(record);
		}
	}
	
	
	/**
	 * duplicate the CsvFile object with all of his components
	 * @return
	 */
	public CsvFile duplicate() {
		CsvFile file = new CsvFile();
		file.isColumnSpace = this.isColumnSpace;
		file.records = (ArrayList<Record>)this.records.clone();
		file.file_path = this.file_path;
		return file;
	}
	
	/**
	 * get the records
	 * @return
	 */
	public ArrayList<Record> getRecords() {
		return records;
	}
	
	/**
	 * get the file path
	 * @return
	 */
	public String getFilePath() {
		return this.file_path;
	}
	
	/**
	 * Get a path and write to it a new csv file, containing the data of this CsvFile object.
	 * @param path
	 */
	public void writeToCsv(String path) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File(path));
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		}
		
		String csv_build = "";
		for(int i=0;i<records.size();i++) {
			Record rec = records.get(i);
			
			csv_build += rec.toString() + "\n"; 
		}
		
		
		pw.write(csv_build);
        pw.close();
	}
}
