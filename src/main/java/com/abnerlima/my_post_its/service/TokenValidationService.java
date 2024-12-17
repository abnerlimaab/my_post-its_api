package com.abnerlima.my_post_its.service;

import com.abnerlima.my_post_its.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TokenValidationService {

    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String GOOGLE_CLIENT_ID;

    private static final String GOOGLE_ISSUER_URI = "https://accounts.google.com";

    private static final String GOOGLE_JWK_URI = "https://www.googleapis.com/oauth2/v3/certs";

    public User validateGoogleToken(String idToken) {
        try {
            JwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri(GOOGLE_JWK_URI).build();
            Jwt decodedJwt = jwtDecoder.decode(idToken);

            System.out.println(decodedJwt);
            ArrayList<String> audience = decodedJwt.getClaim("aud");
            if (!GOOGLE_CLIENT_ID.equals(audience.getFirst())) {
                throw new JwtException("Invalid audience");
            }

            String issuer = decodedJwt.getClaim("iss");
            if (!GOOGLE_ISSUER_URI.equals(issuer)) {
                throw new JwtException("Invalid issuer");
            }

            String email = decodedJwt.getClaim("email");
            String firstName = decodedJwt.getClaim("given_name");
            String lastName = decodedJwt.getClaim("family_name");

            return new User(firstName, lastName, email);
        } catch (JwtException e) {
            e.printStackTrace();
            return null;
        }
    }
}
