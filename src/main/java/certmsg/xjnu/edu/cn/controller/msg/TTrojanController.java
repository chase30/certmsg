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

import certmsg.xjnu.edu.cn.entity.msg.TTrojanEntity;
import certmsg.xjnu.edu.cn.service.msg.TTrojanServiceI;

/**   
 * @Title: Controller
 * @Description: 蠕虫信息
 * @author zhangdaihao
 * @date 2014-12-20 14:41:13
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/tTrojanController")
public class TTrojanController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TTrojanController.class);

	@Autowired
	private TTrojanServiceI tTrojanService;
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
	 * 蠕虫信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tTrojan")
	public ModelAndView tTrojan(HttpServletRequest request) {
		return new ModelAndView("certmsg/xjnu/edu/cn/msg/tTrojanList");
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
	public void datagrid(TTrojanEntity tTrojan,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TTrojanEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tTrojan, request.getParameterMap());
		this.tTrojanService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除蠕虫信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TTrojanEntity tTrojan, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tTrojan = systemService.getEntity(TTrojanEntity.class, tTrojan.getId());
		message = "蠕虫信息删除成功";
		tTrojanService.delete(tTrojan);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加蠕虫信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TTrojanEntity tTrojan, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tTrojan.getId())) {
			message = "蠕虫信息更新成功";
			TTrojanEntity t = tTrojanService.get(TTrojanEntity.class, tTrojan.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tTrojan, t);
				tTrojanService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "蠕虫信息更新失败";
			}
		} else {
			message = "蠕虫信息添加成功";
			tTrojanService.save(tTrojan);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 蠕虫信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TTrojanEntity tTrojan, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tTrojan.getId())) {
			tTrojan = tTrojanService.getEntity(TTrojanEntity.class, tTrojan.getId());
			req.setAttribute("tTrojanPage", tTrojan);
		}
		return new ModelAndView("certmsg/xjnu/edu/cn/msg/tTrojan");
	}
}
