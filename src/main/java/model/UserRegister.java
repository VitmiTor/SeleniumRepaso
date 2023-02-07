package model;

import com.github.javafaker.Faker;

public class UserRegister {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String telephone;
    private final String password;
    private final String confirmPassword;

    public UserRegister() {
        final var faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
        telephone = faker.phoneNumber().phoneNumber();
        password = faker.internet().password();
        confirmPassword = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
