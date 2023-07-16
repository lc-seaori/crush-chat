package com.lc.crush.uc.domain.vo;

import com.lc.crush.uc.domain.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-15T22:03:00+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class UserVoToUserMapperImpl implements UserVoToUserMapper {

    @Override
    public User convert(UserVo arg0) {
        if ( arg0 == null ) {
            return null;
        }

        User user = new User();

        user.setId( arg0.getId() );
        user.setNickName( arg0.getNickName() );

        return user;
    }

    @Override
    public User convert(UserVo arg0, User arg1) {
        if ( arg0 == null ) {
            return arg1;
        }

        arg1.setId( arg0.getId() );
        arg1.setNickName( arg0.getNickName() );

        return arg1;
    }
}
