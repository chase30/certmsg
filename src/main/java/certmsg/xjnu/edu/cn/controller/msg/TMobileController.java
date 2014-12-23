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
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;
import certmsg.xjnu.edu.cn.entity.msg.TMobileEntity;
import certmsg.xjnu.edu.cn.service.msg.TMobileServiceI;

/**   
 * @Title: Controller
 * @Description: 手机病毒信息
 * @author zhangdaihao
 * @date 2014-12-20 14:43:11
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/tMobileController")
public class TMobileController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TMobileController.class);

	@Autowired
	private TMobileServiceI tMobileService;
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
	 * 手机病毒信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tMobile")
	public ModelAndView tMobile(HttpServletRequest request) {
		return new ModelAndView("certmsg/xjnu/edu/cn/msg/tMobileList");
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
	public void datagrid(TMobileEntity tMobile,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TMobileEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tMobile, request.getParameterMap());
		this.tMobileService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除手机病毒信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TMobileEntity tMobile, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tMobile = systemService.getEntity(TMobileEntity.class, tMobile.getId());
		message = "手机病毒信息删除成功";
		tMobileService.delete(tMobile);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加手机病毒信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TMobileEntity tMobile, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tMobile.getId())) {
			message = "手机病毒信息更新成功";
			TMobileEntity t = tMobileService.get(TMobileEntity.class, tMobile.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tMobile, t);
				tMobileService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "手机病毒信息更新失败";
			}
		} else {
			message = "手机病毒信息添加成功";
			tMobileService.save(tMobile);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 手机病毒信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TMobileEntity tMobile, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tMobile.getId())) {
			tMobile = tMobileService.getEntity(TMobileEntity.class, tMobile.getId());
			req.setAttribute("tMobilePage", tMobile);
		}
		return new ModelAndView("certmsg/xjnu/edu/cn/msg/tMobile");
	}
	
	/**
	 * 手机病毒excel导入
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		return new ModelAndView("certmsg/xjnu/edu/cn/msg/tMobileUpload");
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
				List<TMobileEntity> tMobileList= 
					(List<TMobileEntity>)ExcelImportUtil.importExcelByIs(file.getInputStream(),TMobileEntity.class,params);
				for (TMobileEntity tMobile : tMobileList) {
					if(tMobile.getPhonenumber()!=null){
						TMobileEntity hgper=systemService.findUniqueByProperty(TMobileEntity.class, "phonenumber", tMobile.getPhonenumber());
						if(hgper!=null){
							tMobileService.delete(hgper);
						}
						tMobileService.save(tMobile);
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
