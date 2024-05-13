package pl.iseebugs.ports;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.iseebugs.loginandregister.projection.RegisterResultReadModel;
import pl.iseebugs.loginandregister.projection.UserReadModel;
import pl.iseebugs.loginandregister.projection.UserWriteModel;

@Component
public interface LoginAndRegisterService {
    UserReadModel findByUsername(String username) throws Exception;
    RegisterResultReadModel register(UserWriteModel userWriteModel);
}
