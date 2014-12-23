package certmsg.xjnu.edu.cn.entity.msg;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 蠕虫信息
 * @author zhangdaihao
 * @date 2014-12-20 14:41:14
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_trojan", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class TTrojanEntity implements java.io.Serializable {
	/**流水号*/
	private java.lang.String id;
	/**ip地址*/
	@Excel(exportName="ip地址",orderNum="1",needMerge=true)
	private java.lang.String ip;
	/**事件类型*/
	@Excel(exportName="事件类型",orderNum="2",needMerge=true)
	private java.lang.String eventtype;
	/**事件详细类型*/
	@Excel(exportName="事件详细类型",orderNum="3",needMerge=true)
	private java.lang.String detailtype;
	/**发现时间*/
	@Excel(exportName="发现时间",orderNum="4",needMerge=true)
	private java.util.Date findtime;
	/**处置方式*/
	@Excel(exportName="处置方式",orderNum="5",needMerge=true)
	private java.lang.String advice;
	/**信息创建人*/
	@Excel(exportName="信息创建人",orderNum="6",needMerge=true)
	private java.lang.String creator;
	/**信息创建时间*/
	@Excel(exportName="信息创建时间",orderNum="7",needMerge=true)
	private java.util.Date createtime;
	/**备注*/
	@Excel(exportName="备注",orderNum="8",needMerge=true)
	private java.lang.String memo;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流水号
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流水号
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ip地址
	 */
	@Column(name ="IP",nullable=false,length=50)
	public java.lang.String getIp(){
		return this.ip;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ip地址
	 */
	public void setIp(java.lang.String ip){
		this.ip = ip;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  事件类型
	 */
	@Column(name ="EVENTTYPE",nullable=false,length=100)
	public java.lang.String getEventtype(){
		return this.eventtype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  事件类型
	 */
	public void setEventtype(java.lang.String eventtype){
		this.eventtype = eventtype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  事件详细类型
	 */
	@Column(name ="DETAILTYPE",nullable=false,length=200)
	public java.lang.String getDetailtype(){
		return this.detailtype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  事件详细类型
	 */
	public void setDetailtype(java.lang.String detailtype){
		this.detailtype = detailtype;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发现时间
	 */
	@Column(name ="FINDTIME",nullable=false)
	public java.util.Date getFindtime(){
		return this.findtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发现时间
	 */
	public void setFindtime(java.util.Date findtime){
		this.findtime = findtime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  处置方式
	 */
	@Column(name ="ADVICE",nullable=false,length=200)
	public java.lang.String getAdvice(){
		return this.advice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  处置方式
	 */
	public void setAdvice(java.lang.String advice){
		this.advice = advice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  信息创建人
	 */
	@Column(name ="CREATOR",nullable=false,length=50)
	public java.lang.String getCreator(){
		return this.creator;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  信息创建人
	 */
	public void setCreator(java.lang.String creator){
		this.creator = creator;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  信息创建时间
	 */
	@Column(name ="CREATETIME",nullable=false)
	public java.util.Date getCreatetime(){
		return this.createtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  信息创建时间
	 */
	public void setCreatetime(java.util.Date createtime){
		this.createtime = createtime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="MEMO",nullable=true,length=200)
	public java.lang.String getMemo(){
		return this.memo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setMemo(java.lang.String memo){
		this.memo = memo;
	}
}
