package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;



public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(String locale) {
        String[] cities = new String[]{"Самара", "Казань", "Уфа", "Москва", "Санкт-Петербург", "Рязань",
                "Ростов-на-Дону", "Майкоп", "Чита", "Воронеж", "Краснодар", "Тверь", "Астрахань",
                "Пермь", "Омск", "Пенза", "Севастополь", "Саратов", "Ижевск", "Ульяновск", "Оренбург",
                "Новосибирск", "Великий Новогород", "Чита", "Петропавловск-Камчатский", "Кемерово", "Брянск",
                "Киров", "Якутскск", "Челябинск", "Кострома","Ярославль", "Нарьян-Мар", "Владивосток"};
            Faker faker = new Faker(new Locale(locale));
            return cities[faker.number().numberBetween(0, cities.length - 1)];

    }
    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().fullName();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }


    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(locale),generateName(locale),generatePhone (locale));
        }

    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}