package Command;

import static org.junit.Assert.*;

import org.junit.Test;

public class VirtualCommandPromptTest {

	@Test
	public void test() {
		VirtualCommandPrompt vcp = new VirtualCommandPrompt();
		vcp.start();
	}

}
