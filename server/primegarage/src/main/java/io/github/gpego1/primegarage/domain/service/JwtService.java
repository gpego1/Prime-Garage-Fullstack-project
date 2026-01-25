package io.github.gpego1.primegarage.domain.service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.github.gpego1.primegarage.domain.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC256(secret);
    }

    public String generateToken(User user) {
        return JWT.create()
                .withClaim("userId", user.getId())
                .withSubject(user.getUsername())
                .withExpiresAt(Date.from(Instant.now().plusSeconds(expiration)))
                .withIssuedAt(Instant.now())
                .sign(getAlgorithm());
    }

    public String validateToken(String token) {
        JWTVerifier verifier = JWT.require(getAlgorithm()).build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getSubject();
    }
}
