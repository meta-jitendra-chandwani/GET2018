package SetProblem;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class UnionTest {
	intSet set;
	private int array1[];
	private int array2[];
	private int result[];

	@Before
	public void initializeObject() {
		set = new intSet();
	}

	public UnionTest(int array1[], int array2[], int result[]) {
		this.array1 = array1;
		this.array2 = array2;
		this.result = result;
	}

	@Parameters
	public static Collection<Object[]> maxMirror() {
		int setArray1[] = { 4, 5, 9, 6, 10 };
		int setArray2[] = { 1, 2, 4, 9 };
		int result[] = { 1, 2, 4, 5, 6, 9, 10 };

		return Arrays
				.asList(new Object[][] { { setArray1, setArray2, result } });
	}

	@Test
	public void isMemberTest() {
		assertArrayEquals(set.union(array1, array2), result);
	}

}
