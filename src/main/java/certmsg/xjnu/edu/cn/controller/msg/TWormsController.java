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

import certmsg.xjnu.edu.cn.entity.msg.TWormsEntity;
import certmsg.xjnu.edu.cn.service.msg.TWormsServiceI;

/**   
 * @Title: Controller
 * @Description: 木马信息
 * @author zhangdaihao
 * @date 2014-12-20 14:39:39
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/tWormsController")
public class TWormsController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TWormsController.class);

	@Autowired
	private TWormsServiceI tWormsService;
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
	 * 木马信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tWorms")
	public ModelAndView tWorms(HttpServletRequest request) {
		return new ModelAndView("certmsg/xjnu/edu/cn/msg/tWormsList");
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
	public void datagrid(TWormsEntity tWorms,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TWormsEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tWorms, request.getParameterMap());
		this.tWormsService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除木马信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TWormsEntity tWorms, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tWorms = systemService.getEntity(TWormsEntity.class, tWorms.getId());
		message = "木马信息删除成功";
		tWormsService.delete(tWorms);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加木马信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TWormsEntity tWorms, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tWorms.getId())) {
			message = "木马信息更新成功";
			TWormsEntity t = tWormsService.get(TWormsEntity.class, tWorms.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tWorms, t);
				tWormsService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "木马信息更新失败";
			}
		} else {
			message = "木马信息添加成功";
			tWormsService.save(tWorms);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 木马信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TWormsEntity tWorms, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tWorms.getId())) {
			tWorms = tWormsService.getEntity(TWormsEntity.class, tWorms.getId());
			req.setAttribute("tWormsPage", tWorms);
		}
		return new ModelAndView("certmsg/xjnu/edu/cn/msg/tWorms");
	}
}
