package NuestraSenoraDeLaSabiduria.LoginBack.Jwt;

import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

  private static final String SECRET_KEY =
    "u83Dq5fKqgPiWxjF6qK9eA5D6L8F9yCzA6Z7P2D3r4kLf9HqA7J6kQ3V2eWx5H9K";

  public String getToken(Usuario usuario) {
    return getToken(new HashMap<>(), usuario);
  }

  private String getToken(Map<String, Object> extraClaim, Usuario usuario) {
    return Jwts
      .builder()
      .setClaims(extraClaim)
      .setSubject(usuario.getNombreUsuario())
      .setIssuedAt(new Date(System.currentTimeMillis()))
      .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
      .signWith(getKey(), SignatureAlgorithm.HS256)
      .compact();
  }

  private Key getKey() {
    byte[] secretBytes = java.util.Base64.getDecoder().decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(secretBytes);
  }
}
