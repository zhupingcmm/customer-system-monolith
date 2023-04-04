package com.mf.cs.security.auth.server.service.impl;

import com.mf.cs.security.auth.server.domain.*;
import com.mf.cs.security.auth.server.repository.ClientDetailRepository;
import com.mf.cs.security.auth.server.service.CustomerClientDetailsService;
import com.mf.projects.cs.infrastructure.exception.BizException;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;


@Service
public class CustomerClientDetailsServiceImpl implements ClientDetailsService, CustomerClientDetailsService {

    @Autowired
    private ClientDetailRepository clientDetailRepository;


    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Supplier<BizException> s = () -> new BizException("Can not found [" + clientId + "] client id");
        val detail = clientDetailRepository.findClientDetailByClientId(clientId).orElseThrow(s);

        val baseClientDetails = new BaseClientDetails(
                detail.getClientId(),
                detail.getResourceIds(),
                detail.getScope(),
                detail.getAuthorizedGrantTypes(),
                detail.getAuthorities(),
                detail.getWebServerRedirectUris());
        baseClientDetails.setClientSecret(detail.getClientSecret());
        Set<String> autoApproveScope = new HashSet<>();
        autoApproveScope.add(detail.getScope());
        baseClientDetails.setAutoApproveScopes(autoApproveScope);
        baseClientDetails.setRefreshTokenValiditySeconds(detail.getRefreshTokenValidity());
        baseClientDetails.setAccessTokenValiditySeconds(detail.getAccessTokenValidity());

        return baseClientDetails;
    }


    @Override
    public ClientDetail addClient(ClientDetail clientDetail) {
        return clientDetailRepository.save(clientDetail);
    }
}
