package weixin.cms.cmsdata.impl;

import java.util.List;
import java.util.Map;
import org.jeecgframework.core.util.ApplicationContextUtil;
import weixin.cms.cmsdata.CmsDataCollectI;
import weixin.cms.common.CmsDataContent;
import weixin.idea.photo.entity.WeixinPhotoAlbumEntity;
import weixin.idea.photo.service.WeixinPhotoAlbumServiceI;

public class CmsPhotoAlbumDataCollect
  implements CmsDataCollectI
{
  @Override
public void collect(Map<String, String> params)
  {
    WeixinPhotoAlbumServiceI weixinPhotoAlbumService = (WeixinPhotoAlbumServiceI)ApplicationContextUtil.getContext().getBean("weixinPhotoAlbumService");
    String accountid = params.get("accountid") != null ? params.get("accountid").toString() : "";
    List photoAlbumList = weixinPhotoAlbumService.findByProperty(WeixinPhotoAlbumEntity.class, "accountid", accountid);

    CmsDataContent.put("photoAlbumList", photoAlbumList);
    String res = "template/cms/" + params.get("styleName");

    CmsDataContent.put("base", res);
  }
}