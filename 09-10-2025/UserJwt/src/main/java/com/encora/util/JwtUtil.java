package com.encora.util;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	private final long EXPIRATION_TIME = 1000 * 60 * 60;
	private final static String SECRET = "my-secret-super-key-for-enough-@#123457383739383838";
	private final static SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());
	
	public String generateToken(String username) {
		return Jwts.builder()
			.setSubject(username)
			.setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
			.signWith(key, SignatureAlgorithm.HS256)
			.compact();
	}

	public String extractUsername(String token) {
		Claims body = extractClaims(token);
		return body.getSubject();
	}

	private static Claims extractClaims(String token) {
		return Jwts.parserBuilder()
					.setSigningKey(key)
					.build()
					.parseClaimsJws(token)
					.getBody();
	}

	public static boolean validateToken(UserDetails userDetails, String username, String token) {
		return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
	}

	private static boolean isTokenExpired(String token) {
		return extractClaims(token).getExpiration().before(new Date());
	}
}
