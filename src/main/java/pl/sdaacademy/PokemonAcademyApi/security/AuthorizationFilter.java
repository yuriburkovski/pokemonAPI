package pl.sdaacademy.PokemonAcademyApi.security;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class AuthorizationFilter extends BasicAuthenticationFilter {
    private final String authorizationHeaderName;
    private final String authorizationType;
    private final String securityKey;

    public AuthorizationFilter(String securityKey, String authorizationHeaderName, String authorizationType, AuthenticationManager authenticationManager) {
        super(authenticationManager);
        this.authorizationType = authorizationType;
        this.authorizationHeaderName = authorizationHeaderName;
        this.securityKey = securityKey;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(authorizationHeaderName);
        if (header == null || !header.startsWith(authorizationType)) {
            chain.doFilter(request, response);
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(validateToken(header));
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken validateToken(String header) {
        String userName = Jwts.parser()
                .setSigningKey(securityKey.getBytes())
                .parseClaimsJws(header.replace(authorizationType + " ", ""))
                .getBody()
                .getSubject();
        return userName != null ?
                new UsernamePasswordAuthenticationToken(userName, null, Collections.emptyList()) : null;
    }
}