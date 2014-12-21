package certmsg.xjnu.edu.cn.service.impl.msg;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import certmsg.xjnu.edu.cn.service.msg.TWormsServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("tWormsService")
@Transactional
public class TWormsServiceImpl extends CommonServiceImpl implements TWormsServiceI {
	
}