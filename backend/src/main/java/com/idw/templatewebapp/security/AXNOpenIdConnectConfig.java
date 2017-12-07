package com.idw.templatewebapp.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/*
 @author avanderwoude
*/

@Configuration
@EnableOAuth2Client
public class AXNOpenIdConnectConfig {
    @Value("${axn.baseurl}")
    private String axnBaseUrl;

    @Value("${mockrp.baseurl}")
    private String mockrpBaseUrl;

    @Value("${axn.clientId}")
    private String clientId;

    @Value("${axn.clientSecret}")
    private String clientSecret;

    @Value("${axn.accessTokenUri}")
    private String accessTokenUri;

    @Value("${axn.userAuthorizationUri}")
    private String userAuthorizationUri;

    @Value("${axn.redirectUri}")
    private String redirectUri;

    @Bean
    public OAuth2ProtectedResourceDetails axnOpenId() {
        final AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri(axnBaseUrl+accessTokenUri);
        details.setUserAuthorizationUri(axnBaseUrl+userAuthorizationUri);
        details.setScope(Arrays.asList("idp.google","country.US","openid"));
        details.setPreEstablishedRedirectUri(mockrpBaseUrl+redirectUri);
        details.setUseCurrentUri(false);
        return details;
    }

    @Bean
    public OAuth2RestTemplate axnOpenIdTemplate(final OAuth2ClientContext clientContext) {
        final OAuth2RestTemplate template = new OAuth2RestTemplate(axnOpenId(), clientContext);
        return template;
    }

}