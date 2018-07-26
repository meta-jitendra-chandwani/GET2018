import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LcmTest {
	private LcmHcf lcm;
	private int number1;
	private int number2;
	private int result;

	/*
	 * Initialize the object
	 */
	@Before
	public void initializeObject() {
		lcm = new LcmHcf();
	}

	/*
	 * Parameterized Constructor - initialize the variable
	 * @param number1 - first number
	 * @param number2 - second number
	 * @pram result - resultant value
	 */
	public LcmTest(int number1, int number2, int result) {
		this.number1 = number1;
		this.number2 = number2;
		this.result = result;
	}

	/*
	 * Collection of Object -  contained the parameterized test case
	 * @return Collection Object
	 */
	@Parameters
	public static Collection<Object[]> maxMirror() {
		return Arrays.asList(new Object[][] { { 6, 9, 18 } });
	}

	/*
	 * Test Case evaluation
	 * Check whether actual value is same as expected value
	 */
	@Test
	public void lcmTest() {
		assertEquals(lcm.lcm(number1, number2), result);

	}
}
