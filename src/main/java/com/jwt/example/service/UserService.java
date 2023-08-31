package com.jwt.example.service;

import com.jwt.example.entities.User;
import com.jwt.example.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserService {
    private List<User> users = new ArrayList<>();
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public List<User> getUsers(){
        log.info("[getUsers] List All Users");
        return userRepository.findAll();
    }
    public User createUser(User user){
        log.info("[createUser] user: {}",user );
        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

//    public UserService() {
//        users.add(new User(UUID.randomUUID().toString(), "Krishna Makwana","krishnamakwana@gmail.com"));
//        users.add(new User(UUID.randomUUID().toString(), "Harsh Makwana","harshmakwana@gmail.com"));
//        users.add(new User(UUID.randomUUID().toString(), "Akshit Mokani","mokaniakshit@gmail.com"));
//        users.add(new User(UUID.randomUUID().toString(), "Heena Barot","barotheena@gmail.com"));
//        users.add(new User(UUID.randomUUID().toString(), "Mona Desai","monadesai@gmail.com"));
//
//    }

}
