package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.AutomatonPracticeFormPage;

public class TestBase {
    AutomatonPracticeFormPage automatonPracticeFormPage = new AutomatonPracticeFormPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1980x1080";
        Configuration.baseUrl = "https://demoqa.com";

    }
}
