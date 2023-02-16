package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AutomatonPracticeFormPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailNameInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            subjectsAutoMenuInput = $(".subjects-auto-complete__menu"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            stateCityWrapperInput = $("#stateCity-wrapper"),
            submitInput = $("#submit");

    public AutomatonPracticeFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    public AutomatonPracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public AutomatonPracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public AutomatonPracticeFormPage setEmailName(String value) {
        emailNameInput.setValue(value);

        return this;
    }
    public AutomatonPracticeFormPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }
    public AutomatonPracticeFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }
    public AutomatonPracticeFormPage setBirthDate(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        dateOfBirthInput.click();
        calendarComponent.setDate(dayOfBirth, monthOfBirth, yearOfBirth);

        return this;
    }
    public AutomatonPracticeFormPage verifyResultsModalAppears () {
        registrationResultsModal.verifyModalAppears();

        return this;
    }
    public AutomatonPracticeFormPage verifyResult (String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }
    public AutomatonPracticeFormPage setSubjects(String value) {
        subjectsInput.setValue(value).click();
        subjectsAutoMenuInput.click();

        return this;
    }
    public AutomatonPracticeFormPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }
    public AutomatonPracticeFormPage setPicture(File value) {
        pictureInput.uploadFile(value);

        return this;
    }
    public AutomatonPracticeFormPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }
    public AutomatonPracticeFormPage setState(String value) {
        stateInput.click();
        stateCityWrapperInput.$(byText(value)).click();

        return this;
    }
    public AutomatonPracticeFormPage setCity(String value) {
        cityInput.click();
        stateCityWrapperInput.$(byText(value)).click();

        return this;
    }
    public AutomatonPracticeFormPage setSubmit() {
        submitInput.click();

        return this;
    }
}
