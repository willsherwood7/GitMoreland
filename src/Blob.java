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
		
		
		
		Path p = Paths.get(".\\objects\\" + hashtext); //creates path with hashtext as name in objects folder
        try {
            Files.writeString(p, content, StandardCharsets.ISO_8859_1); //creates file
        } catch (IOException e) {
            // TODO Auto-generated catch block
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
