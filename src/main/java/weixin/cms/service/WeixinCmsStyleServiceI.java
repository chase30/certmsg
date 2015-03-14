package weixin.cms.service;

import java.io.Serializable;
import org.jeecgframework.core.common.service.CommonService;
import weixin.cms.entity.WeixinCmsStyleEntity;

public abstract interface WeixinCmsStyleServiceI extends CommonService
{
  @Override
public abstract <T> void delete(T paramT);

  @Override
public abstract <T> Serializable save(T paramT);

  @Override
public abstract <T> void saveOrUpdate(T paramT);

  public abstract boolean doAddSql(WeixinCmsStyleEntity paramWeixinCmsStyleEntity);

  public abstract boolean doUpdateSql(WeixinCmsStyleEntity paramWeixinCmsStyleEntity);

  public abstract boolean doDelSql(WeixinCmsStyleEntity paramWeixinCmsStyleEntity);

  public abstract String getStylePath();
}