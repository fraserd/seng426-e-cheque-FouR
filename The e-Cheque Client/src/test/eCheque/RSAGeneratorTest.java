package test.eCheque;

import eCheque.RSAGenerator;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.security.KeyPair;
import java.security.interfaces.RSAKey;

/**
 * RSAGenerator Tester.
 *
 * @author Fraser DeLisle
 * @version 1.0
 * @since <pre>Jun 24, 2015</pre>
 */
public class RSAGeneratorTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: GenerateRSAKeys()
     */
    @Test
    public void testGenerateRSAKeys() throws Exception {

        // The RSAGenerator class generates PKI keys using Rsa with key size 1024
        RSAGenerator generatorUnderTest = new RSAGenerator();

        KeyPair generatedKey = generatorUnderTest.GenerateRSAKeys();
        assert(generatedKey.getPublic().getAlgorithm().equals("RSA"));
        RSAKey rsaKey = (RSAKey) generatedKey.getPublic();
        assert(rsaKey.getModulus().bitLength() == 1024);
    }
} 
