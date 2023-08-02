package acceptancetests.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/features"
        , glue = {"acceptancetests/steps"}
        ,monochrome = true
        ,dryRun = false
        ,tags = "@SmokeTest"
        ,plugin = {"pretty"
        ,"junit:src/Reports/JUnitReports/JUnitReports.xml"
        ,"json:src/Reports/JSonReports/JSonReport.json"
        ,"html:src/Reports/HTMLlReports/HTMLReports.html/"
        })
public class RunnerTest{
        //Class should be empty
}
