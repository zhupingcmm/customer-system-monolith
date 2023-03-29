package com.mf.cs.security.auth.server.service;

import com.mf.cs.security.auth.server.domain.User;
import com.mf.cs.security.auth.server.model.CustomerUserDetails;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    User addUser(User user);

    CustomerUserDetails findUserByName(String username);
}
