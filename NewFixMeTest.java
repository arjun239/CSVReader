/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import UtilityPackage.Utility;
import fix.me.im.broken.CSVReader;
import fix.me.im.broken.PersonInfo;
import java.io.FileNotFoundException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Arjun
 */
public class NewFixMeTest {
     Utility u= new Utility();
   
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
   
     @Test
     public void test() throws FileNotFoundException 
     {  
         u.StartScanner();
        Assert.assertTrue(u.ComapareTestParameters());
        
     }
     
     @Test
     public void test2() throws FileNotFoundException 
     {
         Assert.assertTrue(u.ComapareTestParameters());
     }
      @Test
     public void test3() throws FileNotFoundException 
     {
         Assert.assertTrue(u.ComapareTestParameters());
     }
      @Test
     public void test4() throws FileNotFoundException 
     {
         Assert.assertTrue(u.ComapareTestParameters());
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}