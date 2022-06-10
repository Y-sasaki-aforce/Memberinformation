<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="header.html" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>会員情報登録</p>

<form action="../jp.co.aforce.servlet/regist" method="post">
		<p>${msg}
		</p>

		<p>名前
			 姓<input type="text" name="last_name" >
			 名<input type="text" name="first_name" >
		</p>


		<p>性別
			男<input type="radio" name="sex" value="1">
			女<input type="radio" name="sex" value="2">
		</p>

		<p>生年月日
			<select name="birth_year" >
				<c:forEach var="i" begin="1920" end="2020">
					<option value="${i}">${i}</option>
				</c:forEach>
			</select>年

			<select name="birth_month" >
				<c:forEach var="j" begin="1" end="12">
					<option value="${j}">${j}</option>
				</c:forEach>
			</select>月

			<select name="birth_day" >
				<c:forEach var="k" begin="1" end="31">
					<option value="${k}">${k}</option>
				</c:forEach>
			</select>日
		</p>

		<p>職業
			<select name="job" >
				<option value="100">会社員</option>
				<option value="200">自営業</option>
				<option value="300">学生</option>
				<option value="400">その他</option>
			</select>
		</p>

		<p>電話番号<input type="text" name="phone_number" >
		</p>

		<p>メールアドレス<input type="text" name="mail_address" >
		</p>

		<button type="submit" >登録</button>

</form>

<form action="../jp.co.aforce.servlet/regist" method="get">
<button type="submit" name="rest">リセット</button>
</form>

<form action="../jp.co.aforce.servlet/menu" method="get">
		<button type="submit" name="back">戻る</button>
</form>

<%@include file="footer.html" %>