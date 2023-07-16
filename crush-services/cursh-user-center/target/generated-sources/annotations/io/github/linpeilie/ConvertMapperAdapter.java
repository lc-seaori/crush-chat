package io.github.linpeilie;

import com.lc.crush.uc.domain.User;
import com.lc.crush.uc.domain.UserToUserVoMapper;
import com.lc.crush.uc.domain.vo.UserVo;
import com.lc.crush.uc.domain.vo.UserVoToUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ConvertMapperAdapter {
  private UserToUserVoMapper userToUserVoMapper;

  private UserVoToUserMapper userVoToUserMapper;

  @Autowired
  public void setUserToUserVoMapper(@Lazy UserToUserVoMapper userToUserVoMapper) {
    this.userToUserVoMapper = userToUserVoMapper;
  }

  @Autowired
  public void setUserVoToUserMapper(@Lazy UserVoToUserMapper userVoToUserMapper) {
    this.userVoToUserMapper = userVoToUserMapper;
  }

  public UserVo com_lc_crush_uc_domain_UserToUserVo(User param) {
    return userToUserVoMapper.convert(param);}

  public User com_lc_crush_uc_domain_vo_UserVoToUser(UserVo param) {
    return userVoToUserMapper.convert(param);}
}
