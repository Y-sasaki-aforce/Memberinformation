<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.html" %>
<p>メニュー画面</p>
<div class="menu">
<form action="regist.jsp" method="get">
<button type="submit">会員情報登録</button>
</form>

<form action="update.jsp" method="get">
<button type="submit">会員情報更新</button>
</form>

<form action="delete.jsp" method="get">
<button type="submit">会員情報削除</button>
</form>
</div>

<%@include file="footer.html" %>