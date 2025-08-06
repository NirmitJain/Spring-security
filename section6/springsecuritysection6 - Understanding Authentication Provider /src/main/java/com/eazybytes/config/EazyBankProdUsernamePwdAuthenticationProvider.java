package com.eazybytes.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
@RequiredArgsConstructor
public class EazyBankProdUsernamePwdAuthenticationProvider implements AuthenticationProvider {


    private final EazyBankUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    /**
     * @param authentication the authentication request object.
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(passwordEncoder.matches(password,userDetails.getPassword())){
            // fetch age details and perform validation to check if age is greater than 18
            return new UsernamePasswordAuthenticationToken(username,password,userDetails.getAuthorities());
        }else {
            throw new BadCredentialsException("Invalid Password");
        }

    }

    /**
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
