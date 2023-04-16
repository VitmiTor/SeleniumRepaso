package data;

import model.UserData;
import model.UserRegister;
import org.testng.annotations.DataProvider;
import utilities.Logs;

public class DataGiver {
    public static final String invalidInfoDPName = "DataGiver";

    @DataProvider(name = invalidInfoDPName)
    public Object[][] invalidInfoDP() {
        final var map = MapParser.getErrorMessageMap();

        final var userRegister = new UserRegister();
        final var firstName = userRegister.getFirstName();
        final var lastname = userRegister.getLastName();
        final var email = userRegister.getEmail();
        final var telephone = userRegister.getTelephone();
        final var password = userRegister.getPassword();

        return new Object[][]{
                {"", lastname, email, telephone, password, password, map.get("errorFirstName")},
                {firstName, "", email, telephone, password, password, map.get("errorLastName")},
                {firstName, lastname, "", telephone, password, password, map.get("errorEmail")},
                {firstName, lastname, email, "", password, password, map.get("errorTelephone")},
                {firstName, lastname, email, telephone, "", password, map.get("errorPassword")},
                {firstName, lastname, email, telephone, password, "", map.get("errorConfirmPassword")}
        };
    }

    public UserData getValidCredentials() {
        Logs.debug("getting valid Credentials");
        return MapParser.getCredentials().get("valid");
    }
}
