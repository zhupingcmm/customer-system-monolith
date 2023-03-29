package com.mf.cs.security.auth.server.converter;

import com.mf.cs.security.auth.server.controller.vo.UserVO;
import com.mf.cs.security.auth.server.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConverter {
     UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

     // vo - entity
    User convertToEntity(UserVO userVO);

    // entity -> vo
    UserVO convertToVo(User user);
}
