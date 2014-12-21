<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>手机病毒信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tMobileController.do?save">
			<input id="id" name="id" type="hidden" value="${tMobilePage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							电话号码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="phonenumber" name="phonenumber" 
							   value="${tMobilePage.phonenumber}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							病毒名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="virusname" name="virusname" 
							   value="${tMobilePage.virusname}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							病毒类型:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="virustype" name="virustype" 
							   value="${tMobilePage.virustype}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							病毒危害:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="virusdesc" name="virusdesc" 
							   value="${tMobilePage.virusdesc}" datatype="*">
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
							   value="<fmt:formatDate value='${tMobilePage.findtime}' type="date" pattern="yyyy-MM-dd"/>" datatype="*">
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
						<input class="inputxt" id="advice" name="advice" ignore="ignore"
							   value="${tMobilePage.advice}">
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
							   value="${tMobilePage.creator}" datatype="*">
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
							   value="<fmt:formatDate value='${tMobilePage.createtime}' type="date" pattern="yyyy-MM-dd"/>" datatype="*">
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
							   value="${tMobilePage.memo}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>