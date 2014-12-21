package certmsg.xjnu.edu.cn.service.impl.msg;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import certmsg.xjnu.edu.cn.service.msg.TNoticeServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("tNoticeService")
@Transactional
public class TNoticeServiceImpl extends CommonServiceImpl implements TNoticeServiceI {
	
}