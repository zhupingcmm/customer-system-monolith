package com.mf.cs.security.auth.server.service.impl;

import com.mf.cs.security.auth.server.domain.User;
import com.mf.cs.security.auth.server.repository.UserRepository;
import com.mf.cs.security.auth.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findUserByName(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        return user;
    }
}
