package weixin.idea.extend.function.impl;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.util.ApplicationContextUtil;

import certmsg.xjnu.edu.cn.service.msg.TUserqueryServiceI;
import weixin.guanjia.core.entity.message.resp.TextMessageResp;
import weixin.guanjia.core.service.impl.BaiduTranslateService;
import weixin.guanjia.core.util.MessageUtil;
import weixin.idea.extend.function.KeyServiceI;

/**
 * 关键字：翻译 功能类：weixin.idea.key.function.impl.FanYiKeyService 描述：调用百度的翻译接口进行翻译
 * 
 * @author zhangdaihao
 * 
 */
public class queryvirusService implements KeyServiceI {

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return "查询病毒,cx";
	}

	@Override
	public String excute(String content, TextMessageResp defaultMessage,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		TUserqueryServiceI queryService =(TUserqueryServiceI)ApplicationContextUtil.getContext().getBean("tUserqueryService");
		String respMessage = null;
		String keyWord = content.trim();
		if ("".equals(keyWord) || "cx".equals(keyWord)) {
			defaultMessage.setContent(queryService.getUserqueryString());
			
		} else {
		respMessage=queryService.cxbd(keyWord, defaultMessage.getToUserName());
			defaultMessage.setContent(respMessage);
		}	
		respMessage = MessageUtil.textMessageToXml(defaultMessage);
		return respMessage ;
	}


}
