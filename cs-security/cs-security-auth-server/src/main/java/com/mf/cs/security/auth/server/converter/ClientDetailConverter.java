package com.mf.cs.security.auth.server.converter;

import com.mf.cs.security.auth.server.controller.vo.ClientDetailVO;
import com.mf.cs.security.auth.server.domain.ClientDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientDetailConverter {
    ClientDetailConverter INSTANCE = Mappers.getMapper(ClientDetailConverter.class);


    // entity -> vo
    ClientDetailVO transToVo(ClientDetail entity);

    // vo -> entity
    ClientDetail transToEntity(ClientDetailVO vo);
}
