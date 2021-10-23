package org.ci6206.service;

import org.ci6206.dbAPI.TokenDBAO;
import org.ci6206.model.Token;
import org.ci6206.util.TokenUtil;


public class TokenService {
    public static String generateTokenForUsername(String username) throws Exception {
        String token = TokenUtil.generateToken();
        Token userToken = new Token(username, token);
        TokenDBAO tokenDBAO = new TokenDBAO();
        tokenDBAO.addToken(userToken);
        return token;
    }

    public static Token checkTokenWithToken(String token) throws Exception {
        TokenDBAO tokenDBAO = new TokenDBAO();
        return tokenDBAO.findTokenWithToken(token);
    }

    public static Token checkTokenWithUsername(String username) throws Exception {
        TokenDBAO tokenDBAO = new TokenDBAO();
        return tokenDBAO.findTokenWithUsername(username);
    }

    public static boolean checkTokenValid(String token) throws Exception {
        return token.equals(checkTokenWithToken(token).getToken());
    }
}
