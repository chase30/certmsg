<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>类型信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tQueryconfController.do?save">
			<input id="id" name="id" type="hidden" value="${tQueryconfPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							用户查询类型代码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="typecode" name="typecode" 
							   value="${tQueryconfPage.typecode}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							查询类型信息:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="typemsg" name="typemsg" 
							   value="${tQueryconfPage.typemsg}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							每日查询限制条数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="countlimit" name="countlimit" 
							   value="${tQueryconfPage.countlimit}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>