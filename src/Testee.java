import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Testee {
	public static void main (String[]args) throws NoSuchAlgorithmException, IOException {
		Commit commit = new Commit("ptree","sumamr","meauthor",null);
		commit.create();
	}
}
