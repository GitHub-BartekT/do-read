package pl.iseebugs.loginandregister;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.iseebugs.loginandregister.projection.UserReadModel;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

class OurUserInfoDetails implements UserDetails {
    private final String username;
    private final String password;
    private final List<GrantedAuthority> roles;

    public OurUserInfoDetails(UserReadModel userReadModel){
        this.username = userReadModel.getUsername();
        this.password = userReadModel.getPassword();
        this.roles = Arrays.stream(userReadModel.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
