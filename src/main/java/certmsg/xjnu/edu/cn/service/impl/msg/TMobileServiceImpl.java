package certmsg.xjnu.edu.cn.service.impl.msg;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import certmsg.xjnu.edu.cn.service.msg.TMobileServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("tMobileService")
@Transactional
public class TMobileServiceImpl extends CommonServiceImpl implements TMobileServiceI {
	
}