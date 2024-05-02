package layout_tests;

import baseitems.Locators;
import com.galenframework.api.Galen;
import com.galenframework.junit.GalenJUnitTestBase;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.TestReport;
import com.galenframework.reports.model.LayoutReport;
import com.galenframework.reports.nodes.TestReportNode;
import driver.BrowserType;
import driver.DriverInitializer;
import driver.Settings;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PromotionsPageLayoutTest extends GalenJUnitTestBase {
    //private static final String[] TAGS = { "mobile" };
    private static final String[] TAGS = { "desktop" };
    private WebDriverWait wait;
    private LayoutReport layoutReport;

    @BeforeAll
    public void setup() {
        createDriver();
    }

    @Override
    public WebDriver createDriver() {
        //WebDriver webDriver = DriverInitializer.initDriver(BrowserType.CHROME_NEXUS);
        WebDriver webDriver = DriverInitializer.initDriver(BrowserType.CHROME_DESKTOP);
        super.driver.set(webDriver);
        this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        super.report.set(new TestReport());
        return getDriver();
    }

    @Test
    @DisplayName("TC1 - SauceDemo Product page")
    public void TC1() throws IOException, InterruptedException {

        getDriver().manage().window().maximize();
        System.out.println("Before setting device:" + getDriver().manage().window().getSize());

        load(Settings.BASE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.COOKIES_BTN)));
        getDriver().findElement(By.xpath(Locators.COOKIES_BTN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.TITLE)));
        getDriver().findElement(By.xpath(Locators.TITLE)).click();
        WebElement titleElement = getDriver().findElement(By.xpath(Locators.TITLE));
        //getDriver().findElement(By.xpath(Locators.TITLE)).click();
        Thread.sleep(2000);


        //System.out.println("After setting device:" + getDriver().manage().window().getSize());

        Assertions.assertEquals("Promotions", titleElement.getText());

        layoutReport = Galen.checkLayout(getDriver(), "/specs/promotionsPage.gspec", Arrays.asList(TAGS));

        //System.out.println("End:" + getDriver().manage().window().getSize());
    }

    public void reportUpdate() {
        final String REPORT_PATH = "target/galen-html-reports";
        try {
            List<GalenTestInfo> tests = new LinkedList<>();
            GalenTestInfo test = GalenTestInfo.fromString("Promotions page test");
            test.getReport().layout(layoutReport, "Verify promotions page layout");
            tests.add(test);
            new HtmlReportBuilder().build(tests, REPORT_PATH);

            for (GalenTestInfo i : tests) {
                List<TestReportNode> nodes = i.getReport().getNodes();
                for (TestReportNode n: nodes) {
                    if (n.getStatus() == TestReportNode.Status.ERROR) {
                        Assertions.fail(String.format("Galen test failed! Check the results under %s folder!", REPORT_PATH));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public void cleanup() {
        getDriver().quit();
        reportUpdate();
    }
}
