import org.junit.jupiter.api.Test;
import testConfig.BaseTest;
import java.io.File;

public class PracticeFormTest extends BaseTest {
    static File photo = new File("D:\\dark.jpeg");

    @Test
    void successFillPracticeFormTest() {
        page.openPage()
                .fillFirstName("Serega")
                .fillLastName("Testerov")
                .setEmail("serega@testmail.com")
                .setGender("Male")
                .setPhoneNumber("9181104115")
                .setDateOfBirth("2000", "October", "30")
                .setHobbies("1", "3")
                .uploadPic(photo)
                .setAddress("samara")
                .setState("Uttar Pradesh")
                .setCity("Lucknow")
                .pressSubmitButton();





        page.verifyRegistrationResultTableAppears()
                .verifyResult("Student Name", "Serega Testerov")
                .verifyResult("Student Email", "serega@testmail.com")
                .verifyResult("Gender", "male")
                .verifyResult("Mobile", "9181104115")
                .verifyResult("Date of Birth", "30 October,2000");



//        $("#output").shouldHave(
//                text("Serega"),
//                text("Testerov"),
//                text("testQA@63rus.com"),
//                text("myAddrress"),
//                text("asd")
//        );
    }
}
