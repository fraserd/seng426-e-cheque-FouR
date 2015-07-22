package test.eCheque;

import eCheque.EChequeRegistration;
import eCheque.SendChequeJFrame;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * SendChequeJFrame Tester.
 *
 * @author fmd@uvic.ca
 * @version 1.0
 * @since <pre>Jul 8, 2015</pre>
 */
public class SendChequeJFrameTest {
    SendChequeJFrame frame;
    private static final Object lock = new Object();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSendChequeJFrame() throws Exception {
        EChequeRegistration user = new EChequeRegistration();
        user.setUsername("fmd".hashCode());
        user.setPasword("fuck".hashCode());
        user.setAccountNumber("01");
        user.setBankAddress("http://127.0.0.1");
        user.setBankName("evil bank");
        user.setClientName("jimmy peas");
        user.setEWalletLoaction("./");


        frame = new SendChequeJFrame(user);
        frame.setVisible(true);

        Thread t = new Thread() {
            public void run() {
                synchronized (lock) {
                    while (frame.isVisible())
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    System.out.println("Working now");
                }
            }
        };
        t.start();

        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent arg0) {
                synchronized (lock) {
                    frame.setVisible(false);
                    lock.notify();
                }
            }

        });

        t.join();
    }

    /**
     * Method: getFileLoaction(String dialogTitle)
     */
    @Test
    public void testGetFileLoaction() throws Exception {
// need a user object to give unto the constructor of the jframe
        EChequeRegistration user = new EChequeRegistration();
        SendChequeJFrame frameUnderTest = new SendChequeJFrame(user);


        try {
            // hack the frame object to get access to the private method.
            Method method = frameUnderTest.getClass().getDeclaredMethod("getFileLoaction", String.class);
            method.setAccessible(true);
            method.invoke(frameUnderTest, "dialog title");
            assertTrue(frameUnderTest.getTitle().equals("dialog title"));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method: initComponents()
     */
    @Test
    public void testInitComponents() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = SendChequeJFrame.getClass().getMethod("initComponents"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: jBSendPTPChequeMouseClicked(java.awt.event.MouseEvent evt)
     */
    @Test
    public void testJBSendPTPChequeMouseClicked() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = SendChequeJFrame.getClass().getMethod("jBSendPTPChequeMouseClicked", java.awt.event.MouseEvent.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: jBselectChqPTPMouseClicked(java.awt.event.MouseEvent evt)
     */
    @Test
    public void testJBselectChqPTPMouseClicked() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = SendChequeJFrame.getClass().getMethod("jBselectChqPTPMouseClicked", java.awt.event.MouseEvent.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: updateInternalBuffers()
     */
    @Test
    public void testUpdateInternalBuffers() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = SendChequeJFrame.getClass().getMethod("updateInternalBuffers"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
