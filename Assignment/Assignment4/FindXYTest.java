import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FindXYTest {
	ArrOperation operation;
	private int array[];
	private int value[];
	private int X;
	private int Y;
	 @Before
		public void initializeObject() {
			operation = new ArrOperation();
		}
	 
	 public FindXYTest(int array[],int X,int Y,int value[]) {
		 this.array=array;
		 this.X=X;
		 this.Y=Y;
		 this.value=value;	
	}
	
	 @Parameters
	 public static Collection<Object[]> maxMirror() {
		 int X=4,Y=5;
		 int findXYArray[]={ 5, 4, 9, 4, 9, 5 };
		 int findXYArray1[]={1, 4, 1, 5};
		 int findXYArray2[]={1, 4, 1, 5, 5, 4, 1};
		 int resultfindXY[]={9, 4, 5, 4, 5, 9};
		 int resultfindXY1[]={1, 4, 5, 1};
		 int resultfindXY2[]={1, 4, 5, 1, 1, 4, 5};
			return Arrays.asList(new Object[][] { { findXYArray,X,Y,resultfindXY },{ findXYArray1,X,Y,resultfindXY1 },{ findXYArray2,X,Y,resultfindXY2 } });
		}
	
	 @Test
		public void findXYTest() {
			assertArrayEquals(operation.findXY(array,X,Y),value);
		}
}