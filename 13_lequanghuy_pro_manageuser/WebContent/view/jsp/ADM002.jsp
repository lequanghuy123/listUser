<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/views/css/style.css"></c:url>">
<title>ユーザ管理</title>
</head>
<body>
	<p>
		<c var="loginName" items="${loginName}"> ${ loginName}</c>
	</p>
	<jsp:include page="header.jsp"></jsp:include>
	<!-- Begin vung dieu kien tim kiem -->
	<form action="listUser.do?action=load" name="mainform" method="get">
		<table class="tbl_input" border="0" width="90%" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>会員名称で会員を検索します。検索条件無しの場合は全て表示されます。</td>
			</tr>
			<tr>
				<td width="100%">
					<table class="tbl_input" cellpadding="4" cellspacing="0">
						<tr>
							<td class="lbl_left">氏名:</td>
							<td align="left"><input class="txBox" type="text"
								name="name" value="" size="20"
								onfocus="this.style.borderColor='#0066ff';"
								onblur="this.style.borderColor='#aaaaaa';" /></td>
							<td></td>
						</tr>
						<tr>
							<td class="lbl_left">グループ:</td>
							<td align="left" width="80px"><select name="group_id">
									<option value="0">全て</option>
									<c:forEach var="groupName" items="${listGroup}">
										<option value="0">${groupName }</option>
									</c:forEach>
							</select></td>
							<td align="left"><input class="btn" type="submit" value="検索" />
								<input class="btn" type="button" value="新規追加"
								onclick="window.location.href='addUser'" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- End vung dieu kien tim kiem -->
	</form>
	<!-- Begin vung hien thi danh sach user -->
	<table class="tbl_list" border="1" cellpadding="4" cellspacing="0"
		width="80%">

		<tr class="tr2">
			<th align="center" width="20px">ID</th>
			<th align="left">氏名 <a href="">▲▽</a>
			</th>
			<th align="left">生年月日</th>
			<th align="left">グループ</th>
			<th align="left">メールアドレス</th>
			<th align="left" width="70px">電話番号</th>
			<th align="left">日本語能力 <a href="">▲▽</a>
			</th>
			<th align="left">失効日 <a href="">△▼</a>
			</th>
			<th align="left">点数</th>
		</tr>
		<c:forEach var="userInfors" items="${listUserInfors}">
				<tr>
					<td><a  href ="#">${fc:escapeXml(userInfors.userId)}</a></td>
					<td>${fc:escapeXml(userInfors.fullName)}</td>
					<td>${userInfors.birthDay}</td>
					<td>${fc:escapeXml(userInfors.groupName)}</td>
					<td>${fc:escapeXml(userInfors.email)}</td>
					<td>${fc:escapeXml(userInfors.tel)}</td>
					<td>${fc:escapeXml(userInfors.nameLevel)}</td>
					<td>${fc:escapeXml(userInfors.endDate)}</td>
      				<c:choose>
    					<c:when test="${userInfors.total == 0}">
       						<td></td>
   						</c:when>
    				<c:otherwise>
       					<td>${userInfors.total}</td>
    				</c:otherwise>
					</c:choose>
				</tr>
		</c:forEach>
	</table>
	<!-- End vung hien thi danh sach user -->
	<!-- Begin vung paging -->
	<table>
		<tr>
			<td class="lbl_paging"><a href="#">1</a> &nbsp;<a href="#">2</a>
				&nbsp;<a href="#">3</a>&nbsp;<a href="#">>></a></td>
		</tr>
	</table>
	<!-- End vung paging -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>