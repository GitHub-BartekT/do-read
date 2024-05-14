package pl.iseebugs.loginandregister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.iseebugs.loginandregister.projection.RegisterResultReadModel;
import pl.iseebugs.loginandregister.projection.UserWriteModel;

@RestController
@RequestMapping("/api")
class RegisterController {

    LoginAndRegisterFacade loginAndRegisterFacade;
    PasswordEncoder passwordEncoder;

    @Autowired
    RegisterController(LoginAndRegisterFacade loginAndRegisterFacade, PasswordEncoder passwordEncoder){
        this.loginAndRegisterFacade = loginAndRegisterFacade;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String goHome(){
        return "This is public access without any authentication. Some landing page.";
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResultReadModel> response(@RequestBody UserWriteModel userWriteModel){
        userWriteModel.setPassword(passwordEncoder.encode(userWriteModel.getPassword()));
        RegisterResultReadModel registerResult = loginAndRegisterFacade.register(userWriteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerResult);
    }
}
