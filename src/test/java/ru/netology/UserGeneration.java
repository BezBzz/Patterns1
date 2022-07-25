package ru.netology;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class UserGeneration {
    public static UserData generateUser(int Day) {
        String city = generateCity();
        String date = generateDate(Day);
        String name = generateName();
        String phone = generatePhone();
        UserData user = new UserData(city, date, name, phone);
        return user;
    }

    private static String generateCity() {
        String[] cities = new String[]{"Владикавказ", "Уфа", "Нижний Новгород", "Великий Новгород", "Новосибирск", "Омск", "Оренбург", "Орёл",
                "Пенза", "Псков", "Ростов-на-Дону", "Рязань", "Самара", "Саратов", "Москва",
                "Екатеринбург", "Смоленск", "Тамбов", "Тверь",};
        Faker faker = new Faker();
        int index = faker.number().numberBetween(0, cities.length - 1);
        String city = cities[index];
        return city;
    }

    public static String generateDate(int Day) {
        String meetDate = LocalDate.now().plusDays(Day).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return meetDate;
    }

    public static String generateName() {
        Faker faker = new Faker(new Locale("ru"));
        String name = faker.name().lastName() + " " + faker.name().firstName();
        return name;
    }

    public static String generatePhone() {
        Faker faker = new Faker(new Locale("ru"));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }
}

