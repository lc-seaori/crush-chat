package com.lc.crush.uc.domain;

import com.lc.crush.uc.domain.vo.UserVo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-15T22:03:00+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class UserToUserVoMapperImpl implements UserToUserVoMapper {

    @Override
    public UserVo convert(User arg0) {
        if ( arg0 == null ) {
            return null;
        }

        UserVo userVo = new UserVo();

        userVo.setId( arg0.getId() );
        userVo.setNickName( arg0.getNickName() );

        return userVo;
    }

    @Override
    public UserVo convert(User arg0, UserVo arg1) {
        if ( arg0 == null ) {
            return arg1;
        }

        arg1.setId( arg0.getId() );
        arg1.setNickName( arg0.getNickName() );

        return arg1;
    }
}
