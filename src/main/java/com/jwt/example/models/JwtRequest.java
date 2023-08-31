package com.jwt.example.models;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {
    private String email;
    private String password;
}
