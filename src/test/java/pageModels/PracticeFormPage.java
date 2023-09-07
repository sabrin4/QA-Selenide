package pageModels;

import com.codeborne.selenide.SelenideElement;
import pageModels.components.CalendarComponent;
import pageModels.components.RegistrationResultTable;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {
    private final static  String PAGE_TITLE = "Student Registration Form";
    private SelenideElement firstName;
    private SelenideElement lastName;
    private SelenideElement email;
    private SelenideElement gender;
    private SelenideElement phoneNumber;
    private SelenideElement dateOfBirth;
    private SelenideElement uploadPictureButton;
    private SelenideElement address;
    private SelenideElement submitButton;

    String usrState;

    CalendarComponent calendar = new CalendarComponent();
    RegistrationResultTable table = new RegistrationResultTable();

    public PracticeFormPage() {
        firstName = $("#firstName");
        lastName =  $("#lastName");
        email = $("#userEmail");
        phoneNumber = $("#userNumber");
        dateOfBirth = $("#dateOfBirthInput");
        uploadPictureButton = $("#uploadPicture");
        address = $("#currentAddress");
        submitButton = $("#submit");
    }

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(PAGE_TITLE));

        return this;
    }

    public PracticeFormPage fillFirstName(String name) {
        firstName.setValue(name);

        return this;
    }

    public PracticeFormPage fillLastName(String name) {
        lastName.setValue(name);

        return this;
    }

    public PracticeFormPage setEmail(String userEmail) {
        email.setValue(userEmail);

        return this;
    }

    public PracticeFormPage setGender(String genderType) {
        gender = $("#genterWrapper").$(byText(genderType));
        gender.click();

        return this;
    }

    public PracticeFormPage setPhoneNumber(String userPhone) {
        phoneNumber.setValue(userPhone);

        return this;
    }

    public PracticeFormPage setDateOfBirth(String year, String month, String day) {
        dateOfBirth.click();
        calendar.setDate(year, month, day);

        return this;
    }

    public PracticeFormPage setHobbies(String...hobbiesList) {
            for (String s : hobbiesList) {
                $("[for=hobbies-checkbox-" + s + "]").click();
            }

        return this;
    }

    public PracticeFormPage uploadPic(File file) {
        uploadPictureButton.uploadFile(file);

        return this;
    }

    public PracticeFormPage setAddress(String userAddress) {
        address.setValue(userAddress);

        return this;
    }

    public PracticeFormPage setState(String userState) {
        usrState = userState;
        $("#state").click();
        switch (userState) {
            case "NCR" -> $("#react-select-3-option-" + "0").click();
            case "Uttar Pradesh" -> $("#react-select-3-option-" + "1").click();
            case "Haryana" -> $("#react-select-3-option-" + "2").click();
            case "Rajasthan" -> $("#react-select-3-option-" + "3").click();
        }

        return this;
    }

    public PracticeFormPage setCity(String userCity) {
        $("#city").click();
        switch (usrState) {
            case "NCR" -> {
                switch (userCity) {
                    case "Delhi" -> $("#react-select-4-option-" + "0").click();
                    case "Gurgaon" -> $("#react-select-4-option-" + "1").click();
                    case "Noida" -> $("#react-select-4-option-" + "2").click();
                }
            }
            case "Uttar Pradesh" -> {
                switch (userCity) {
                    case "Agra" -> $("#react-select-4-option-" + "0").click();
                    case "Lucknow" -> $("#react-select-4-option-" + "1").click();
                    case "Merrut" -> $("#react-select-4-option-" + "2").click();
                }
            }
            case "Haryana" -> {
                switch (userCity) {
                    case "Karnal" -> $("#react-select-4-option-" + "0").click();
                    case "Panipat" -> $("#react-select-4-option-" + "1").click();
                }
            }
            case "Rajasthan" -> {
                switch (userCity) {
                    case "Jaipur" -> $("#react-select-4-option-" + "0").click();
                    case "Jaiselmer" -> $("#react-select-4-option-" + "1").click();
                }
            }
        }

        return this;
    }

    public PracticeFormPage pressSubmitButton() {
        submitButton.click();

        return this;
    }

    public PracticeFormPage verifyRegistrationResultTableAppears() {
        table.verifyRegistrationResultTableAppears();

        return this;
    }

    public PracticeFormPage verifyResult(String key, String value) {
        table.verifyRegistrationResult(key, value);

        return this;
    }
}
