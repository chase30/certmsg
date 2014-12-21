package certmsg.xjnu.edu.cn.controller.msg;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import certmsg.xjnu.edu.cn.entity.msg.TUserqueryEntity;
import certmsg.xjnu.edu.cn.service.msg.TUserqueryServiceI;

/**   
 * @Title: Controller
 * @Description: 用户查询信息
 * @author zhangdaihao
 * @date 2014-12-20 14:40:43
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/tUserqueryController")
public class TUserqueryController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TUserqueryController.class);

	@Autowired
	private TUserqueryServiceI tUserqueryService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 用户查询信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tUserquery")
	public ModelAndView tUserquery(HttpServletRequest request) {
		return new ModelAndView("certmsg/xjnu/edu/cn/msg/tUserqueryList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TUserqueryEntity tUserquery,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TUserqueryEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tUserquery, request.getParameterMap());
		this.tUserqueryService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除用户查询信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TUserqueryEntity tUserquery, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tUserquery = systemService.getEntity(TUserqueryEntity.class, tUserquery.getId());
		message = "用户查询信息删除成功";
		tUserqueryService.delete(tUserquery);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加用户查询信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TUserqueryEntity tUserquery, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tUserquery.getId())) {
			message = "用户查询信息更新成功";
			TUserqueryEntity t = tUserqueryService.get(TUserqueryEntity.class, tUserquery.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tUserquery, t);
				tUserqueryService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "用户查询信息更新失败";
			}
		} else {
			message = "用户查询信息添加成功";
			tUserqueryService.save(tUserquery);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 用户查询信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TUserqueryEntity tUserquery, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tUserquery.getId())) {
			tUserquery = tUserqueryService.getEntity(TUserqueryEntity.class, tUserquery.getId());
			req.setAttribute("tUserqueryPage", tUserquery);
		}
		return new ModelAndView("certmsg/xjnu/edu/cn/msg/tUserquery");
	}
}
