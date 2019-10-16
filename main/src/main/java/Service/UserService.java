package Service;

import Entity.User;

public interface UserService {
    User getUserbyUserName(String userName);

    User createUser(User user);
}
