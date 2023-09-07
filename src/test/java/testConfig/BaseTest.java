package testConfig;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pageModels.PracticeFormPage;

public class BaseTest {
    public PracticeFormPage page = new PracticeFormPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadTimeout = 60000;
    }
}
