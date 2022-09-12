import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import javax.swing.filechooser.FileSystemView;

public class Index {
	
	private HashMap<String,String> codes;

	public Index () {
		
		codes = new HashMap<String,String>();
		
	}
	
	public void initialize () {
		
		new File(".\\objects").mkdirs();
		new File(".\\index");
		
	}
	
	public void addBlob(String fileLoc) throws NoSuchAlgorithmException, IOException {
		Blob blob = new Blob (fileLoc);
		codes.put(fileLoc, blob.getSha());
		printHashMap();
	}
	
	public void deleteBlob(String fileLoc) throws IOException {
		File myObj = new File(".\\objects\\" + codes.get(fileLoc)); 
		myObj.delete();
		codes.remove(fileLoc);
		printHashMap();
	}
	
	public void printHashMap() throws IOException {
		Writer output;
		output = new BufferedWriter(new FileWriter(".\\index"));  //clears file every time
		for (String s: codes.keySet()) {
			output.append(s + " : " + codes.get(s) + "\n");
		}
		output.close();
	}
	
	
	
}
