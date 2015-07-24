package test.eCheque;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.PrivateKey;

import org.junit.Test;

import eCheque.DigitalCertificate;
import eCheque.Digitalsigneture;

public class DigitalsignetureTest {

	@Test
	public void signetureTest() {
		ObjectInputStream objIn = null; 
		try {
			objIn = new ObjectInputStream (new FileInputStream("C:\\Users\\Darren\\git\\seng426-e-cheque-FouR\\e-Cheque Bank Side\\Bank\\Security Tools\\Security Tools\\PrivateKey.key"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // load the user private key.
		PrivateKey privKey = null;
        try {
			privKey = (PrivateKey)objIn.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			objIn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        Digitalsigneture ds = new Digitalsigneture();
        byte[] returnedSignature = null;
		try {
			returnedSignature = ds.signeture("message", privKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		if(returnedSignature != null){
			assert(true);
		}else{
			fail("Not yet implemented");
		}
	}

	@Test
	public void verifySignetureTest() {
		ObjectInputStream objIn = null;
		try {
			objIn = new ObjectInputStream (new FileInputStream("C:\\Users\\Darren\\git\\seng426-e-cheque-FouR\\e-Cheque Bank Side\\Bank\\Security Tools\\Security Tools\\PrivateKey.key"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // load the user private key.
		PrivateKey privKey = null;
        try {
			privKey = (PrivateKey)objIn.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			objIn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        Digitalsigneture ds = new Digitalsigneture();
        byte[] returnedSignature = null;
		try {
			returnedSignature = ds.signeture("message", privKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DigitalCertificate drawerDC = new DigitalCertificate();
		boolean verified = false;
		try {
			verified = ds.verifySignature(returnedSignature, "message", drawerDC.getpublicKey());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertTrue(verified);
	}

}
