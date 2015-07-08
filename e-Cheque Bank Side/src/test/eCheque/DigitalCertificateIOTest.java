package test.eCheque;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eCheque.DigitalCertificate;
import eCheque.DigitalCertificateIO;

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
	public void testReadNonExistentFile() {
		DigitalCertificateIO dcIO = new DigitalCertificateIO();
		String filePath;
		
		//Test reading a certificate from a file that does not exist
		filePath = ROOT_TEST_DIRECTORY + "randomFileDoesNotExist.edc";
		DigitalCertificate savedDCFailedRead = null;
		try {
			savedDCFailedRead = dcIO.readDigitalCertificate(filePath);
		}
		catch(Exception e) { }
		assertNull("FAIL: The certificate object returned is somehow non-null", savedDCFailedRead);
	}
	
	@Test
	public void testReadNonDCFile() {
		//TODO: Test reading from a file that does exist but does not
		//correspond to a digitalcertificate
		fail("not implemented");
	}
	
	@Test
	public void testSaveDifferentFileExtensions() {
		//TODO: Test reading/writing to a file with a different extension than .edc (ex .txt)
		fail("not implemented");
	}
	
	@Test
	public void testSaveReadNonNullPublicKey() {
		//TODO: Test reading and writing a certificate with a non-null publicKey
		fail("not implemented");
	}

}
