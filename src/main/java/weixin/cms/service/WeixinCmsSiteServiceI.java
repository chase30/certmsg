package weixin.cms.service;

import java.io.Serializable;
import org.jeecgframework.core.common.service.CommonService;
import weixin.cms.entity.WeixinCmsSiteEntity;

public abstract interface WeixinCmsSiteServiceI extends CommonService
{
  @Override
public abstract <T> void delete(T paramT);

  @Override
public abstract <T> Serializable save(T paramT);

  @Override
public abstract <T> void saveOrUpdate(T paramT);

  public abstract boolean doAddSql(WeixinCmsSiteEntity paramWeixinCmsSiteEntity);

  public abstract boolean doUpdateSql(WeixinCmsSiteEntity paramWeixinCmsSiteEntity);

  public abstract boolean doDelSql(WeixinCmsSiteEntity paramWeixinCmsSiteEntity);
}