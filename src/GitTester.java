import java.lang.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.util.*;

import javax.swing.filechooser.FileSystemView;

public class GitTester {

	public static void main (String[]args) {
		System.out.println(FileSystemView.getFileSystemView().getDefaultDirectory().getPath());
		new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()).mkdirs();
		Path p = Paths.get(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\text232.txt");
		try {
			Files.writeString(p,  "test", StandardCharsets.ISO_8859_1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
