package certmsg.xjnu.edu.cn.service.impl.msg;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import certmsg.xjnu.edu.cn.service.msg.TTrojanServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("tTrojanService")
@Transactional
public class TTrojanServiceImpl extends CommonServiceImpl implements TTrojanServiceI {
	
}