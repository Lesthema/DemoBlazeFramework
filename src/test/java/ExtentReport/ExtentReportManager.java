package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReportManager {

    private static ExtentReports extentReports;
    private static ExtentSparkReporter sparkReporter;
    private static final String homeDir = System.getProperty("user.dir");

    public static ExtentReports extentSetup(){

        extentReports = new ExtentReports();
        sparkReporter = new ExtentSparkReporter(new File(homeDir + "/Reports/ExtentReport.html"));
        extentReports.attachReporter(sparkReporter);

        sparkReporter.config().setDocumentTitle("Extent Report");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setReportName("Demo Blaze Report");

        extentReports.setSystemInfo("OS",System.getProperty("os.name"));
        extentReports.setSystemInfo("URL",("https://www.demoblaze.com/index.html"));
        extentReports.setSystemInfo("Execution Machine",System.getProperty("user.name"));

        return extentReports;
    }
}
