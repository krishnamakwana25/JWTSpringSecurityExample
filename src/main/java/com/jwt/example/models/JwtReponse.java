package com.jwt.example.models;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JwtReponse {
    private String token;
    private String userName;
}
