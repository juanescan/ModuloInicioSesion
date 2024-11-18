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

  private static final String SECRET_KEY = "your-256-bit-secret-key";

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
    System.out.println("algo");
    return Keys.hmacShaKeyFor(secretBytes);
  }
}
