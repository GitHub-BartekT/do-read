package pl.iseebugs.loginandregister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.iseebugs.loginandregister.projection.AuthReqRespDTO;

@RestController
@RequestMapping("/api/auth")
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
        return "This is public access without any authentication. You should first signup at /api/auth/signup than login at /api/auth/signin.";
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthReqRespDTO> signUp(@RequestBody AuthReqRespDTO signUpRequest){
        return  ResponseEntity.ok(loginAndRegisterFacade.signUp(signUpRequest));
    }


    @PostMapping("/signin")
    public ResponseEntity<AuthReqRespDTO> signIn(@RequestBody AuthReqRespDTO signInRequest){
        return  ResponseEntity.ok(loginAndRegisterFacade.signIn(signInRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthReqRespDTO> refreshToken(@RequestBody AuthReqRespDTO refreshTokenRequest){
        return  ResponseEntity.ok(loginAndRegisterFacade.refreshToken(refreshTokenRequest));
    }
}
