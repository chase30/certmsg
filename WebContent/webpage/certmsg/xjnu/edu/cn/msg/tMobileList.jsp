<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript" charset="utf-8">
	/*
	 *	excel导出
	 */
	
	function courseListImportXls() {
		openuploadwin('Excel导入', 'tMobileController.do?upload', "tMobileList");
	}
	
</script>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="tMobileList" queryMode="group" title="手机病毒信息" actionUrl="tMobileController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="电话号码" field="phonenumber" query="true"></t:dgCol>
   <t:dgCol title="病毒名称" field="virusname" query="true"></t:dgCol>
   <t:dgCol title="病毒类型" field="virustype" query="true"></t:dgCol>
   <t:dgCol title="病毒危害" field="virusdesc" ></t:dgCol>
   <t:dgCol title="发现时间" field="findtime" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="处置方式" field="advice" query="true"></t:dgCol>
   <t:dgCol title="信息创建人" field="creator" query="true"></t:dgCol>
   <t:dgCol title="信息创建时间" field="createtime" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="备注" field="memo" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tMobileController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="tMobileController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tMobileController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tMobileController.do?addorupdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入Excel" icon="icon-search" onclick="courseListImportXls()"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>