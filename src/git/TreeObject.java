package git;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TreeObject implements GitUtils {

	public String[] things;
	public File writing;
	public String fileContents = "";
	public String sha;
	
	public TreeObject (String[] inp) {
		things = inp;
		for (String str : things) {
			fileContents = fileContents + str + "\n";
		}
		sha = GitUtils.StringToSha(fileContents);
		writing = new File(sha);
		printFile();
	}
	
	private boolean printFile() {
		try {
			PrintWriter au = new PrintWriter(writing);
			for (String str : things) {
				au.append(str + "\n");
			}
			au.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
