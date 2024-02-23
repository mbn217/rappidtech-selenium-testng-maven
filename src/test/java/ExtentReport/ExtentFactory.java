package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentFactory {

    public static ExtentSparkReporter sparkReporter; // declaring sparkReporter
    public static ExtentReports extentReports;

    public static ExtentSparkReporter getInstance(){
        // Initializing the object and specifying the file path
        sparkReporter = new ExtentSparkReporter("./reports/extentreport.html");
        //Add additional information into our reports
        sparkReporter.config().setDocumentTitle("Automation Report For Sauce Labs");
        sparkReporter.config().setReportName("Report");
        sparkReporter.config().setTheme(Theme.STANDARD);
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);

        return sparkReporter;
    }



//    public static ExtentReports getInstance(){
//        //Creating an object of extent report
//        ExtentReports extent = new ExtentReports("./reports/extentreport.html", true);
//        //Add additional information into our reports
//        extent.addSystemInfo("Environment" , "Production");
//        extent.addSystemInfo("Application", "Sauce Labs");
//        return extent;
//    }


}
