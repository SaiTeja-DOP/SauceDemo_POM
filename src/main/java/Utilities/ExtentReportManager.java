package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.text.SimpleDateFormat;
import java.util.Date;


/*ExtentReports is the main class from the ExtentReports library that:
Collects all your test logs.
Attaches the reporter (e.g., ExtentSparkReporter for HTML output).
Finally generates the report at the end of the execution.*/

public class ExtentReportManager {

    private static ExtentReports extent; // Only one instance throughout project

    public static ExtentReports getReportInstance() {
        if (extent == null) {
            // 1. Create unique report file with timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportPath = System.getProperty("user.dir") + "/Reports/TestReport_" + timestamp + ".html";

            // 2. Set up Spark Reporter need to give report path where u want to store
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            // 3. Customize the report
            spark.config().setReportName("Automation Report");
            spark.config().setDocumentTitle("Test Results");

            // 4. Create ExtentReports object and attach reporter
            extent = new ExtentReports();
            extent.attachReporter(spark);

            // 5. Add system details to the report
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Tester", "Sai Teja");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}
