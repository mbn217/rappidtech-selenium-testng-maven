//package ExtentReport;
//
//
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.Test;
//
//public class DemoExtentReport {
//
//    ExtentReports reports = new ExtentReports("./reports/htmlreport.html" , true);
//    ExtentTest extentTest;
//
//    @Test
//    void verifyLogin(){
//        extentTest = reports.startTest("Verify Login page");
//        System.out.println("Verifying login");
//        Assert.assertEquals(true, true);
//        extentTest.log(LogStatus.PASS , " Test cases passed");
//    }
//
//    @Test
//    void verifyLabel(){
//        boolean demo = false;
//        extentTest = reports.startTest(" Verify Label");
//        if(demo ==false){
//            extentTest.log(LogStatus.FAIL , "Test cases failed");
//        }
//
//
//    }
//
//    @AfterClass
//    void cleanup(){
//        reports.flush();
//    }
//
//
//
//}
