package pl.iseebugs.loginandregister;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.iseebugs.loginandregister.projection.RegisterResultReadModel;
import pl.iseebugs.loginandregister.projection.UserReadModel;
import pl.iseebugs.loginandregister.projection.UserWriteModel;
import pl.iseebugs.ports.LoginAndRegisterService;


@Service
class LoginAndRegisterFacade implements LoginAndRegisterService {
    private final Logger logger = LoggerFactory.getLogger(LoginAndRegisterFacade.class);

    private static final String USER_NOT_FOUND = "User not found";
    private final OurUserRepository ourUserRepository;

    @Autowired
    LoginAndRegisterFacade(OurUserRepository ourUserRepository){
        this.ourUserRepository = ourUserRepository;
    }

    @Override
    public UserReadModel findByUsername(final String username) throws Exception {
        return ourUserRepository.findByUsername(username)
                .map(user -> new UserReadModel.Builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .id(user.getId())
                        .roles(user.getRoles())
                        .build())
                .orElseThrow(() -> new Exception(USER_NOT_FOUND));
    }

    @Override
    public RegisterResultReadModel register(final UserWriteModel userWriteModel) {
        if (ourUserRepository.existsByUsername(userWriteModel.getUsername())){
            logger.info("LoginAndRegisterFacade failed to register: " + userWriteModel.getUsername());
            return new RegisterResultReadModel(userWriteModel.getUsername(), "",false);
        }

        OurUser toSave = new OurUser.Builder()
                .password(userWriteModel.getPassword())
                .username(userWriteModel.getUsername())
                .roles("USER")
                .build();

        OurUser saved = ourUserRepository.save(toSave);
        logger.info("LoginAndRegisterFacade successfully registered: " + saved.getUsername());
        return new RegisterResultReadModel(userWriteModel.getUsername(), saved.getRoles(), true);
    }
}
