<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="tNoticeList" queryMode="group" title="关注语配置信息" actionUrl="tNoticeController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="标题" field="title" query="true"></t:dgCol>
   <t:dgCol title="通告内容" field="msg" ></t:dgCol>
   <t:dgCol title="通告类型代码" field="noticetype" ></t:dgCol>
   <t:dgCol title="creator" field="creator" ></t:dgCol>
   <t:dgCol title="创建时间" field="createtime" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="备注" field="memo" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tNoticeController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="tNoticeController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tNoticeController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tNoticeController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>