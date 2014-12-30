<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="tUserqueryList" queryMode="group" title="用户查询信息" actionUrl="tUserqueryController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="用户微信号" field="usercode" query="true"></t:dgCol>
   <t:dgCol title="查询类型代码" field="typecode" query="true"></t:dgCol>
   <t:dgCol title="查询日期" field="querydate" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="备注" field="memo" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tUserqueryController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="tUserqueryController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tUserqueryController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tUserqueryController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>