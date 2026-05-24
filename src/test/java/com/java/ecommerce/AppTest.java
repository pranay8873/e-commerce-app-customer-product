package com.java.ecommerce;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;

import static junit.framework.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
@Test
public void testadd(){
    App app=new App();
    int result=app.add(20,20);
//    assertEquals(30,result);
    assertEquals("expected 30",30,result);

}
    public static void main() {
        AppTest a=new AppTest();
        a.testadd();
    }
}


