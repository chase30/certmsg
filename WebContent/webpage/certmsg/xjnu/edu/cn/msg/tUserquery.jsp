<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>用户查询信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tUserqueryController.do?save">
			<input id="id" name="id" type="hidden" value="${tUserqueryPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							用户微信号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="usercode" name="usercode" 
							   value="${tUserqueryPage.usercode}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							查询类型代码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="typecode" name="typecode" 
							   value="${tUserqueryPage.typecode}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							查询日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="querydate" name="querydate" 
							   value="<fmt:formatDate value='${tUserqueryPage.querydate}' type="date" pattern="yyyy-MM-dd"/>" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="memo" name="memo" ignore="ignore"
							   value="${tUserqueryPage.memo}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>