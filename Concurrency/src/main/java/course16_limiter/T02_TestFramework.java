package course16_limiter;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class T02_TestFramework {


    @Test
    public void testAddUser() {
        User user = new User();
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            users.add(user);
        }
        for (User u : users) {
            System.out.println(u);
        }
    }

    class User {

    }

}
