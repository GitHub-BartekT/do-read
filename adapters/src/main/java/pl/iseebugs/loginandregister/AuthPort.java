package pl.iseebugs.loginandregister;

import pl.iseebugs.loginandregister.projection.AuthReqRespDTO;

interface AuthPort {
    AuthReqRespDTO signUp (AuthReqRespDTO authReqRespDTO);
    AuthReqRespDTO signIn (AuthReqRespDTO signingRequest);
    AuthReqRespDTO refreshToken(AuthReqRespDTO refreshTokenRegister);
}
