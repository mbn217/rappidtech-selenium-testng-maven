package ExtentReport;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {


    public static ExtentReports getInstance(){
        //Creating an object of extent report
        ExtentReports extent = new ExtentReports("./reports/extentreport.html", true);
        //Add additional information into our reports
        extent.addSystemInfo("Environment" , "Production");
        extent.addSystemInfo("Application", "Sauce Labs");
        return extent;
    }

}
