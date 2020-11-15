package pl.sdaacademy.PokemonAcademyApi.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pl.sdaacademy.PokemonAcademyApi.registration.repository.PokemonApiUser;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final long TOKEN_EXPIRATION_TIME = 3_600_000;
    private final AuthenticationManager authenticationManager;
    private final String securityKey;
    private final String authorizationType;
    private final String authorizationHeaderName;

    public AuthenticationFilter(AuthenticationManager authenticationManager,
                                String securityKey,
                                String authorizationType,
                                String authorizationHeaderName) {
        this.authenticationManager = authenticationManager;
        this.securityKey = securityKey;
        this.authorizationType = authorizationType;
        this.authorizationHeaderName = authorizationHeaderName;
        setFilterProcessesUrl("/pokemons/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        Optional<PokemonApiUser> pokemonApiUserOptional = Optional.empty();
        try {
            pokemonApiUserOptional = Optional.ofNullable(new ObjectMapper().readValue(request.getInputStream(), PokemonApiUser.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pokemonApiUserOptional.<UsernameNotFoundException>orElseThrow(() -> {
            throw new UsernameNotFoundException("no user to authenticate!");
        });
        PokemonApiUser pokemonApiUser = pokemonApiUserOptional.get();
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(pokemonApiUser.getLogin(),
                pokemonApiUser.getPassword(), Collections.emptyList()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String token = Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
                .setSubject(((User) authResult.getPrincipal()).getUsername())
                .signWith(SignatureAlgorithm.HS512, securityKey.getBytes())
                .compact();
        response.addHeader("Access-Control-Expose-Headers", "Authorization");
        response.addHeader(authorizationHeaderName, authorizationType + " " + token);
    }
}