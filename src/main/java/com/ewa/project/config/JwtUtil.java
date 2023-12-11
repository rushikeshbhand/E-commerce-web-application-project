package com.ewa.project.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.sql.Date;
public class JwtUtil {

 public static final String SECRET_KEY = "ecom";
 public static final long EXPIRATION_TIME = 8600000;

 public static String generateToken(String email) {
     return Jwts.builder()
             .setSubject(email)
             .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
             .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
             .compact();
 }

 public static String extractEmail(String token) {
     return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
 }
}

