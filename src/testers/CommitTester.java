package testers;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import git.Commit;

public class CommitTester{

	private Commit commit;
	
	@Before
	public void setUp() throws Exception {
		Commit commit1 = new Commit("./objects/59c4dd553b054c2028eb5179b3d2c3238f9ae84a", "Booblah", "WillSherwood", null);
		commit1.create();
		Commit commit2 = new Commit("./objects/59c4de553b054c2028eb5179b3d2c3238f9ae84a", "Welcome", "Charles", commit1);
		commit2.create();
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void test() {
		assertTrue(new File("./objects/59c4dd553b054c2028eb5179b3d2c3238f9ae84a").exists());
		assertTrue(new File("./objects/59c4de553b054c2028eb5179b3d2c3238f9ae84a").exists());
	}

}