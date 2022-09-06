import java.lang.*;
import java.io.*;
import java.util.*;

import javax.swing.filechooser.FileSystemView;

import java.awt.*;


public class Blob {

	private File file;
	
	public Blob(String fileLoc) {
		
		new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()).mkdirs();
		
		
		StringBuilder builder = new StringBuilder(fileLoc);
		
		for (int i = 0; i < fileLoc.length(); i++) {
			if (builder.charAt(i)==('/')) {
				builder.insert(i, '/');
				i++;
			}
		}
		
		fileLoc = builder.toString();
		
		File nfile = new File(fileLoc);
		
	}
	
}
