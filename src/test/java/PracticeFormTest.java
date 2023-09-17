import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import testConfig.BaseTest;
import utils.RandomUtils;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class PracticeFormTest extends BaseTest {
    static File photo = new File("D:\\dark.jpeg");
    static String [] dateOfBirth = new String [] {"2000", "October", "30"};
    static String [] hobbies = new String[] {"1", "2", "3"};

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("Sergey", "Ivanov", RandomUtils.getRandomEmail(RandomUtils.getRandomInteger(5,10)), RandomUtils.getRandomGender(),
                        RandomUtils.getRandomPhoneNumber(), dateOfBirth, Arrays.copyOfRange(hobbies, 0,RandomUtils.getRandomInteger(0,hobbies.length-1)),
                        RandomUtils.getRandomAddress(), "Uttar Pradesh", "Lucknow"),
                Arguments.of("Ivan", "Sergeev", RandomUtils.getRandomEmail(RandomUtils.getRandomInteger(5,10)), RandomUtils.getRandomGender(),
                        RandomUtils.getRandomPhoneNumber(), dateOfBirth, Arrays.copyOfRange(hobbies, 0,RandomUtils.getRandomInteger(0,hobbies.length)),
                        RandomUtils.getRandomAddress(), "Uttar Pradesh", "Lucknow")
        );
    }

    @MethodSource("dataProvider")
    @DisplayName("Success registration")
    @ParameterizedTest
    void successFillPracticeFormTest(String firstName, String lastName, String email, String gender, String phoneNumber,
        String [] dateOfBirth, String [] hobbiesList, String address, String state, String city) {
        page.openPage()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setDateOfBirth(dateOfBirth[0], dateOfBirth[1],dateOfBirth[2])
                .setHobbies(hobbiesList)
                .uploadPic(photo)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .pressSubmitButton();

        page.verifyRegistrationResultTableAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", dateOfBirth[2] + " " + dateOfBirth[1] + "," + dateOfBirth[0]);
    }
}
