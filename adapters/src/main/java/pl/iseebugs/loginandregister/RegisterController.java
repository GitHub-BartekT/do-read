package pl.iseebugs.loginandregister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.iseebugs.loginandregister.projection.RegisterResultReadModel;
import pl.iseebugs.loginandregister.projection.UserWriteModel;

@RestController
@RequestMapping("/api")
class RegisterController {

    LoginAndRegisterFacade loginAndRegisterFacade;

    @Autowired
    RegisterController(LoginAndRegisterFacade loginAndRegisterFacade){
        this.loginAndRegisterFacade = loginAndRegisterFacade;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResultReadModel> response(@RequestBody UserWriteModel userWriteModel){
        RegisterResultReadModel registerResult = loginAndRegisterFacade.register(userWriteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerResult);
    }
}
