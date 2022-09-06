import java.lang.*;
import java.io.*;
import java.util.*;

import javax.swing.filechooser.FileSystemView;

public class GitTester {

	public static void main (String[]args) {
		System.out.println(FileSystemView.getFileSystemView().getDefaultDirectory().getPath());
	}
	
}
