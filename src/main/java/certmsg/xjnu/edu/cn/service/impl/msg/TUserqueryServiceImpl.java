package certmsg.xjnu.edu.cn.service.impl.msg;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import certmsg.xjnu.edu.cn.service.msg.TUserqueryServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("tUserqueryService")
@Transactional
public class TUserqueryServiceImpl extends CommonServiceImpl implements TUserqueryServiceI {
	
}