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
 * @Description: 用户查询信息
 * @author zhangdaihao
 * @date 2014-12-20 14:40:43
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_userquery", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class TUserqueryEntity implements java.io.Serializable {
	/**流水号*/
	private java.lang.String id;
	/**用户微信号*/
	private java.lang.String usercode;
	/**查询类型代码*/
	private java.lang.Integer typecode;
	/**查询日期*/
	private java.util.Date querydate;
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
	 *@return: java.lang.String  用户微信号
	 */
	@Column(name ="USERCODE",nullable=false,length=50)
	public java.lang.String getUsercode(){
		return this.usercode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户微信号
	 */
	public void setUsercode(java.lang.String usercode){
		this.usercode = usercode;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  查询类型代码
	 */
	@Column(name ="TYPECODE",nullable=false,precision=10,scale=0)
	public java.lang.Integer getTypecode(){
		return this.typecode;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  查询类型代码
	 */
	public void setTypecode(java.lang.Integer typecode){
		this.typecode = typecode;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  查询日期
	 */
	@Column(name ="QUERYDATE",nullable=false)
	public java.util.Date getQuerydate(){
		return this.querydate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  查询日期
	 */
	public void setQuerydate(java.util.Date querydate){
		this.querydate = querydate;
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
