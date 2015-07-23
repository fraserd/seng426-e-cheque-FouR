package test.eCheque;

import static org.junit.Assert.*;

import org.junit.Test;

import eCheque.EBankingJFrame;
import eCheque.EChequeRegistration;

public class EBankingJFrameTest {

	/**
	 * Test constructor of EBankingJFrame
	 */
	@Test
	public void EBankingJFrameTest() {
		EChequeRegistration ecr = new EChequeRegistration();
		
		try{
			EBankingJFrame ebj = new EBankingJFrame(ecr);
			assert(true);
		}catch(Exception e){
			fail();
		}
	}

}
