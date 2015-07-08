package test.eCheque;

import static org.junit.Assert.*;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

import org.junit.Test;

import eCheque.DigitalCertificate;
import eCheque.RSAGenerator;

public class DigitalCertificateTest {

	@Test
	public void testSetAndGetHolderName() {
		
		DigitalCertificate dc = new DigitalCertificate();
		String holderName;
		
		assertNull(dc.getHolderName());
		
		holderName = "";
		dc.setHolderName(holderName);
		assertEquals(holderName, dc.getHolderName());
		
		holderName = "John Doe";
		dc.setHolderName(holderName);
		assertEquals(holderName, dc.getHolderName());
		
		dc.setHolderName(null);
		assertNull(dc.getHolderName());
	}
	
	@Test
	public void testSetAndGetSubject() {
		
		DigitalCertificate dc = new DigitalCertificate();
		String subject;
		
		assertNull(dc.getSubject());
		
		subject = "";
		dc.setSubject(subject);
		assertEquals(subject, dc.getSubject());
		
		subject = "Something";
		dc.setSubject(subject);
		assertEquals(subject, dc.getSubject());
		
		dc.setSubject(null);
		assertNull(dc.getSubject());
	}
	
	@Test
	public void testSetAndGetIssuer() {
		
		DigitalCertificate dc = new DigitalCertificate();
		String issuer;
		
		assertNull(dc.getIssuer());
		
		issuer = "";
		dc.setIssuer(issuer);
		assertEquals(issuer, dc.getIssuer());
		
		issuer = "CertificateIssuer";
		dc.setIssuer(issuer);
		assertEquals(issuer, dc.getIssuer());
		
		dc.setIssuer(null);
		assertNull(dc.getIssuer());
	}
	
	@Test
	public void testSetAndGetSerialNumber() {
		
		DigitalCertificate dc = new DigitalCertificate();
		String serialNumber;
		
		assertNull(dc.getSerialNumber());
		
		serialNumber = "";
		dc.setSerialNumber(serialNumber);
		assertEquals(serialNumber, dc.getSerialNumber());
		
		serialNumber = "ABCD-2015";
		dc.setSerialNumber(serialNumber);
		assertEquals(serialNumber, dc.getSerialNumber());
		
		dc.setSerialNumber(null);
		assertNull(dc.getSerialNumber());
	}
	
	@Test
	public void testSetAndGetValidFrom() {
		
		DigitalCertificate dc = new DigitalCertificate();
		String validFrom;
		
		assertNull(dc.getValidFrom());
		
		validFrom = "";
		dc.setValidFrom(validFrom);
		assertEquals(validFrom, dc.getValidFrom());
		
		validFrom = "xxx";
		dc.setValidFrom(validFrom);
		assertEquals(validFrom, dc.getValidFrom());	
		
		dc.setValidFrom(null);
		assertNull(dc.getValidFrom());
	}
	
	@Test
	public void testSetAndGetValidTo() {
		
		DigitalCertificate dc = new DigitalCertificate();
		String validTo;
		
		assertNull(dc.getValidTo());
		
		validTo = "";
		dc.setValidTo(validTo);
		assertEquals(validTo, dc.getValidTo());
		
		validTo = "yyy";
		dc.setValidTo(validTo);
		assertEquals(validTo, dc.getValidTo());
		
		dc.setValidTo(null);
		assertNull(dc.getValidTo());
	}
	
	@Test
	public void testSetAndGetPublicKey() {
		
		DigitalCertificate dc = new DigitalCertificate();
		PublicKey pubKey = null;
		
		assertNull(dc.getpublicKey());
		
		try {
			KeyPair rsaKeys = new RSAGenerator().GenerateRSAKeys();
			pubKey = rsaKeys.getPublic();
		} catch (NoSuchAlgorithmException e) {
			fail("Testing of setter and getter for publicKey attribute is blocked by an issue in the RSAGenerator class: the GenerateRSAKeys() method is throwing an exception");
		}
		
		dc.setPublicKey(pubKey);
		assertEquals(pubKey, dc.getpublicKey());
		
		dc.setPublicKey(null);
		assertNull(dc.getpublicKey());
	}
	
	@Test
	public void testSetIssuerSignature() {
		
		DigitalCertificate dc = new DigitalCertificate();
		byte[] issuerSignature;
		
		assertNull(dc.getIssuerSignature());
		
		issuerSignature = new byte[] { };
		dc.setIssuerSignature(issuerSignature);
		assertEquals(issuerSignature, dc.getIssuerSignature());
		
		issuerSignature = new byte[] {1,2,3,4,5};
		dc.setIssuerSignature(issuerSignature);
		assertEquals(issuerSignature, dc.getIssuerSignature());
		
		dc.setIssuerSignature(null);
		assertNull(dc.getIssuerSignature());
	}

}
