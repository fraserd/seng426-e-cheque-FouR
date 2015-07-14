package test.eCheque;

import eCheque.AESCrypt;
import eCheque.RSAGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.security.interfaces.RSAKey;
import java.util.Arrays;



/**
 * AESCrypt Tester.
 *
 * @author Fraser DeLisle
 * @version 1.0
 * @since <pre>Jun 24, 2015</pre>
 */
public class AESCryptTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: GenerateRandomAESKey()
     */
    @Test
    public void testGenerateRandomAESKey() throws Exception {
        AESCrypt aesCryptUnderTest = new AESCrypt();
        SecretKey keyUnderTest = aesCryptUnderTest.GenerateRandomAESKey();
        assert(keyUnderTest.getAlgorithm().equals("AES"));
    }

    /**
     * Method: initializeCipher(Key key, int mode)
     */
    @Test
    public void testInitializeCipher() throws Exception {
        AESCrypt aesCryptUnderTest = new AESCrypt();
        // get an AES key to use
        SecretKey aesKey1 = aesCryptUnderTest.GenerateRandomAESKey();
        // get an RSA key to use
        RSAKey rsaKey1 = (RSAKey) new RSAGenerator().GenerateRSAKeys().getPrivate();

        Cipher cipher = aesCryptUnderTest.initializeCipher(aesKey1, 0);
        assert( cipher.getAlgorithm().equals("AES"));

        cipher = aesCryptUnderTest.initializeCipher(aesKey1, 1);
        assert( cipher.getAlgorithm().equals("AES"));

        cipher = aesCryptUnderTest.initializeCipher((Key) rsaKey1, 2);
        assert( cipher.getAlgorithm().equals("RSA"));

        cipher = aesCryptUnderTest.initializeCipher((Key) rsaKey1, 3);
        assert( cipher.getAlgorithm().equals("RSA"));


    }

    /**
     * Method: crypt(InputStream in, OutputStream out, Cipher cipherObj)
     */
    @Test
    public void testCrypt() throws Exception {
        // prepare:
        byte[] keyByteArray = ("non-random passphrase to generate a constant key").getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        keyByteArray = sha.digest(keyByteArray);
        keyByteArray = Arrays.copyOf(keyByteArray, 16); // use only first 128 bit
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyByteArray, "AES");
        SecretKey key = (SecretKey) secretKeySpec;
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        AESCrypt aesCryptUnderTest = new AESCrypt();

        Cipher encryptionCipher = Cipher.getInstance("AES");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
        Cipher decryptionCipher = Cipher.getInstance("AES");
        decryptionCipher.init(Cipher.DECRYPT_MODE, key);

        System.out.println("key: " + key.getEncoded().toString());

        String plaintext = "hello world";
        String ciphertext = "";
        InputStream input = new ByteArrayInputStream(plaintext.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.out.println("plaintext: " + plaintext);
        System.out.println("plaintext length: " + plaintext.length());

        // test encryption:
        aesCryptUnderTest.crypt(input, output, encryptionCipher);
        input.close();
        ciphertext = output.toString(StandardCharsets.UTF_8.toString());


        System.out.println("ciphertext: " + ciphertext + ";");
        System.out.println("ciphertext length: " + ciphertext.length());

        assertTrue(!plaintext.equals(ciphertext));

        // test decryption:
        input = new ByteArrayInputStream(output.toByteArray());
        output = new ByteArrayOutputStream();
        aesCryptUnderTest.crypt(input, output, decryptionCipher);
        input.close();
        String decryptedCiphertext = output.toString(StandardCharsets.UTF_8.toString());

        System.out.println("decrypted ciphertext: " + decryptedCiphertext);
        System.out.println("decrypted ciphertext length: " + decryptedCiphertext.length());

        assertTrue(plaintext.equals(decryptedCiphertext));
    }

    /**
     * Method: inilizeAESKeyByPassword(String pass)
     */
    @Test
    public void testInilizeAESKeyByPassword() throws Exception {
        AESCrypt aesCryptUnderTest = new AESCrypt();
        String password = "humptydumpty";
        SecretKeySpec secretKey = aesCryptUnderTest.inilizeAESKeyByPassword(password);
        assertTrue(secretKey.getAlgorithm().equals("AES"));

        password = "";

        try {
            SecretKeySpec secretKeyWithEmptyPassword = aesCryptUnderTest.inilizeAESKeyByPassword(password);
            assertTrue(secretKeyWithEmptyPassword.getAlgorithm().equals("AES"));
        } catch (java.lang.IllegalArgumentException e) {
            assertTrue(e.getMessage().equals("Empty key"));
        }

    }


} 
