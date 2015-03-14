package weixin.cms.service.impl;

import java.util.List;
import java.util.Map;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weixin.cms.dao.CmsArticleDao;
import weixin.cms.entity.CmsArticleEntity;
import weixin.cms.service.CmsArticleServiceI;

@Service("cmsArticleService")
@Transactional
public class CmsArticleServiceImpl extends CommonServiceImpl
  implements CmsArticleServiceI
{

  @Autowired
  private CmsArticleDao cmsArticleDao;

  @Override
public List<CmsArticleEntity> listByMap(Map params, int page, int rows)
  {
    return this.cmsArticleDao.listByMap(params, page, rows);
  }

  @Override
public List<CmsArticleEntity> listByMap(Map params)
  {
    return this.cmsArticleDao.listByMap(params);
  }

  @Override
public List<CmsArticleEntity> list(CmsArticleEntity cmsArticleEntity)
  {
    return this.cmsArticleDao.list(cmsArticleEntity);
  }

  @Override
public List<CmsArticleEntity> list(CmsArticleEntity cmsArticleEntity, int page, int rows)
  {
    return this.cmsArticleDao.list(cmsArticleEntity);
  }

  @Override
public int getCount(Map params)
  {
    return this.cmsArticleDao.getCount(params).intValue();
  }

  @Override
public CmsArticleEntity getCmsArticleEntity(String id)
  {
    return (CmsArticleEntity)getEntity(CmsArticleEntity.class, id);
  }

  @Override
public Integer addViewCount(String articleId)
  {
    CmsArticleEntity article = (CmsArticleEntity)getEntity(CmsArticleEntity.class, articleId);
    article.setViewCount(Integer.valueOf(article.getViewCount() == null ? 0 : article.getViewCount().intValue() + 1));
    return article.getViewCount();
  }
}