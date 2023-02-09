package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1980x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTests () {
        open("/text-box");
        $(".main-header").shouldHave(text("Text box"));
        $("#userName").setValue("Valera Petrov");
        $("#userEmail").setValue("valera@gmail.com");
        $("#currentAddress").setValue("Some Address 1");
        $("#permanentAddress").setValue("Other Address 2");
        $("#submit").click();

        $("#output").shouldBe(visible);

        $("#output").$("#name").shouldHave(text("Valera Petrov"));
        // или можно написать таким образом
        $("#output #email").shouldHave(text("valera@gmail.com"));
        $("#output #currentAddress").shouldHave(text("Some Address 1"));
        $("#output #permanentAddress").shouldHave(text("Other Address 2"));
    }
}
