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
		
		new File(".\\objects").mkdirs(); //creates objects folder
		new File(".\\index"); //creates index file
		
	}
	
	public void addBlob(String fileLoc) throws NoSuchAlgorithmException, IOException { //adds blob
		Blob blob = new Blob (fileLoc); //creates new blob
		codes.put(fileLoc, blob.getSha()); //adds blob to hashmap
		printHashMap(); //updates hashmap
	}
	
	public void deleteBlob(String fileLoc) throws IOException { //deletes blob
		File myObj = new File(".\\objects\\" + codes.get(fileLoc)); //creates dummy file (overwriting existing file
		myObj.delete(); //deletes it
		codes.remove(fileLoc);
		printHashMap();
	}
	
	public void printHashMap() throws IOException { //fixes index file based on current hashmap
		Writer output;
		output = new BufferedWriter(new FileWriter(".\\index"));  //clears file every time
		for (String s: codes.keySet()) {
			output.append(s + " : " + codes.get(s) + "\n");
		}
		output.close();
	}
	
	
	
}
