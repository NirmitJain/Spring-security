package com.eazybytes.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("!prod")
public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {


    private final EazyBankUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    /**
     * @param authentication the authentication request object.
     * @return a fully authenticated object including credentials
     * @throws AuthenticationException if authentication fails
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
       /* if(passwordEncoder.matches(password,userDetails.getPassword())){*/
            // fetch age details and perform validation to check if age is greater than 18
        return new UsernamePasswordAuthenticationToken(username,password,userDetails.getAuthorities());
       /* }else {
            throw new BadCredentialsException("Invalid Password");
        }*/

    }

    /**
     * Indicates whether this authentication provider supports the indicated authentication object.
     *
     * @param authentication the authentication object to be checked for support
     * @return true if the authentication object is supported by this provider, false otherwise
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
