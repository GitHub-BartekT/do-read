package pl.iseebugs.loginandregister;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import pl.iseebugs.loginandregister.projection.UserReadModel;

class OurUserInfoDetailsService implements UserDetailsService {

    LoginAndRegisterFacade loginAndRegisterFacade;

    OurUserInfoDetailsService(LoginAndRegisterFacade loginAndRegisterFacade){
        this.loginAndRegisterFacade = loginAndRegisterFacade;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws BadCredentialsException {
        UserReadModel user = loginAndRegisterFacade.findByUsername(username);
        return getUser(user);
    }

    private OurUserInfoDetails getUser(UserReadModel userReadModel){
        return new OurUserInfoDetails(userReadModel);
    }
}
