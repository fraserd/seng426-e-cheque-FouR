package test.eCheque;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eCheque.DigitalCertificate;
import eCheque.DigitalCertificateIO;
import eCheque.RSAGenerator;

public class DigitalCertificateIOTest {
	
	private static final String ROOT_TEST_DIRECTORY = "DigitalCertificateIOTests/";
	
	private static void deleteDirectory(File rootDir) {		
		if(rootDir.isDirectory()) {
			for(File f : rootDir.listFiles()) {
				deleteDirectory(f);
			}
		}
		
		rootDir.delete();		
	}
	
	@Before
	public void before() throws Exception { 
		new File(ROOT_TEST_DIRECTORY).mkdirs();		
	} 
	
	@After
	public void after() {
		//Remove all directories and files that were created during testing
		deleteDirectory(new File(ROOT_TEST_DIRECTORY));		
	}
	
	@Test
	public void testSaveAndReadNewFile() {
		DigitalCertificateIO dcIO = new DigitalCertificateIO();
		String filePath;
		DigitalCertificate originalDC;	
		
		//Test saving to a directory that does exist but the file does not
		filePath = ROOT_TEST_DIRECTORY + "testFileDoesNotExist.edc";
		originalDC = new DigitalCertificate();
		
		try {
			dcIO.SaveDC(originalDC, filePath);
			assertTrue("FAIL: The file does not exist after saving a DigitalCertificate to it", new File(filePath).exists());
		}
		catch(Exception e) {
			e.printStackTrace();
			fail("FAIL: Could not save a digital certificate to a directory that exists but a file that does not exist");
		}
		
		//Test reading of the DigitalCertificate that was just saved
		try {
			
			DigitalCertificate savedDC = dcIO.readDigitalCertificate(filePath);
			assertNotNull("FAIL: Read certificate is null", savedDC);
						
			assertEquals("FAIL: holderName of original and read certificate do not match", originalDC.getHolderName(), savedDC.getHolderName());
			assertEquals("FAIL: issuer of original and read certificate do not match", originalDC.getIssuer(), savedDC.getIssuer());
			assertArrayEquals("FAIL: issuerSignature of original and read certificate do not match", originalDC.getIssuerSignature(), savedDC.getIssuerSignature());
			assertEquals("FAIL: publicKey of original and read certificate do not match", originalDC.getpublicKey(), savedDC.getpublicKey());
			assertEquals("FAIL: serialNumber of original and read certificate do not match", originalDC.getSerialNumber(), savedDC.getSerialNumber());
			assertEquals("FAIL: subject of original and read certificate do not match", originalDC.getSubject(), savedDC.getSubject());
			assertEquals("FAIL: validFrom of original and read certificate do not match", originalDC.getValidFrom(), savedDC.getValidFrom());
			assertEquals("FAIL: validTo of original and read certificate do not match", originalDC.getValidTo(), savedDC.getValidTo());

		}
		catch(Exception e) {
			e.printStackTrace();
			fail("FAIL: Could not read a DigitalCertificate that was saved");
		}
	}
	
