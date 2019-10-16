package Service;

import Entity.User;

public interface UserService {
    User getUserByCredentials(String username, String password);

    User createUser(User user);


}
