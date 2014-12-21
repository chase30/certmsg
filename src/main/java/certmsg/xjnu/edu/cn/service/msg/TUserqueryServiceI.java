package certmsg.xjnu.edu.cn.service.msg;

import org.jeecgframework.core.common.service.CommonService;

public interface TUserqueryServiceI extends CommonService{
	public String getUserqueryString();
	public String cxbd(String querycode,String openid);
	public boolean checkuser(String userid,int type);
}
