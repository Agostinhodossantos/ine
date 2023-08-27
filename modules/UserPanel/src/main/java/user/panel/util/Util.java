package user.panel.util;


import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.List;

public class Util {

    public static List<User> getUsers() {
        List<User> users = UserLocalServiceUtil.getUsers(0, 1000);

        return users;
    }

    public static User getUserById(long userId) {
        System.out.print("UserID: "+userId);
        List<User> users = UserLocalServiceUtil.getUsers(0, 1000);
        return users.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

}
