import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SplitarrayTest {
private ArrOperation split;
private int array[];
private int value;
	 @Before
		public void initializeObject() {
		 split=new ArrOperation();
		}
	 
	 public SplitarrayTest(int array[],int value) {
		 this.array=array;
		 this.value=value;	
	}
	
	 @Parameters
	 public static Collection<Object[]> maxMirror() {
		 int splitArray[]={ 1, 1, 1, 2, 1  };
		 int splitArray1[] = { 2, 1, 1, 2, 1 };
		 int splitArray2[] = {10, 10};
			return Arrays.asList(new Object[][] { { splitArray,3 },{splitArray1,-1},{splitArray2,1} });
		}
	
	 @Test
		public void splitArrayTest() {
			assertEquals(split.splitArray(array),value );
		}
}
