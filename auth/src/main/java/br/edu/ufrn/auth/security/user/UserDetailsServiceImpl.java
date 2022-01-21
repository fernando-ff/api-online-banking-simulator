package br.edu.ufrn.auth.security.user;

import br.edu.ufrn.core.model.User;
import br.edu.ufrn.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Collection;

import static org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList;

/**
 * @author William Suane
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository applicationUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        log.info("Searching in the DB the user by username '{}'", username);

        User applicationUser = applicationUserRepository.findByUsername(username);

        log.info("User found '{}'", applicationUser);

        if (applicationUser == null)
            throw new UsernameNotFoundException(String.format("Application user '%s' not found", username));

        return applicationUser;
    }

    // private static final class CustomUserDetails extends User implements UserDetails {
    //     CustomUserDetails(@NotNull User applicationUser) {
    //         super(applicationUser);
    //     }

    //     @Override
    //     public Collection<? extends GrantedAuthority> getAuthorities() {
    //         return commaSeparatedStringToAuthorityList("ROLE_" + this.getRole());
    //     }

    //     @Override
    //     public boolean isAccountNonExpired() {
    //         return true;
    //     }

    //     @Override
    //     public boolean isAccountNonLocked() {
    //         return true;
    //     }

    //     @Override
    //     public boolean isCredentialsNonExpired() {
    //         return true;
    //     }

    //     @Override
    //     public boolean isEnabled() {
    //         return true;
    //     }
    // }
}
