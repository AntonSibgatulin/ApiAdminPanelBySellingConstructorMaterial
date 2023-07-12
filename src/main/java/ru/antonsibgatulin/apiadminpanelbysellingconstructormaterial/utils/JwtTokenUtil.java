package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils;


import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {
    private static final String SECRET_KEY = "77397A24432646294A404E635166546A576E5A7234753778214125442A472D4B";
    private static final Long EXPIRATION_TIME = 86400000L * 365L;


    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        var now = new Date();
        var expiration = new Date(now.getTime() + EXPIRATION_TIME);
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(now).setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        String email = getEmailFromToken(token);
        return (userDetails.getUsername().equals(email));
    }


    public String getEmailFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public Date getExpirationDateFromToken(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration();
    }



}
