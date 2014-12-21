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
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 手机病毒信息
 * @author zhangdaihao
 * @date 2014-12-20 14:43:11
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_mobile", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class TMobileEntity implements java.io.Serializable {
	/**流水号*/
	private java.lang.String id;
	/**电话号码*/
	private java.lang.String phonenumber;
	/**病毒名称*/
	private java.lang.String virusname;
	/**病毒类型*/
	private java.lang.String virustype;
	/**病毒危害*/
	private java.lang.String virusdesc;
	/**发现时间*/
	private java.util.Date findtime;
	/**处置方式*/
	private java.lang.String advice;
	/**信息创建人*/
	private java.lang.String creator;
	/**信息创建时间*/
	private java.util.Date createtime;
	/**备注*/
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
	 *@return: java.lang.String  电话号码
	 */
	@Column(name ="PHONENUMBER",nullable=false,length=50)
	public java.lang.String getPhonenumber(){
		return this.phonenumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电话号码
	 */
	public void setPhonenumber(java.lang.String phonenumber){
		this.phonenumber = phonenumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  病毒名称
	 */
	@Column(name ="VIRUSNAME",nullable=false,length=100)
	public java.lang.String getVirusname(){
		return this.virusname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  病毒名称
	 */
	public void setVirusname(java.lang.String virusname){
		this.virusname = virusname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  病毒类型
	 */
	@Column(name ="VIRUSTYPE",nullable=false,length=200)
	public java.lang.String getVirustype(){
		return this.virustype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  病毒类型
	 */
	public void setVirustype(java.lang.String virustype){
		this.virustype = virustype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  病毒危害
	 */
	@Column(name ="VIRUSDESC",nullable=false,length=500)
	public java.lang.String getVirusdesc(){
		return this.virusdesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  病毒危害
	 */
	public void setVirusdesc(java.lang.String virusdesc){
		this.virusdesc = virusdesc;
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
	@Column(name ="ADVICE",nullable=true,length=200)
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
