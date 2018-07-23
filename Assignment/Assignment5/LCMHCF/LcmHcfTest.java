import static org.junit.Assert.*;

import org.junit.Test;


public class LcmHcfTest {

	@Test
	public void test() {
		LcmHcf lcm=new LcmHcf();
		int actual=lcm.hcf(6,9);
		assertEquals(3, actual);
		int actuallcm=lcm.lcm(6, 9);
		assertEquals(18, actuallcm);
	}

}
