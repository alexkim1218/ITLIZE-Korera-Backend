package com.korera.main.Service;

import com.korera.main.Entity.User;

public interface UserService {
    User getUserByCredentials(String username, String password);

    User createUser(User user);


}
