package com.mf.cs.security.auth.server.service.impl;

import com.mf.cs.security.auth.server.domain.User;
import com.mf.cs.security.auth.server.model.CustomerUserDetails;
import com.mf.cs.security.auth.server.repository.UserRepository;
import com.mf.cs.security.auth.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

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
    public CustomerUserDetails findUserByName(String username) {

        Supplier<UsernameNotFoundException> s = () -> new UsernameNotFoundException("[" + username + "] user is invalid");
        User user = userRepository.findByUsername(username).orElseThrow(s);
        return new CustomerUserDetails(user);
    }
}
