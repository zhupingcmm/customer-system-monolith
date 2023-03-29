package com.mf.cs.security.auth.server.config;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class JWTTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String,Object> systemInfo = new HashMap<>();
        systemInfo.put("system", "customer system");
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(systemInfo);
        return oAuth2AccessToken;
    }
}
