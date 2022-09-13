import java.lang.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.io.*;
import java.util.*;

import javax.swing.filechooser.FileSystemView;

public class GitTester {

	public static void main (String [] args) throws NoSuchAlgorithmException, IOException {
//		System.out.println(FileSystemView.getFileSystemView().getDefaultDirectory().getPath());
//		new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+"\\objects").mkdirs();
//		Path p = Paths.get(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\text232.txt");
//		try {
//			Files.writeString(p,  "test", StandardCharsets.ISO_8859_1);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		Index index = new Index();
		index.initialize();
		index.addBlob("text1.txt");
		index.addBlob("text2.txt");
		index.deleteBlob("text1.txt");
		
		System.out.print(System.getProperty("os.name"));
		
	}
	
}
