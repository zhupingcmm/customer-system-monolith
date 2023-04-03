package com.mf.cs.security.auth.server.service.impl;

import com.mf.cs.security.auth.server.domain.*;
import com.mf.cs.security.auth.server.repository.ClientDetailRepository;
import com.mf.cs.security.auth.server.service.CustomerClientDetailsService;
import com.mf.projects.cs.infrastructure.exception.BizException;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class CustomerClientDetailsServiceImpl implements ClientDetailsService, CustomerClientDetailsService {

    @Autowired
    private ClientDetailRepository clientDetailRepository;


    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Supplier<BizException> s = () -> new BizException("Can not found [" + clientId + "] client id");
        val detail = clientDetailRepository.findClientDetailByClientId(clientId).orElseThrow(s);

        val baseClientDetails = new BaseClientDetails();

        val types  = detail.getAuthorizedGrantTypes().stream().map(AuthorizedGrantType::getName).collect(Collectors.toList());
        baseClientDetails.setAuthorizedGrantTypes(types);

        baseClientDetails.setClientId(detail.getClientId());

        val scopes  = detail.getScope().stream().map(Scope::getName).collect(Collectors.toList());
        baseClientDetails.setScope(scopes);

        baseClientDetails.setClientSecret(detail.getClientSecret());

        val uri = detail.getRedirectUri().stream().map(WebServerRedirectUri::getName).collect(Collectors.toSet());
        baseClientDetails.setRegisteredRedirectUri(uri);



        val ids  = detail.getResourceIds().stream().map(ResourceId::getName).collect(Collectors.toList());
        baseClientDetails.setResourceIds(ids);

        if (detail.getAccessTokenValidity() != null) {
            baseClientDetails.setAccessTokenValiditySeconds(detail.getAccessTokenValidity());
        }

        if (detail.getRefreshTokenValidity() != null) {
            baseClientDetails.setRefreshTokenValiditySeconds(detail.getRefreshTokenValidity());
        }



        return baseClientDetails;
    }


    @Override
    public ClientDetail addClient(ClientDetail clientDetail) {
        return clientDetailRepository.save(clientDetail);
    }
}
