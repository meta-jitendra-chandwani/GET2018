import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ArrOperationTest {
	ArrOperation operation;
	private int array[];
	private int value;
	 @Before
		public void initializeObject() {
			operation = new ArrOperation();
		}
	 
	 public ArrOperationTest(int array[],int value) {
		 this.array=array;
		 this.value=value;	
	}
	
	 @Parameters
	 public static Collection<Object[]> maxMirror() {
		 int maxMirrorArray[]={ 1, 2, 3, 8, 9, 3, 2, 1 };
		 int maxMirrorArray1[]={7, 1, 4, 9, 7, 4, 1};
		 int maxMirrorArray2[]={1, 2, 1, 4};
		 int maxMirrorArray3[]={1, 4, 5, 3, 5, 4, 1};

			return Arrays.asList(new Object[][] { { maxMirrorArray,3 },{ maxMirrorArray1,2 },{ maxMirrorArray2,3 },{ maxMirrorArray3,7 } });
		}
	
	 @Test
		public void maxMirrorPositveTest() {
			assertEquals(operation.maxMirror(array),value );
		}
}