package io.github.linpeilie;

import com.lc.crush.chat.server.domain.SysConfig;
import com.lc.crush.chat.server.domain.SysConfigToSysConfigVoMapper;
import com.lc.crush.chat.server.domain.vo.SysConfigVo;
import com.lc.crush.chat.server.domain.vo.SysConfigVoToSysConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ConvertMapperAdapter {
  private SysConfigVoToSysConfigMapper sysConfigVoToSysConfigMapper;

  private SysConfigToSysConfigVoMapper sysConfigToSysConfigVoMapper;

  @Autowired
  public void setSysConfigVoToSysConfigMapper(@Lazy SysConfigVoToSysConfigMapper sysConfigVoToSysConfigMapper) {
    this.sysConfigVoToSysConfigMapper = sysConfigVoToSysConfigMapper;
  }

  @Autowired
  public void setSysConfigToSysConfigVoMapper(@Lazy SysConfigToSysConfigVoMapper sysConfigToSysConfigVoMapper) {
    this.sysConfigToSysConfigVoMapper = sysConfigToSysConfigVoMapper;
  }

  public SysConfig com_lc_crush_chat_server_domain_vo_SysConfigVoToSysConfig(SysConfigVo param) {
    return sysConfigVoToSysConfigMapper.convert(param);}

  public SysConfigVo com_lc_crush_chat_server_domain_SysConfigToSysConfigVo(SysConfig param) {
    return sysConfigToSysConfigVoMapper.convert(param);}
}
