package pl.sdaacademy.PokemonAcademyApi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import pl.sdaacademy.PokemonAcademyApi.registration.service.PokemonApiUserProvider;
import pl.sdaacademy.PokemonAcademyApi.security.AuthenticationFilter;
import pl.sdaacademy.PokemonAcademyApi.security.AuthorizationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PokemonApiUserProvider pokemonApiUserProvider;
    private final PasswordEncoder passwordEncoder;
    private final String securityKey;
    private final String authorizationType;
    private final String authorizationHeaderName;

    @Autowired
    public SecurityConfig(PokemonApiUserProvider pokemonApiUserProvider,
                          PasswordEncoder passwordEncoder,
                          @Value("${paa.security_key}") String securityKey,
                          @Value("${paa.authorization_type}") String authorizationType,
                          @Value("${paa.authorization_header_name}") String authorizationHeaderName) {
        this.pokemonApiUserProvider = pokemonApiUserProvider;
        this.passwordEncoder = passwordEncoder;
        this.securityKey = securityKey;
        this.authorizationHeaderName = authorizationHeaderName;
        this.authorizationType = authorizationType;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/pokemons").authenticated()
                .antMatchers("/pokemons/list").authenticated()
                .antMatchers("/pokemons/signup").permitAll();
        http.csrf().disable();
        http.addFilter(new AuthenticationFilter(authenticationManager(),
                securityKey,
                authorizationType,
                authorizationHeaderName));
        http.addFilter(new AuthorizationFilter(securityKey,
                authorizationHeaderName,
                authorizationType,
                authenticationManager()));
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(pokemonApiUserProvider).passwordEncoder(passwordEncoder);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}