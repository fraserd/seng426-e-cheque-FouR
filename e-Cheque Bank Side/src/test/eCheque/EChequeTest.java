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

        assertNull(cheque.getAccountHolder());

        accountholder = "Parker Atkins";
        cheque.setAccountHolder(accountholder);
        assertEquals(accountholder, cheque.getAccountHolder());
    }

    @Test
    public void testSetAndGetaccountNumber() throws Exception {

        String accountNumber;

        assertNull(cheque.getAccountNumber());

        accountNumber = "12345678";
        cheque.setAccountNumber(accountNumber);
        assertEquals(accountNumber, cheque.getAccountNumber());
    }

    @Test
    public void testSetAndGetbankname() throws Exception {

        String bankname;

        assertNull(cheque.getBankName());

        bankname = "Barclays";
        cheque.setBankName(bankname);
        assertEquals(bankname, cheque.getBankName());
    }

    @Test
    public void testSetAndGetpayToOrderOf() throws Exception {

        String payToOrderOf;

        assertNull(cheque.getPayToOrderOf());

        payToOrderOf = "Nobody";
        cheque.setPayToOrderOf(payToOrderOf);
        assertEquals(payToOrderOf, cheque.getPayToOrderOf());
    }

    @Test
    public void testSetAndGetamountofMony() throws Exception {

        String money;

        assertNull(cheque.getAmountOfMoney());

        money = "$100";
        cheque.setAmountOfMoney(money);
        assertEquals(money, cheque.getAmountOfMoney());
    }

    @Test
    public void testSetAndGetcurrencytype() throws Exception {

        String currency;

        assertNull(cheque.getCurrencyType());

        currency = "Euro";
        cheque.setCurrencyType(currency);
        assertEquals(currency, cheque.getCurrencyType());
    }

    @Test
    public void testSetAndGetchequeNumber() throws Exception {
        String chequeNumber;

        assertNull(cheque.getChequeNumber());

        chequeNumber = "3";
        cheque.setChequeNumber(chequeNumber);
        assertEquals(chequeNumber, cheque.getChequeNumber());
    }

    @Test
    public void testSetAndGetguaranteed() throws Exception {
        boolean guaranteed;

        assertFalse(cheque.getGuaranteed());

        guaranteed = true;
        cheque.setGuaranteed(guaranteed);
        assertEquals(guaranteed, cheque.getGuaranteed());
    }

    @Test
    public void testSetAndGetearnday() throws Exception {
        String earnday;

        assertNull(cheque.getEarnDay());

        earnday = "Monday";
        cheque.setEarnDay(earnday);
        assertEquals(earnday, cheque.getEarnDay());
    }

    @Test
    public void testSetAndGetbanksignature() throws Exception {
        byte[] banksignature;

        assertNull(cheque.getBankSignature());

        banksignature = new byte[] {1,2,3,4,5};
        cheque.setBankSignature(banksignature);
        assertEquals(banksignature, cheque.getBankSignature());
    }

    @Test
    public void testSetAndGetdrawersiganure() throws Exception {
        byte[] drawersignature;

        assertNull(cheque.getDrawerSignature());

        drawersignature = new byte[] {1,2,3,4,5};
        cheque.setDrawerSignature(drawersignature);
        assertEquals(drawersignature, cheque.getDrawerSignature());
    }
}