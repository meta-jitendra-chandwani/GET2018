import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Before;
import org.junit.Test;


public class CounsellingProcessJunitTest {
	private CounsellingProcess cp;

	@Before
	public void initialize(){
		cp = new CounsellingProcess();
	}
	
	@Test
	public void testCounsellingProgram() throws IOException, EncryptedDocumentException, InvalidFormatException {
		cp.addProgram("Programs.xlsx");
		cp.addStudent("Student.xlsx");
		cp.allotPrograms();
	}

	@Test
	public void programFileNotExistTest() {
		try {
			cp.addProgram("C:\\Users\\User23\\workspace\\Counselling\\src\\Programs.xlsx");
		} catch (IOException ex) {
			assertEquals("File Not Found while adding Programs",
					ex.getMessage());
		}
	}

	@Test
	public void studentFileNotExistTest() throws EncryptedDocumentException, InvalidFormatException {
		try {
			cp.addStudent("C:\\Users\\User23\\workspace\\Counselling\\src\\Student.xlsx");
		} catch (IOException ex) {
			assertEquals("File Not Found while adding Students",
					ex.getMessage());
		}
	}
}