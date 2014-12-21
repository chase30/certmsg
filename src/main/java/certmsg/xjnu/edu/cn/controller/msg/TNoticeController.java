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

import certmsg.xjnu.edu.cn.entity.msg.TNoticeEntity;
import certmsg.xjnu.edu.cn.service.msg.TNoticeServiceI;

/**   
 * @Title: Controller
 * @Description: 关注语配置信息
 * @author zhangdaihao
 * @date 2014-12-20 14:42:34
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/tNoticeController")
public class TNoticeController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TNoticeController.class);

	@Autowired
	private TNoticeServiceI tNoticeService;
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
	 * 关注语配置信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tNotice")
	public ModelAndView tNotice(HttpServletRequest request) {
		return new ModelAndView("certmsg/xjnu/edu/cn/msg/tNoticeList");
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
	public void datagrid(TNoticeEntity tNotice,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TNoticeEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tNotice, request.getParameterMap());
		this.tNoticeService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除关注语配置信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TNoticeEntity tNotice, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tNotice = systemService.getEntity(TNoticeEntity.class, tNotice.getId());
		message = "关注语配置信息删除成功";
		tNoticeService.delete(tNotice);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加关注语配置信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TNoticeEntity tNotice, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tNotice.getId())) {
			message = "关注语配置信息更新成功";
			TNoticeEntity t = tNoticeService.get(TNoticeEntity.class, tNotice.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tNotice, t);
				tNoticeService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "关注语配置信息更新失败";
			}
		} else {
			message = "关注语配置信息添加成功";
			tNoticeService.save(tNotice);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 关注语配置信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TNoticeEntity tNotice, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tNotice.getId())) {
			tNotice = tNoticeService.getEntity(TNoticeEntity.class, tNotice.getId());
			req.setAttribute("tNoticePage", tNotice);
		}
		return new ModelAndView("certmsg/xjnu/edu/cn/msg/tNotice");
	}
}
