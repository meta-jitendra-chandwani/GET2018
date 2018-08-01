import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ClumpTest {
	ArrOperation operation;
	private int array[];
	private int value;
	 @Before
		public void initializeObject() {
			operation = new ArrOperation();
		}
	 
	 public ClumpTest(int array[],int value) {
		 this.array=array;
		 this.value=value;	
	}
	
	 @Parameters
	 public static Collection<Object[]> maxMirror() {
		 int countClumpArray[]={  1, 2, 2, 3, 4, 4 };
		 int countClumpArray1[]={1, 1, 2, 1, 1 };
		 int countClumpArray2[]={ 1, 1, 1, 1};

			return Arrays.asList(new Object[][] { { countClumpArray,2 },{ countClumpArray1,2 },{ countClumpArray2,1 } });
		}
	
	 @Test
		public void countClumpTest() {
			assertEquals(operation.countClumps(array),value );
		}
}