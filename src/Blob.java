import java.lang.*;
import java.math.BigInteger;
import java.security.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;
import java.util.*;

import javax.swing.filechooser.FileSystemView;

import java.awt.*;


public class Blob {

	private String sha1;
	private String text;
	private File file;
	
	public Blob(String fileLoc) throws IOException, NoSuchAlgorithmException {
		
//		new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()).mkdirs();
		
		
		Path fileOrigin = Paths.get(fileLoc); //finds path for desired file
		String content = Files.readString(fileOrigin); //gets content of file
		text = content; //sets private instance variable
		
		MessageDigest md = MessageDigest.getInstance("SHA-1"); //generates sha1
		byte[] messageDigest = md.digest(content.getBytes());
		BigInteger no = new BigInteger(1, messageDigest);
		String hashtext = no.toString(16);
		while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
		sha1 = hashtext;
		
		Path p = null;
		if (System.getProperty("os.name").equals("Windows 10")) {
			p = Paths.get(".\\objects\\" + hashtext + ".txt"); //creates path with hashtext as name in objects folder
		} else {
			//if not windows assumed to be unix based system
			p = Paths.get("./objects/" + hashtext + ".txt");
		}
		
		
        try {
            Files.writeString(p, content, StandardCharsets.ISO_8859_1); //creates file
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public String getSha() {
    	return sha1;
    }
	
	public String getText() {
		return text;
	}
	
}
