<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript" charset="utf-8">
	/*
	 *	excel导出
	 */
	
	function courseListImportXls() {
		openuploadwin('Excel导入', 'tTrojanController.do?upload', "tTrojanList");
	}
	
</script>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="tTrojanList" queryMode="group" title="蠕虫信息" actionUrl="tTrojanController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="ip地址" field="ip" query="true"></t:dgCol>
   <t:dgCol title="事件类型" field="eventtype" query="true"></t:dgCol>
   <t:dgCol title="事件详细类型" field="detailtype" ></t:dgCol>
   <t:dgCol title="发现时间" field="findtime" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="处置方式" field="advice" ></t:dgCol>
   <t:dgCol title="信息创建人" field="creator" query="true"></t:dgCol>
   <t:dgCol title="信息创建时间" field="createtime" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="备注" field="memo" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tTrojanController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="tTrojanController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tTrojanController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tTrojanController.do?addorupdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入Excel" icon="icon-search" onclick="courseListImportXls()"></t:dgToolBar>
 </t:datagrid>
  </div>
 </div>