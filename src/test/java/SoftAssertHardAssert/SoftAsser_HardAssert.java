package SoftAssertHardAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAsser_HardAssert {


    @Test
    void demoOne(){
        /**
         * Hard Assertion:
         * If the Assertion fails, then the rest of the code wont get executed
         */
        System.out.println("Im in Demo One");
        Assert.assertEquals("Test" , "TestFail"); //(.equal())
        System.out.println("Im in Demo After Assertion");// Will not get executed
        Assert.assertEquals(5 , 5);// Will not get executed
    }


    @Test
    void demoTwo(){
        /**
         * Im in the login page
         * verify that username field is equal to username
         * verify pass field is equal to pass
         * verify button  text is equal to submit
         */
        SoftAssert softAssert =  new SoftAssert(); // It's only available in TestNG and NOT in JUNIT


        softAssert.assertEquals("username" , "usernam");
        softAssert.assertEquals("pa" , "pass");
        softAssert.assertEquals("submit" , "submit");

        System.out.println("This is after all assertion are done!");

        softAssert.assertAll();

    }




}
