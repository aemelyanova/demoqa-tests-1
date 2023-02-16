package demoqa;

import org.junit.jupiter.api.Test;

import java.io.File;

public class AutomationPracticeFormWithPageObjects extends TestBase {

    @Test
    void practiceFormTests() {
        String firstName = "Valera";
        String lastName = "Petrov";
        String email = "valerka@gmail.com";
        String numberPhone = "1122334455";
        String dayOfBirth = "30";
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

        automatonPracticeFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmailName(email)
                .setGender(gender)
                .setUserNumber(numberPhone)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(file)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .setSubmit();

        automatonPracticeFormPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Mobile", numberPhone)
                .verifyResult("Subjects", subjects)
                .verifyResult("State and City", state + " " + city)
                .verifyResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth);
    }
}

