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
 * @Description: 关注语配置信息
 * @author zhangdaihao
 * @date 2014-12-20 14:42:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_notice", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class TNoticeEntity implements java.io.Serializable {
	/**流水号*/
	private java.lang.String id;
	/**标题*/
	private java.lang.String title;
	/**通告内容*/
	private java.lang.String msg;
	/**通告类型代码*/
	private java.lang.String noticetype;
	/**creator*/
	private java.lang.String creator;
	/**创建时间*/
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
	 *@return: java.lang.String  标题
	 */
	@Column(name ="TITLE",nullable=false,length=50)
	public java.lang.String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标题
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  通告内容
	 */
	@Column(name ="MSG",nullable=false,length=1000)
	public java.lang.String getMsg(){
		return this.msg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  通告内容
	 */
	public void setMsg(java.lang.String msg){
		this.msg = msg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  通告类型代码
	 */
	@Column(name ="NOTICETYPE",nullable=false,length=2)
	public java.lang.String getNoticetype(){
		return this.noticetype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  通告类型代码
	 */
	public void setNoticetype(java.lang.String noticetype){
		this.noticetype = noticetype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  creator
	 */
	@Column(name ="CREATOR",nullable=false,length=50)
	public java.lang.String getCreator(){
		return this.creator;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  creator
	 */
	public void setCreator(java.lang.String creator){
		this.creator = creator;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATETIME",nullable=false)
	public java.util.Date getCreatetime(){
		return this.createtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
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
