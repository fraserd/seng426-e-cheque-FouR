package test.eCheque;

import eCheque.EChequeRegisteration;
import eCheque.SendChequeJFrame;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** 
* SendChequeJFrame Tester. 
* 
* @author fmd@uvic.ca
* @since <pre>Jul 8, 2015</pre> 
* @version 1.0 
*/ 
public class SendChequeJFrameTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
}

/** 
* 
* Method: getFileLoaction(String dialogTitle) 
* 
*/ 
@Test
public void testGetFileLoaction() throws Exception {
// need a user object to give unto the constructor of the jframe
    EChequeRegisteration user = new EChequeRegisteration();
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
* 
* Method: initComponents() 
* 
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
* 
* Method: jBSendPTPChequeMouseClicked(java.awt.event.MouseEvent evt) 
* 
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
* 
* Method: jBselectChqPTPMouseClicked(java.awt.event.MouseEvent evt) 
* 
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
* 
* Method: updateInternalBuffers() 
* 
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
