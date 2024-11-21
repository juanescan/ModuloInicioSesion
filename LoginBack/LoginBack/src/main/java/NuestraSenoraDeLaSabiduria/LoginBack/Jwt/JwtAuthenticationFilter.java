package NuestraSenoraDeLaSabiduria.LoginBack.Jwt;

import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  @SuppressWarnings("null")
  @Override
  protected void doFilterInternal(
    jakarta.servlet.http.HttpServletRequest request,
    jakarta.servlet.http.HttpServletResponse response,
    jakarta.servlet.FilterChain filterChain
  ) throws jakarta.servlet.ServletException, IOException {
    final String token = getTokenFromRequest(request);
    if (token != null) {
      filterChain.doFilter(request, response);
      return;
    }
    filterChain.doFilter(request, response);
  }

  private String getTokenFromRequest(
    jakarta.servlet.http.HttpServletRequest request
  ) {
    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
      return authHeader.substring(7);
    }
    return null;
  }
}
