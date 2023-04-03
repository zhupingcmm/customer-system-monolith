package com.mf.cs.security.auth.server.repository;

import com.mf.cs.security.auth.server.domain.ClientDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientDetailRepository extends JpaRepository<ClientDetail, Long> {
    Optional<ClientDetail> findClientDetailByClientId(String clientId);
}
