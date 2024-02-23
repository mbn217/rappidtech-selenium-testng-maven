package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentFactory {

    public static ExtentSparkReporter sparkReporter; // declaring sparkReporter
    public static ExtentReports extentReports;

    /**
     * Returns an ExtentReports object .
     * If an ExtentReports object doesn't exist, it's created and an ExtentSparkReporter is attached.
     */
    public static ExtentReports getInstance(){
        if (extentReports == null) {
            // Initializing the object and specifying the file path
            sparkReporter = new ExtentSparkReporter("./reports/extentreport.html"); // ExtentSparkReporter class used to customize the report file
            //Add additional information into our reports
            sparkReporter.config().setDocumentTitle("Automation Report For Sauce Labs");//Change report file title
            sparkReporter.config().setReportName("Report"); //Change report name
            sparkReporter.config().setTheme(Theme.STANDARD);
            //sparkReporter.config().setTimeStampFormat(" EEEE , MMMM dd, yyyy , hh:mm a '('zzz')' ");
            //sparkReporter.config().setCss(".nav-wrapper { background-color: #4B0082 !important; } .nav-logo{margin-top: 10px;}.brand-logo { background-color: #4B0082 !important; padding: 0 10px 0 0 !important; margin: 0 !important; position: absolute !important } .report-name { margin-left: 80px !important } .blue.darken-3 { background-color:#4B0082 !important; color: #FFF !important;}");
            //sparkReporter.config().setJs("$('.nav-logo').html('<img src=\"https://i.imgur.com/AjZ89lJ.png\" class=\"db-logo\"/>');");
            extentReports = new ExtentReports();//ExtentReports class used to create report file
            extentReports.attachReporter(sparkReporter); //Attach ExtentSparkReporter object to ExtentReports object
            extentReports.setSystemInfo("Tester", "RappidTech");//Put System info
            extentReports.setSystemInfo("Selenium Version" ,"4.16.1");
            extentReports.setSystemInfo("Environment","QA");
        }

        return extentReports;
    }


//Old way using old 2.40.1 Dependency
//    public static ExtentReports getInstance(){
//        //Creating an object of extent report
//        ExtentReports extent = new ExtentReports("./reports/extentreport.html", true);
//        //Add additional information into our reports
//        extent.addSystemInfo("Environment" , "Production");
//        extent.addSystemInfo("Application", "Sauce Labs");
//        return extent;
//    }


}