	@Test
	public void testSaveAndReadEmptyFile() throws Exception {
		DigitalCertificateIO dcIO = new DigitalCertificateIO();
		String filePath;
		DigitalCertificate originalDC;
		
		//Test saving to an empty file that does exist
		filePath = ROOT_TEST_DIRECTORY + "testFileExists.edc";
		originalDC = new DigitalCertificate();
		
		new File(filePath).createNewFile();
		
		originalDC.setHolderName("Software Tester");
		originalDC.setSerialNumber("");
		originalDC.setIssuerSignature(new byte[]{1, 5, 1});
		
		try {
			dcIO.SaveDC(originalDC, filePath);
			assertTrue("FAIL: The file does not exist after saving a DigitalCertificate to it", new File(filePath).exists());
		}
		catch(Exception e) {
			e.printStackTrace();
			fail("FAIL: Could not save a digital certificate to an empty file that already exists");
		}
			
		//Test reading of the DigitalCertificate that was just saved
		try {
									
			DigitalCertificate savedDC = dcIO.readDigitalCertificate(filePath);
			assertNotNull("FAIL: Read certificate is null", savedDC);
						
			assertEquals("FAIL: holderName of original and read certificate do not match", originalDC.getHolderName(), savedDC.getHolderName());
			assertEquals("FAIL: issuer of original and read certificate do not match", originalDC.getIssuer(), savedDC.getIssuer());
			assertArrayEquals("FAIL: issuerSignature of original and read certificate do not match", originalDC.getIssuerSignature(), savedDC.getIssuerSignature());
			assertEquals("FAIL: publicKey of original and read certificate do not match", originalDC.getpublicKey(), savedDC.getpublicKey());
			assertEquals("FAIL: serialNumber of original and read certificate do not match", originalDC.getSerialNumber(), savedDC.getSerialNumber());
			assertEquals("FAIL: subject of original and read certificate do not match", originalDC.getSubject(), savedDC.getSubject());
			assertEquals("FAIL: validFrom of original and read certificate do not match", originalDC.getValidFrom(), savedDC.getValidFrom());
			assertEquals("FAIL: validTo of original and read certificate do not match", originalDC.getValidTo(), savedDC.getValidTo());	
		}
		catch(Exception e) {
			e.printStackTrace();
			fail("FAIL: Could not read a DigitalCertificate that was saved");
		}
	}
	
	@Test
	public void testSaveAndReadNewFolder() {
		DigitalCertificateIO dcIO = new DigitalCertificateIO();
		String filePath;
		DigitalCertificate originalDC;
		
		//Test saving to a file in a folder that does not exist
		filePath = ROOT_TEST_DIRECTORY + "/folderDoesNotExist/test.edc";
		originalDC = new DigitalCertificate();

		try {
			dcIO.SaveDC(originalDC, filePath);
			assertTrue("FAIL: The file does not exist after saving a DigitalCertificate to it", new File(filePath).exists());
		}
		catch(Exception e) {
			e.printStackTrace();
			fail("FAIL: Could not save a digital certificate to a file within a folder that does not exist");
		}

		//Test reading of the DigitalCertificate that was just saved
		try {

			DigitalCertificate savedDC = dcIO.readDigitalCertificate(filePath);
			assertNotNull("FAIL: Read certificate is null", savedDC);

			assertEquals("FAIL: holderName of original and read certificate do not match", originalDC.getHolderName(), savedDC.getHolderName());
			assertEquals("FAIL: issuer of original and read certificate do not match", originalDC.getIssuer(), savedDC.getIssuer());
			assertArrayEquals("FAIL: issuerSignature of original and read certificate do not match", originalDC.getIssuerSignature(), savedDC.getIssuerSignature());
			assertEquals("FAIL: publicKey of original and read certificate do not match", originalDC.getpublicKey(), savedDC.getpublicKey());
			assertEquals("FAIL: serialNumber of original and read certificate do not match", originalDC.getSerialNumber(), savedDC.getSerialNumber());
			assertEquals("FAIL: subject of original and read certificate do not match", originalDC.getSubject(), savedDC.getSubject());
			assertEquals("FAIL: validFrom of original and read certificate do not match", originalDC.getValidFrom(), savedDC.getValidFrom());
			assertEquals("FAIL: validTo of original and read certificate do not match", originalDC.getValidTo(), savedDC.getValidTo());	
		}		
		catch(Exception e) {
			e.printStackTrace();
			fail("FAIL: Could not read a DigitalCertificate that was saved");
		}
	}
	
	@Test
	public void testReadNonExistentFile() throws Exception {
		DigitalCertificateIO dcIO = new DigitalCertificateIO();
		String filePath;
		
		//Test reading a certificate from a file that does not exist
		filePath = ROOT_TEST_DIRECTORY + "fileDoesntExist.edc";
		
		DigitalCertificate savedDC = null;
		try {
			savedDC = dcIO.readDigitalCertificate(filePath);
		}
		catch(Exception e) { }
		assertNull("FAIL: The certificate object returned is somehow non-null", savedDC);
	}
	
