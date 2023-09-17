package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    private static Faker faker = new Faker(new Locale("RU"));

    public static void main(String[] args) {
        //для отладки
    }

    public static String getRandomString(int length) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder result = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            result.append(s.charAt(secureRandom.nextInt(s.length())));
        }

        return new String(result);
    }

    public static int getRandomInteger(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max+1);
    }

    public static String getRandomEmail(int length) {
        return getRandomString(length) + "@gmail.com";
    }

    public static String getRandomAddress() {
        return getRandomString(5) + " street";
    }

    public static String getRandomElementFromArray(String [] array) {
        int i = getRandomInteger(0, array.length-1);
        
        return array[i];
    }

    public static String getRandomGender() {
        String [] genders = {"Male", "Female", "Other"};

        return getRandomElementFromArray(genders);
    }

    public static String getRandomPhoneNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(String.valueOf(RandomUtils.getRandomInteger(1,9)));
        }

        return sb.toString();
    }

    //why doesn't work with RU locale ?
    public static String getFakeFirstName() {
        return faker.name().firstName();
    }

    //why doesn't work with RU locale ?
    public static String getFakeLastName() {
        return faker.name().lastName();
    }

    //Why doesn't work with RU locale ?
    public static String getFakeAddress() {
        return faker.address().fullAddress();
    }

    public static String getFakePhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    //Why doesn't work with RU locale ?
    public static String getFakeFullName() {
        return faker.name().fullName();
    }

    public static String getFakeEmail() {
        return faker.internet().emailAddress();
    }
}
