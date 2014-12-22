package certmsg.xjnu.edu.cn.service.impl.msg;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import certmsg.xjnu.edu.cn.entity.msg.TMobileEntity;
import certmsg.xjnu.edu.cn.entity.msg.TQueryconfEntity;
import certmsg.xjnu.edu.cn.entity.msg.TTrojanEntity;
import certmsg.xjnu.edu.cn.entity.msg.TUserqueryEntity;
import certmsg.xjnu.edu.cn.entity.msg.TWormsEntity;
import certmsg.xjnu.edu.cn.service.msg.TUserqueryServiceI;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("tUserqueryService")
@Transactional
public class TUserqueryServiceImpl extends CommonServiceImpl implements
		TUserqueryServiceI {
	public String getUserqueryString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(
				"请回复查询所需关键字")
				.append("\n");
		buffer.append("如： 查询ip 127.0.0.1的病毒信息则").append("\n").append("查询木马信息输入:"+""+"cxmm127.0.0.1")
		.append("\n").append("查询蠕虫信息输入:"+""+"cxrc127.0.0.1").append("\n").append("查询电话病毒信息:"+""+"cxtel15887654321");
		return buffer.toString();
	}
	//查询病毒所执行的方法
	/**
	 * @param querycode
	 * @param openid
	 * @return
	 */
	public String cxbd(String querycode,String openid){
		boolean iserror=true;
		StringBuffer buffer = new StringBuffer();
		if(!querycode.startsWith("cx")){
			buffer.append("查询指令输入有误");
			
		}
		String queystring=querycode.substring(4);
		if(querycode.startsWith("cxmm")){
			iserror=false;
			if(this.checkuser(openid,1)){
				String hql="from TWormsEntity where ip=?";
				List<TWormsEntity> twormlist=this.findHql(hql, new Object[]{queystring});
				if(twormlist.size()>0){
					buffer.append("此ip已感染木马病毒!");
				}else{
					buffer.append("此ip暂无木马病毒感染!");
				}
				 TUserqueryEntity tuser=new TUserqueryEntity();
				 tuser.setUsercode(openid);
				 tuser.setQuerydate(new Date());
				 tuser.setTypecode(1);
				 this.save(tuser);
			}else{
				buffer.append("不好意思！您今天查询已上限！");
			}
	
			 
		}
		if(querycode.startsWith("cxrc")){
			iserror=false;
			if(this.checkuser(openid,0)){
			String hql="from TTrojanEntity where ip=?";
			List<TTrojanEntity> ttolist=this.findHql(hql, new Object[]{queystring});
			if(ttolist.size()>0){
				buffer.append("此ip已感染蠕虫病毒!");
			}else{
				buffer.append("此ip暂无蠕虫病毒感染!");
			}
			 TUserqueryEntity tuser=new TUserqueryEntity();
			 tuser.setUsercode(openid);
			 tuser.setQuerydate(new Date());
			 tuser.setTypecode(0);
			 this.save(tuser);
			 
			}else{
				buffer.append("不好意思！您今天查询已上限！");
			}
			 
		}
		if(querycode.startsWith("cxtel")){
			iserror=false;
			if(this.checkuser(openid,2)){
				String hql="from TMobileEntity where phonenumber=?";
				List<TMobileEntity> tMobilelist=this.findHql(hql, new Object[]{queystring});
				if(tMobilelist.size()>0){
					buffer.append("此号码已感染病毒!");
				}else{
					buffer.append("此号码无病毒感染!");
				}
				TUserqueryEntity tuser=new TUserqueryEntity();
				tuser.setUsercode(openid);
				tuser.setQuerydate(new Date());
				tuser.setTypecode(2);
				this.save(tuser);
				
			}else{
				buffer.append("不好意思！您今天查询已上限！");
			}
			
		}
		if(iserror==true){
			buffer.append("查询指令输入有误");
		}
		return buffer.toString();
	}
	
	public boolean checkuser(String userid,int type){
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	    Date d=new Date();
	    String str=format.format(d);
	    Date d2;
		try {
			d2 = format.parse(str);
		    /////////////////得到想要测试的时间整天 
		    int dayMis=1000*60*60*24;//一天的毫秒-1
		    //返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
		    long curMillisecond=d2.getTime();//当天的毫秒
		    TUserqueryEntity tqu=this.getEntity(TUserqueryEntity.class,"5a4355374a704938014a70512bcd0005");
			TQueryconfEntity tcon=this.findUniqueByProperty(TQueryconfEntity.class, "typecode", type);
			List<TUserqueryEntity> tquerylist=this.findHql("from TUserqueryEntity where usercode=? and querydate=? and typecode=?", new Object[]{userid,new Date(curMillisecond),type});
			if(tquerylist.size()>tcon.getCountlimit()){
				return false;
			}
//		    long resultMis=curMillisecond+(dayMis-1); //当天最后一秒
//		    DateFormat format2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return true;
	}
}