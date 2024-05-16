package pl.iseebugs.loginandregister;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
class LoginAndRegisterFacade {
    private final OurUserRepository ourUserRepository;
    private final JWTUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    LoginAndRegisterFacade(OurUserRepository ourUserRepository, JWTUtils jwtUtils, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager){
        this.ourUserRepository = ourUserRepository;
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public AuthReqRespDTO signUp(AuthReqRespDTO registrationRequest){
        AuthReqRespDTO responseDTO = new AuthReqRespDTO();
        try {
            String username = registrationRequest.getUsername();
            String password = passwordEncoder.encode(registrationRequest.getPassword());
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("ROLE_USER"));

            OurUserInfoDetails ourUserToSave = new OurUserInfoDetails(username, password, roles);
            OurUser ourUserResult = ourUserRepository.save(ourUserToSave.toNewOurUser());
            if (ourUserResult != null && ourUserResult.getId() != null){
                responseDTO.setMessage("User saved successfully");
                responseDTO.setStatusCode(200);
            }
        }catch (Exception e){
                responseDTO.setStatusCode(500);
                responseDTO.setError(e.getMessage());
        }
        return responseDTO;
    }

    public AuthReqRespDTO signIn(AuthReqRespDTO signingRequest){
        AuthReqRespDTO response = new AuthReqRespDTO();

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signingRequest.getUsername(),signingRequest.getPassword()));
            var user = ourUserRepository.findByUsername(signingRequest.getUsername()).orElseThrow();
            System.out.println("USER IS: " + user);
            UserDetails userToJWT = OurUserMapper.formEntityToUserDetails(user);
            var jwt = jwtUtils.generateToken(userToJWT);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), userToJWT);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshToken);
            response.setExpirationTime("15 minutes");
            response.setMessage("Successfully singed in");
        }catch (Exception e){
            response.setStatusCode(500);
            response.setError(e.getMessage());
        }
        return response;
    }

    public AuthReqRespDTO refreshToken(AuthReqRespDTO refreshTokenRegister){
        AuthReqRespDTO response = new AuthReqRespDTO();

        String ourEmail = jwtUtils.extractUsername(refreshTokenRegister.getToken());
        OurUser user = ourUserRepository.findByUsername(ourEmail).orElseThrow();
        UserDetails userToJWT = OurUserMapper.formEntityToUserDetails(user);
        if (jwtUtils.isTokenValid(refreshTokenRegister.getToken(), userToJWT)){
            var jwt = jwtUtils.generateToken(userToJWT);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshTokenRegister.getToken());
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Refreshed Token");
        }
        response.setStatusCode(500);
        return response;
    }
}