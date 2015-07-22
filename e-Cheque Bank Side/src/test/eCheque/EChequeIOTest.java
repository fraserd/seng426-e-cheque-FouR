package test.eCheque;

import eCheque.ECheque;
import eCheque.EChequeIO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by pcatkins on 08/07/15.
 */
public class EChequeIOTest {

    String fileDoesNotExist = "nofile.txt";
    String fileName = "testfile.txt";
    File file = new File(fileName);
    ECheque cheque = new ECheque();
    EChequeIO chequeIO = new EChequeIO();

    @Before
    public void setUp() {
        cheque.setAccountHolder("Tester");

        try{
            file.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testSaveAndReadcheque() throws Exception {
        try{
            chequeIO.readcheque(fileDoesNotExist);
        }catch(FileNotFoundException e){
            //expected
        }catch(Exception e){
            fail("Should throw FileNotFoundException");
        }

        chequeIO.savecheque(cheque, fileName);
        assertEquals(cheque.getAccountHolder(), chequeIO.readcheque(fileName).getAccountHolder());
    }

    @After
    public void tearDown(){
            file.delete();
    }
}