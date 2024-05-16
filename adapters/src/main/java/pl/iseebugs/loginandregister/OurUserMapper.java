package pl.iseebugs.loginandregister;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class OurUserMapper {
    static OurUserInfoDetails formEntityToUserDetails(OurUser userDetails){
        return new OurUserInfoDetails(userDetails.getUsername(), userDetails.getPassword(), toGrantedAuthoritiesList(userDetails.getRoles()));
    }

    static List<GrantedAuthority> toGrantedAuthoritiesList (String roles){
        return Arrays.stream(roles.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