	@Test
	public void testReadNonDCFile() throws Exception {
		DigitalCertificateIO dcIO = new DigitalCertificateIO();
		String filePath;
		
		//Test reading a certificate from a file that does not exist
		filePath = ROOT_TEST_DIRECTORY + "fileRandomContent.edc";
		
		File f = new File(filePath);
		f.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(f.getAbsolutePath()));
		bw.write("Miscellaneous input");
		bw.close();
		
		DigitalCertificate savedDC = null;
		try {
			savedDC = dcIO.readDigitalCertificate(filePath);
		}
		catch(Exception e) { }
		assertNull("FAIL: The certificate object returned is somehow non-null", savedDC);
	}
	
	@Test
	public void testSaveDifferentFileExtensions() {		
		DigitalCertificateIO dcIO = new DigitalCertificateIO();
		String filePath1, filePath2;
		DigitalCertificate originalDC1, originalDC2;	
		
		//Test saving to a directory that does exist but the file does not
		//with .txt file extension
		filePath1 = ROOT_TEST_DIRECTORY + "testFileDoesNotExist.txt";
		filePath2 = ROOT_TEST_DIRECTORY + "testFileDoesNotExist.c";
		originalDC1 = new DigitalCertificate();
		originalDC2 = new DigitalCertificate();
		
		try {
			dcIO.SaveDC(originalDC1, filePath1);
			assertTrue("FAIL: The file does not exist after saving a DigitalCertificate to it", new File(filePath1).exists());			
		}
		catch(Exception e) {
			e.printStackTrace();
			fail("FAIL: Could not save a digital certificate to a .txt file");
		}
		
		try {
			dcIO.SaveDC(originalDC2, filePath2);
			assertTrue("FAIL: The file does not exist after saving a DigitalCertificate to it", new File(filePath1).exists());
		}
		catch(Exception e) {
			e.printStackTrace();
			fail("FAIL: Could not save a digital certificate to a .c file");
		}
		
		//Test reading of the DigitalCertificate that was just saved
		try {
			
			DigitalCertificate savedDC = dcIO.readDigitalCertificate(filePath1);
			assertNotNull("FAIL: Read certificate is null", savedDC);
						
			assertEquals("FAIL: holderName of original and read certificate do not match", originalDC1.getHolderName(), savedDC.getHolderName());
			assertEquals("FAIL: issuer of original and read certificate do not match", originalDC1.getIssuer(), savedDC.getIssuer());
			assertArrayEquals("FAIL: issuerSignature of original and read certificate do not match", originalDC1.getIssuerSignature(), savedDC.getIssuerSignature());
			assertEquals("FAIL: publicKey of original and read certificate do not match", originalDC1.getpublicKey(), savedDC.getpublicKey());
			assertEquals("FAIL: serialNumber of original and read certificate do not match", originalDC1.getSerialNumber(), savedDC.getSerialNumber());
			assertEquals("FAIL: subject of original and read certificate do not match", originalDC1.getSubject(), savedDC.getSubject());
			assertEquals("FAIL: validFrom of original and read certificate do not match", originalDC1.getValidFrom(), savedDC.getValidFrom());
			assertEquals("FAIL: validTo of original and read certificate do not match", originalDC1.getValidTo(), savedDC.getValidTo());

		}
		catch(Exception e) {
			e.printStackTrace();
			fail("FAIL: Could not read a DigitalCertificate that was saved in a .txt file");
		}
		
		//Test reading of the DigitalCertificate that was just saved
		try {
			
			DigitalCertificate savedDC = dcIO.readDigitalCertificate(filePath2);
			assertNotNull("FAIL: Read certificate is null", savedDC);
						
			assertEquals("FAIL: holderName of original and read certificate do not match", originalDC2.getHolderName(), savedDC.getHolderName());
			assertEquals("FAIL: issuer of original and read certificate do not match", originalDC2.getIssuer(), savedDC.getIssuer());
			assertArrayEquals("FAIL: issuerSignature of original and read certificate do not match", originalDC2.getIssuerSignature(), savedDC.getIssuerSignature());
			assertEquals("FAIL: publicKey of original and read certificate do not match", originalDC2.getpublicKey(), savedDC.getpublicKey());
			assertEquals("FAIL: serialNumber of original and read certificate do not match", originalDC2.getSerialNumber(), savedDC.getSerialNumber());
			assertEquals("FAIL: subject of original and read certificate do not match", originalDC2.getSubject(), savedDC.getSubject());
			assertEquals("FAIL: validFrom of original and read certificate do not match", originalDC2.getValidFrom(), savedDC.getValidFrom());
			assertEquals("FAIL: validTo of original and read certificate do not match", originalDC2.getValidTo(), savedDC.getValidTo());

		}
		catch(Exception e) {
			e.printStackTrace();
			fail("FAIL: Could not read a DigitalCertificate that was saved in a .c file");
		}
	}
	
	@Test
	public void testSaveReadNonNullPublicKey() throws Exception {
		//TODO: Test reading and writing a certificate with a non-null publicKey
		
		
		DigitalCertificateIO dcIO = new DigitalCertificateIO();
		String filePath;
		DigitalCertificate originalDC;
		
		PublicKey pubKey = null;
		try {
			KeyPair rsaKeys = new RSAGenerator().GenerateRSAKeys();
			pubKey = rsaKeys.getPublic();
		} catch (NoSuchAlgorithmException e) {
			fail("Testing of setter and getter for publicKey attribute is blocked by an issue in the RSAGenerator class: the GenerateRSAKeys() method is throwing an exception");
		}
		assertNotNull("Testing of setter and getter for publicKey attribute is blocked by an issue in the RSAGenerator class: the GenerateRSAKeys() method is throwing an exception", pubKey);

		
		//Test saving to an empty file that does exist
		filePath = ROOT_TEST_DIRECTORY + "testNonNullPublicKey.edc";
		originalDC = new DigitalCertificate();
		
		new File(filePath).createNewFile();
		
		originalDC.setHolderName("Software Tester");
		originalDC.setSerialNumber("");
		originalDC.setIssuerSignature(new byte[]{1, 5, 1});
		originalDC.setPublicKey(pubKey);
		
		try {
			dcIO.SaveDC(originalDC, filePath);
			assertTrue("FAIL: The file does not exist after saving a DigitalCertificate to it", new File(filePath).exists());
		}
		catch(Exception e) {
			e.printStackTrace();
			fail("FAIL: Could not save a digital certificate to a new file with a non-null PublicKey");
		}
			
		//Test reading of the DigitalCertificate that was just saved
		try {
									
			DigitalCertificate savedDC = dcIO.readDigitalCertificate(filePath);
			assertNotNull("FAIL: Read certificate is null", savedDC);
						
			assertEquals("FAIL: holderName of original and read certificate do not match", originalDC.getHolderName(), savedDC.getHolderName());
			assertEquals("FAIL: issuer of original and read certificate do not match", originalDC.getIssuer(), savedDC.getIssuer());
			assertArrayEquals("FAIL: issuerSignature of original and read certificate do not match", originalDC.getIssuerSignature(), savedDC.getIssuerSignature());
			assertEquals("FAIL: publicKey of original and read certificate do not match", originalDC.getpublicKey(), savedDC.getpublicKey());
			assertEquals("FAIL: serialNumber of original and read certificate do not match", originalDC.getSerialNumber(), savedDC.getSerialNumber());
			assertEquals("FAIL: subject of original and read certificate do not match", originalDC.getSubject(), savedDC.getSubject());
			assertEquals("FAIL: validFrom of original and read certificate do not match", originalDC.getValidFrom(), savedDC.getValidFrom());
			assertEquals("FAIL: validTo of original and read certificate do not match", originalDC.getValidTo(), savedDC.getValidTo());	
		}
		catch(Exception e) {
			e.printStackTrace();
			fail("FAIL: Could not read a DigitalCertificate that was saved");
		}
		
	}

}
