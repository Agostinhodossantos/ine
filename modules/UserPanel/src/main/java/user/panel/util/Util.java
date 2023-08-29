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
        List<User> users = UserLocalServiceUtil.getUsers(0, 1000);
        User user = null;

        for (User u : users) {
        	if (u.getUserId() == userId) {
        		user = u;
        		break;
        	}
        }
       return user;
    }

    public static List<User> searchUserByName(String name) {
        List<User> users = UserLocalServiceUtil.getUsers(0, 1000);
        List<User> usersList = null;

        for (User u : users) {
        	if (u.getFullName().toLowerCase().contains(name.toLowerCase())) {
        		usersList.add(u);
        	}
        }

        return usersList;
    }

}
