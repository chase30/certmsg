package certmsg.xjnu.edu.cn.controller.msg;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import certmsg.xjnu.edu.cn.entity.msg.TTrojanEntity;
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
	
	/**
	 * 木马病毒excel导入
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		return new ModelAndView("certmsg/xjnu/edu/cn/msg/tWormsUpload");
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(0);
			params.setSecondTitleRows(1);
			params.setNeedSave(true);
			try {
				List<TWormsEntity> tWormsList= 
					(List<TWormsEntity>)ExcelImportUtil.importExcelByIs(file.getInputStream(),TWormsEntity.class,params);
				for (TWormsEntity tWorms : tWormsList) {
					if(tWorms.getIp()!=null){
						tWormsService.save(tWorms);
					}
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
}
