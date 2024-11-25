package NuestraSenoraDeLaSabiduria.LoginBack.Jwt;

import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

  private static final String SECRET_KEY =
    "u83Dq5fKqgPiWxjF6qK9eA5D6L8F9yCzA6Z7P2D3r4kLf9HqA7J6kQ3V2eWx5H9K";

  public String getToken(Usuario usuario) {
    return getToken(new HashMap<>(), usuario);
  }

  private String getToken(Map<String, Object> extraClaim, Usuario usuario) {
    System.out.print(
      "Generando token para el usuario: " + usuario.getNombreUsuario()
    );
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
    return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
  }

  public boolean isTokenValid(String token, UserDetails userDetails) {
    final String username = getUserNameFromToken(token);
    return (
      username.equals(userDetails.getUsername()) && !isTokenExpired(token)
    );
  }

  public String getUserNameFromToken(String token) {
    return getClaim(token, Claims::getSubject);
  }

  private Claims getAllClaimsFromToken(String token) {
    return Jwts
      .parserBuilder()
      .setSigningKey(getKey())
      .build()
      .parseClaimsJws(token)
      .getBody();
  }

  public <T> T getClaim(String token, Function<Claims, T> claimsResolve) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolve.apply(claims);
  }

  private Date getExpiration(String token) {
    return getClaim(token, Claims::getExpiration);
  }

  private boolean isTokenExpired(String token) {
    return getExpiration(token).before(new Date());
  }
}
