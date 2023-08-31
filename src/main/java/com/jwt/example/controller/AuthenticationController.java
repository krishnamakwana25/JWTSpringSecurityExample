package com.jwt.example.controller;

import com.jwt.example.models.JwtReponse;
import com.jwt.example.models.JwtRequest;
import com.jwt.example.entities.User;
import com.jwt.example.security.JWTHelper;
import com.jwt.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    //to fetch information of user
    @Autowired
    private UserDetailsService userDetailsService;
    //to authenticate user
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private JWTHelper jwtHelper;

    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity<JwtReponse> login(@RequestBody JwtRequest jwtRequest){
        this.doAuthenticate(jwtRequest.getEmail(), jwtRequest.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getEmail());
        String token = this.jwtHelper.generateToken(userDetails);
        log.info("token: {}",token);
        return ResponseEntity.status(HttpStatus.OK)
                .body(JwtReponse.builder()
                        .token(token)
                        .userName(userDetails.getUsername())
                .build());
    }

    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(email,password);
        try {
            manager.authenticate(authenticationToken);
        }
        catch (BadCredentialsException e){
            throw new BadCredentialsException("Invalid username or password..!!");
        }
    }
    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler(){
        return "Credentials Invalid..!!";
    }

    @PostMapping("/createuser")
    public User createUser(@RequestBody User user){
        log.info("[createUser] user: {}",user );
        return userService.createUser(user);
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(user1.toString());
    }
}
