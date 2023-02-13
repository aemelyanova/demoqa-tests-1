package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class AutomationPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1980x1080";
        Configuration.baseUrl = "https://demoqa.com";

    }
    @Test
    void practiceFormTests() {
        String firstName = "Valera";
        String lastName = "Petrov";
        String email = "valerka@gmail.com";
        String numberPhone = "1122334455";
        String dateOfBirth = "27 January,1995";
        String dayOfBirth = "27";
        String monthOfBirth = "January";
        String yearOfBirth = "1995";
        String gender = "Male";
        String subjects = "Computer Science";
        String hobbies = "Music";
        File file = new File("src/test/resources/photovalera.jpg");
        String photo = "photovalera.jpg";
        String address = "189 The Grove Drive\n" +
                "Los Angeles, CA 90036";
        String state = "Haryana";
        String city = "Panipat";


        // открываем нужный сайт и выполняем проверку по названию заголовка "Practice Form"
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        // заполняем форму студента: Name (First Name, Last Name) и Email
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);

        // выбираем пол
        $("#genterWrapper").$(byText(gender)).click();

        // вводим номер телефона 10 цифр
        $("#userNumber").setValue(numberPhone);

        // вводим дату рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText(monthOfBirth)).click();
        $(".react-datepicker__year-select").click();
        $(byText(yearOfBirth)).click();
        $(".react-datepicker__day-names").click();
        $(byText(dayOfBirth)).click();

        // выбираем предмет для изучения
        $("#subjectsInput").setValue(subjects).click();
        $(".subjects-auto-complete__menu").click();

        // в разделе "Hobbies" выбираем категорию
        $("#hobbiesWrapper").$(byText(hobbies)).click();

        // загружаем изображение
        $("#uploadPicture").uploadFile(file);

        // ввести текущий адрес
        $("#currentAddress").setValue(address);

        //выбрать штат и город
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        //отправить анкету
        $("#submit").click();

        //проверка
        $(".modal-content").shouldBe(visible);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName), text(email), text(gender),
                text(numberPhone), text(dateOfBirth), text(subjects), text(hobbies), text(photo),
                text(address), text(state + " " + city));

    }
}
