package test.eCheque;

import eCheque.AESCrypt;
import eCheque.RSAGenerator;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.interfaces.RSAKey;

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
//TODO: Test goes here... 
    }

    /**
     * Method: inilizeAESKeyByPassword(String pass)
     */
    @Test
    public void testInilizeAESKeyByPassword() throws Exception {
//TODO: Test goes here... 
    }


} 
