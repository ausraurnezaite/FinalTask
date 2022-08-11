package com.coherentsolutions.training.automation.java.web.urnezaite.user;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;

public class UserDataGenerator {
    private static UserData userData;
    private static Faker faker = new Faker();
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static String[] date = sdf.format(faker.date().birthday(18, 100)).split("/");

    public static UserData generate() {
        return userData = new UserData.Builder()
                .gender(getRandomGender())
                .firstName(getRandomFirstName())
                .lastName(getRandomLastName())
                .password(System.getenv("TEST_PASSWORD"))
                .birthDay(getRandomBirthDay())
                .birthMonth(getRandomBirthMonth())
                .birthYear(getRandomBirthYear())
                .streetAndHouseNo(getRandomAddress())
                .city(getRandomCity())
                .state(getRandomState())
                .postalCode(getRandomPostalCode())
                .phoneNo(getRandomPhoneNo())
                .build();
    }

    private static int getRandomGender() {
        return faker.random().nextInt(1, 2);
    }

    private static String getRandomFirstName() {
        return faker.name().firstName();
    }

    private static String getRandomLastName() {
        return faker.name().lastName();
    }

    private static String shortenDate(String number){
        int i = Integer.parseInt(number);
        return String.valueOf(i);

    }

    private static String getRandomBirthDay() {
        return shortenDate(date[0]);
    }

    private static String getRandomBirthMonth() {
        return shortenDate(date[1]);
    }

    private static String getRandomBirthYear() {
        return shortenDate(date[2]);
    }

    private static String getRandomAddress() {
        return faker.address().streetAddress();
    }

    private static String getRandomCity() {
        return faker.address().city();
    }

    private static String getRandomState() {
        return faker.address().state();
    }

    private static String getRandomPostalCode() {
        return faker.address().zipCode();
    }

    private static String getRandomPhoneNo() {
        return faker.phoneNumber().cellPhone();
    }
}