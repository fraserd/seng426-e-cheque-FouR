package test.eCheque;

import eCheque.ECheque;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pcatkins on 08/07/15.
 */
public class EChequeTest {
    //Global Echeque object to test getters and setters
    ECheque cheque = new ECheque();

    @Test
    public void testSetAndGetaccountholder() throws Exception {

        String accountholder;

        assertNull(cheque.getaccountholder());

        accountholder = "Parker Atkins";
        cheque.setaccountholder(accountholder);
        assertEquals(accountholder, cheque.getaccountholder());
    }

    @Test
    public void testSetAndGetaccountNumber() throws Exception {

        String accountNumber;

        assertNull(cheque.getaccountNumber());

        accountNumber = "12345678";
        cheque.setaccountNumber(accountNumber);
        assertEquals(accountNumber, cheque.getaccountNumber());
    }

    @Test
    public void testSetAndGetbankname() throws Exception {

        String bankname;

        assertNull(cheque.getbankname());

        bankname = "Barclays";
        cheque.setbankname(bankname);
        assertEquals(bankname, cheque.getbankname());
    }

    @Test
    public void testSetAndGetpayToOrderOf() throws Exception {

        String payToOrderOf;

        assertNull(cheque.getpayToOrderOf());

        payToOrderOf = "Nobody";
        cheque.setpayToOrderOf(payToOrderOf);
        assertEquals(payToOrderOf, cheque.getpayToOrderOf());
    }

    @Test
    public void testSetAndGetamountofMony() throws Exception {

        String money;

        assertNull(cheque.getMoney());

        money = "$100";
        cheque.setamountofMony(money);
        assertEquals(money, cheque.getMoney());
    }

    @Test
    public void testSetAndGetcurrencytype() throws Exception {

        String currency;

        assertNull(cheque.getcurrencytype());

        currency = "Euro";
        cheque.setcurrencytype(currency);
        assertEquals(currency, cheque.getcurrencytype());
    }

    @Test
    public void testSetAndGetchequeNumber() throws Exception {
        String chequeNumber;

        assertNull(cheque.getchequeNumber());

        chequeNumber = "3";
        cheque.setchequeNumber(chequeNumber);
        assertEquals(chequeNumber, cheque.getchequeNumber());
    }

    @Test
    public void testSetAndGetguaranteed() throws Exception {
        boolean guaranteed;

        assertFalse(cheque.getguaranteed());

        guaranteed = true;
        cheque.setguaranteed(guaranteed);
        assertEquals(guaranteed, cheque.getguaranteed());
    }

    @Test
    public void testSetAndGetearnday() throws Exception {
        String earnday;

        assertNull(cheque.getearnday());

        earnday = "Monday";
        cheque.setearnday(earnday);
        assertEquals(earnday, cheque.getearnday());
    }

    @Test
    public void testSetAndGetbanksignature() throws Exception {
        byte[] banksignature;

        assertNull(cheque.getbanksignature());

        banksignature = new byte[] {1,2,3,4,5};
        cheque.setbanksignature(banksignature);
        assertEquals(banksignature, cheque.getbanksignature());
    }

    @Test
    public void testSetAndGetdrawersiganure() throws Exception {
        byte[] drawersignature;

        assertNull(cheque.getdrawersiganure());

        drawersignature = new byte[] {1,2,3,4,5};
        cheque.setdrawersiganure(drawersignature);
        assertEquals(drawersignature, cheque.getdrawersiganure());
    }
}