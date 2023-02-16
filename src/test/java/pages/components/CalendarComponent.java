package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String dayOfBirth, String monthOfBirth, String yearOfBirth) {

        $(".react-datepicker__month-select").click();
        $(byText(monthOfBirth)).click();
        $(".react-datepicker__year-select").click();
        $(byText(yearOfBirth)).click();
        $(".react-datepicker__day--0" + dayOfBirth +
                ":not(.react-datepicker__day--outside-month)").click();
    }
}
