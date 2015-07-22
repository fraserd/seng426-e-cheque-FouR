package test.eCheque;

import static org.junit.Assert.*;

import org.junit.Test;

import eCheque.EChequeRegistration;

public class EChequeRegistrationTest {

	/**
	 * Test setters and getters of EChequeRegistration
	 */
	@Test
	public void EChequeRegistrationBankNameTest() {
		EChequeRegistration ecr = new EChequeRegistration();
		
		try{
			ecr.setBankName("Bank Name");
			assert(ecr.getBankName().equals("Bank Name"));
		}catch(Exception e){
			fail();
		}
	}
		
	/**
	 * Test setters and getters of EChequeRegistration
	 */
	@Test
	public void EChequeRegistrationBankAddressTest() {
		EChequeRegistration ecr = new EChequeRegistration();
		
		try{
			ecr.setBankAddress("url");
			assert(ecr.getBankAddress().equals("url"));
		}catch(Exception e){
			fail();
		}
	}
	
	/**
	 * Test setters and getters of EChequeRegistration
	 */
	@Test
	public void EChequeRegistrationBankAccountTest() {
		EChequeRegistration ecr = new EChequeRegistration();
		
		try{
			ecr.setAccountNumber("account");
			assert(ecr.getAccountNumber().equals("account"));
		}catch(Exception e){
			fail();
		}
	}
	
	/**
	 * Test setters and getters of EChequeRegistration
	 */
	@Test
	public void EChequeRegistrationClientNameTest() {
		EChequeRegistration ecr = new EChequeRegistration();
		
		try{
			ecr.setClientName("cName");
			assert(ecr.getClientName().equals("cName"));
		}catch(Exception e){
			fail();
		}
	}
	
	/**
	 * Test setters and getters of EChequeRegistration
	 */
	@Test
	public void EChequeRegistrationWalletLocationTest() {
		EChequeRegistration ecr = new EChequeRegistration();
		
		try{
			ecr.setEWalletLoaction("path");
			assert(ecr.getEWalletLoaction().equals("path"));
		}catch(Exception e){
			fail();
		}
	}
	
	/**
	 * Test setters and getters of EChequeRegistration
	 */
	@Test
	public void EChequeRegistrationUserNameTest() {
		EChequeRegistration ecr = new EChequeRegistration();
		
		try{
			ecr.setUsername(1234);
			assert(ecr.getUsername() == 1234);
		}catch(Exception e){
			fail();
		}
	}
	
	/**
	 * Test setters and getters of EChequeRegistration
	 */
	@Test
	public void EChequeRegistrationPasswordTest() {
		EChequeRegistration ecr = new EChequeRegistration();
		
		try{
			ecr.setPasword(5678);
			assert(ecr.getPasword() == 5678);
		}catch(Exception e){
			fail();
		}
	}

}
