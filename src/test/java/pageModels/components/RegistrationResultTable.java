package pageModels.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultTable {

    public void verifyRegistrationResultTableAppears() {
        $(".modal-dialog").should(Condition.appear);
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyRegistrationResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }
}
