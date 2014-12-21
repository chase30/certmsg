<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="tQueryconfList" queryMode="group" title="类型信息" actionUrl="tQueryconfController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="用户查询类型代码" field="typecode" query="true"></t:dgCol>
   <t:dgCol title="查询类型信息" field="typemsg" query="true"></t:dgCol>
   <t:dgCol title="每日查询限制条数" field="countlimit" query="true"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tQueryconfController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="tQueryconfController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tQueryconfController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tQueryconfController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>