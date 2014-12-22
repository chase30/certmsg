package certmsg.xjnu.edu.cn.service.impl.msg;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		buffer.append("如： 查询ip 127.0.0.1的病毒信息则").append("\n").append("查询木马信息输入:"+""+"cxmm127.0.0.1").append("\n").append("查询木马信息输入:"+""+"cxrc127.0.0.1");
		return buffer.toString();
	}
	//查询病毒所执行的方法
	/**
	 * @param querycode
	 * @param openid
	 * @return
	 */
	public String cxbd(String querycode,String openid){
		StringBuffer buffer = new StringBuffer();
		if(!querycode.startsWith("cx")){
			buffer.append("查询指令输入有误");
			
		}
		String queystring=querycode.substring(4);
		if(querycode.startsWith("cxmm")){
			if(this.checkuser(openid,1)){
				String hql="from TWormsEntity where ip=?";
				List<TWormsEntity> twormlist=this.findHql(hql, new Object[]{queystring});
				if(twormlist.size()>0){
					buffer.append("此ip已经木马病毒!");
				}else{
					buffer.append("此ip没有木马病毒!！");
				}
				 TUserqueryEntity tuser=new TUserqueryEntity();
				 tuser.setUsercode(openid);
				 tuser.setQuerydate(new Date());
				 tuser.setTypecode(1);
				 this.save(tuser);
			}else{
				buffer.append("查询超限!！");
			}
	
			 
		}
		if(querycode.startsWith("cxrc")){
			if(this.checkuser(openid,0)){
			String hql="from TTrojanEntity where ip=?";
			List<TTrojanEntity> ttolist=this.findHql(hql, new Object[]{queystring});
			if(ttolist.size()>0){
				buffer.append("此ip已经蠕虫病毒!");
			}else{
				buffer.append("此ip没有蠕虫病毒!！");
			}
			 TUserqueryEntity tuser=new TUserqueryEntity();
			 tuser.setUsercode(openid);
			 tuser.setQuerydate(new Date());
			 tuser.setTypecode(0);
			 this.save(tuser);
			 
			}else{
				buffer.append("查询超限!！");
			}
			 
		}
		return buffer.toString();
	}
	
	public boolean checkuser(String userid,int type){
	
		
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	    Date d=new Date();
	    String str=format.format(d);
	    System.out.println(str);
	    Date d2;
		try {
			d2 = format.parse(str);
			System.out.println(d2);
		    /////////////////得到想要测试的时间整天 
		    int dayMis=1000*60*60*24;//一天的毫秒-1
		    System.out.println("一天的毫秒-1:"+dayMis);
		    //返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
		    long curMillisecond=d2.getTime();//当天的毫秒
		    TUserqueryEntity tqu=this.getEntity(TUserqueryEntity.class,"5a4355374a704938014a70512bcd0005");
		    System.out.println(tqu.getQuerydate()+"-----------------------");
		   System.out.println(new Date(curMillisecond)+"---------------------");
			TQueryconfEntity tcon=this.findUniqueByProperty(TQueryconfEntity.class, "typecode", type);
			List<TUserqueryEntity> tquerylist=this.findHql("from TUserqueryEntity where usercode=? and querydate=? and typecode=?", new Object[]{userid,new Date(curMillisecond),type});
			System.out.println(tquerylist.size() );
			if(tquerylist.size()>tcon.getCountlimit()){
				return false;
			}
		    long resultMis=curMillisecond+(dayMis-1); //当天最后一秒
		    DateFormat format2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return true;
	}
	
	
}