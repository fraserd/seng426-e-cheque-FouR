package test.eCheque;

import static org.junit.Assert.*;

import org.junit.Test;

import eCheque.ChequeJFrame;

public class ChequeJFrameTest {
	/**
	 * Test constructor of ChequeJFrame
	 */
	@Test
	public void ChequeJFrameConstructor() {
		try{
			ChequeJFrame cjf = new ChequeJFrame(null);
			assert(true);
		}catch(Exception e){
			fail();
		}
	}
}
