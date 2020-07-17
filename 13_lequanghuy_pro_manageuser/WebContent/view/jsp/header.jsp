<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE form PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Begin vung header -->
<html>
<form action="logout.do"  name="mainform">
<div>
	<div>
		<table>
			<tr>
				<td width="80%"><img
					src="<c:url value="/view/image/logo-manager-user.gif"></c:url>"
					alt="Luvina" />
				<td>
				<td align="left"><a href="logout.do">ログアウト</a> &nbsp; <a
					href="listUser.do">トップ</a>
				<td>
			</tr>
		</table>
	</div>
</div>
</form>
</html>
<!-- End vung header -->