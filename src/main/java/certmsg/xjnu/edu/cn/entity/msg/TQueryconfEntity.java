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
 * @Description: 类型信息
 * @author zhangdaihao
 * @date 2014-12-20 14:41:55
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_queryconf", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class TQueryconfEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**用户查询类型代码*/
	private java.lang.Integer typecode;
	/**查询类型信息*/
	private java.lang.String typemsg;
	/**每日查询限制条数*/
	private java.lang.Integer countlimit;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  用户查询类型代码
	 */
	@Column(name ="TYPECODE",nullable=false,precision=10,scale=0)
	public java.lang.Integer getTypecode(){
		return this.typecode;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  用户查询类型代码
	 */
	public void setTypecode(java.lang.Integer typecode){
		this.typecode = typecode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  查询类型信息
	 */
	@Column(name ="TYPEMSG",nullable=false,length=50)
	public java.lang.String getTypemsg(){
		return this.typemsg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  查询类型信息
	 */
	public void setTypemsg(java.lang.String typemsg){
		this.typemsg = typemsg;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  每日查询限制条数
	 */
	@Column(name ="COUNTLIMIT",nullable=false,precision=10,scale=0)
	public java.lang.Integer getCountlimit(){
		return this.countlimit;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  每日查询限制条数
	 */
	public void setCountlimit(java.lang.Integer countlimit){
		this.countlimit = countlimit;
	}
}
