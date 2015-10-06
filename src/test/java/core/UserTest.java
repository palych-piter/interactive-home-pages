package core;

import org.junit.Assert;
import org.junit.Test;

public class UserTest extends Assert {

    @Test
    public void UserTest() {
        User user = new User();

        user.name = "Andrey";
        user.email = "andr.bespalov@gmail.com";
        user.status = "golden";

    }


}
