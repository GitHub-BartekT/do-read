package pl.iseebugs.loginandregister;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import pl.iseebugs.loginandregister.projection.UserReadModel;

@Service
class OurUserInfoDetailsFacade implements UserDetailsService {
    private static final String USER_NOT_FOUND = "User not found";

    OurUserRepository ourUserRepository;

    OurUserInfoDetailsFacade(OurUserRepository ourUserRepository){
        this.ourUserRepository = ourUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws BadCredentialsException {
        UserReadModel user = findByUsername(username);
        return getUser(user);
    }

    private OurUserInfoDetails getUser(UserReadModel userReadModel){
        return new OurUserInfoDetails(userReadModel);
    }


    UserReadModel findByUsername(final String username) throws BadCredentialsException {
        return ourUserRepository.findByUsername(username)
                .map(user -> new UserReadModel.Builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .id(user.getId())
                        .roles(user.getRoles())
                        .build())
                .orElseThrow(() -> new BadCredentialsException(USER_NOT_FOUND));
    }
}
