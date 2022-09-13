import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import javax.swing.filechooser.FileSystemView;

public class Index {
	
	private HashMap<String,String> codes;

	public Index () {
		
		codes = new HashMap<String,String>();
		
	}
	
	
	public void initialize () {
		
		if (System.getProperty("os.name").equals("Windows 10")) {
			new File(".\\objects").mkdirs(); //creates objects folder
			new File(".\\index.txt"); //creates index file
		} else {
			//if not windows assumed to be unix based system
			new File("./objects").mkdirs(); //creates objects folder
			new File("./index.txt"); //creates index file
		}
		
	}
	
	public void addBlob(String fileLoc) throws NoSuchAlgorithmException, IOException { //adds blob
		Blob blob = new Blob (fileLoc); //creates new blob
		codes.put(fileLoc, blob.getSha()); //adds blob to hashmap
		printHashMap(); //updates hashmap
	}
	
	public void deleteBlob(String fileLoc) throws IOException { //deletes blob
		
		File myObj = null;
		
		if (System.getProperty("os.name").equals("Windows 10")) {
			myObj =  new File(".\\objects\\" + codes.get(fileLoc) + ".txt"); //creates dummy file (overwriting existing file
		} else {
			//if not windows assumed to be unix based system
			myObj =  new File("./objects/" + codes.get(fileLoc) + ".txt"); //creates dummy file (overwriting existing file
		}

		myObj.delete(); //deletes it
		codes.remove(fileLoc);
		printHashMap();
	}
	
	public void printHashMap() throws IOException { //fixes index file based on current hashmap
		Writer output = null;
		
		if (System.getProperty("os.name").equals("Windows 10")) {
			output = new BufferedWriter(new FileWriter(".\\index.txt"));  //clears file every time
		} else {
			//if not windows assumed to be unix based system
			output = new BufferedWriter(new FileWriter("./index.txt"));  //clears file every time
		}
		
		
		for (String s: codes.keySet()) {
			output.append(s + " : " + codes.get(s) + "\n");
		}
		output.close();
	}
	
}
