package com.mf.cs.security.auth.server.service;

import com.mf.cs.security.auth.server.domain.User;

public interface UserService {

    User addUser(User user);

    User findUserByName(String username);
}
