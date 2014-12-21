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

import certmsg.xjnu.edu.cn.entity.msg.TQueryconfEntity;
import certmsg.xjnu.edu.cn.service.msg.TQueryconfServiceI;

/**   
 * @Title: Controller
 * @Description: 类型信息
 * @author zhangdaihao
 * @date 2014-12-20 14:41:54
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/tQueryconfController")
public class TQueryconfController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TQueryconfController.class);

	@Autowired
	private TQueryconfServiceI tQueryconfService;
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
	 * 类型信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tQueryconf")
	public ModelAndView tQueryconf(HttpServletRequest request) {
		return new ModelAndView("certmsg/xjnu/edu/cn/msg/tQueryconfList");
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
	public void datagrid(TQueryconfEntity tQueryconf,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TQueryconfEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tQueryconf, request.getParameterMap());
		this.tQueryconfService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除类型信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TQueryconfEntity tQueryconf, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tQueryconf = systemService.getEntity(TQueryconfEntity.class, tQueryconf.getId());
		message = "类型信息删除成功";
		tQueryconfService.delete(tQueryconf);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加类型信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TQueryconfEntity tQueryconf, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tQueryconf.getId())) {
			message = "类型信息更新成功";
			TQueryconfEntity t = tQueryconfService.get(TQueryconfEntity.class, tQueryconf.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tQueryconf, t);
				tQueryconfService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "类型信息更新失败";
			}
		} else {
			message = "类型信息添加成功";
			tQueryconfService.save(tQueryconf);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 类型信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TQueryconfEntity tQueryconf, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tQueryconf.getId())) {
			tQueryconf = tQueryconfService.getEntity(TQueryconfEntity.class, tQueryconf.getId());
			req.setAttribute("tQueryconfPage", tQueryconf);
		}
		return new ModelAndView("certmsg/xjnu/edu/cn/msg/tQueryconf");
	}
}
