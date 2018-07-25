import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LcmHcfTest {
private LcmHcf lcm;
private int number1;
private int number2;
private int result;
	 @Before
		public void initializeObject() {
		 lcm=new LcmHcf();
		}
	 
	 public LcmHcfTest(int number1,int number2,int result) {
		 this.number1=number1;
		 this.number2=number2;	
		 this.result=result;
	}
	
	 @Parameters
	 public static Collection<Object[]> maxMirror() {
			return Arrays.asList(new Object[][] { { 6,9,18 } });
		}
	
	 @Test
		public void lcmTest() {
			assertEquals(lcm.lcm(number1, number2),result);
			assertNotEquals(lcm.hcf(number1, number2), result);
		}
}
