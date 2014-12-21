<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>蠕虫信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tTrojanController.do?save">
			<input id="id" name="id" type="hidden" value="${tTrojanPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							ip地址:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ip" name="ip" 
							   value="${tTrojanPage.ip}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							事件类型:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="eventtype" name="eventtype" 
							   value="${tTrojanPage.eventtype}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							事件详细类型:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="detailtype" name="detailtype" 
							   value="${tTrojanPage.detailtype}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发现时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="findtime" name="findtime" 
							   value="<fmt:formatDate value='${tTrojanPage.findtime}' type="date" pattern="yyyy-MM-dd"/>" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							处置方式:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="advice" name="advice" 
							   value="${tTrojanPage.advice}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							信息创建人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="creator" name="creator" 
							   value="${tTrojanPage.creator}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							信息创建时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="createtime" name="createtime" 
							   value="<fmt:formatDate value='${tTrojanPage.createtime}' type="date" pattern="yyyy-MM-dd"/>" datatype="*">
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
							   value="${tTrojanPage.memo}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>