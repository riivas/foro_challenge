package alura.challenge.blog.infra.security;

import alura.challenge.blog.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${blog.security.token.secret}")
    private String pwdSecret;

    public String generarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(pwdSecret);
            return JWT.create()
                    .withIssuer("foro challenge")
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException e){
            throw new RuntimeException();
        }
    }

    public String getSubject(String token){
        if (token == null){
            throw new RuntimeException();
        }

        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(pwdSecret);
            verifier = JWT.require(algorithm)
                    .withIssuer("foro challenge")
                    .build()
                    .verify(token);

            verifier.getSubject();
        } catch (JWTVerificationException jwtVE){
            throw new RuntimeException();
        }

        if (verifier.getSubject() == null){
            throw new RuntimeException("Verifier invalido");
        }

        return verifier.getSubject();
    }


    private Instant generarFechaExpiracion(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
}
