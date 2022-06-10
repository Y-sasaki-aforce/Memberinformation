<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="header.html" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>会員情報削除</p>


<form action="../jp.co.aforce.servlet/delete-search" method="post" name="search">
	<p>${msg}</p>
	<p>会員番号<input type="text" name="member_id"  value = "${member.member_id}">
			<button type="submit">検索</button><br>
	</p>
</form>

<form action="../jp.co.aforce.servlet/delete" method="post">


		<p>名前
			 姓<input type="text" name="last_name"  value = "${member.last_name}">
			 名<input type="text" name="first_name"  value = "${member.first_name}">

		</p>

		<p>性別
		<c:choose>
			<c:when test="${member.sex == '1'}">
				<input type="radio" name="sex" value="1" checked="checked">
				<input type="radio" name="sex" value="2">
			</c:when>
			<c:when test="${member.sex == '2'}">
				<input type ="radio" name = "sex" value = "1" >男
				<input type ="radio" name = "sex" value = "2"  checked="checked">女
			</c:when>
			<c:otherwise>
				<input type ="radio" name = "sex" value = "1" >男
				<input type ="radio" name = "sex" value = "2" >女
			</c:otherwise>
		</c:choose>

		<p>生年月日
			<select name="birth_year" >
				<c:forEach var="i" begin="1920" end="2020">
					<option value="${i}">${i}</option>
				</c:forEach>
				<c:if test="${not empty member.birth_year}">
					<option value = "${member.birth_year}"selected>${member.birth_year}</option>
				</c:if>
			</select>年

			<select name="birth_month" >
				<c:forEach var="i" begin="1" end="12">
					<option value="${i}">${i}</option>
				</c:forEach>
				<c:if test="${not empty member.birth_month}">
					<option value = "${member.birth_month}"selected>${member.birth_month}</option>
				</c:if>
			</select>月

			<select name="birth_day" >
				<c:forEach var="j" begin="1" end="31">
					<option value="${j}">${j}</option>
				</c:forEach>
				<c:if test="${not empty member.birth_day}">
					<option value = "${member.birth_day}"selected>${member.birth_day}</option>
				</c:if>
			</select>日
		</p>

		<p>職業
			<select name="job" >
					<option value="100">会社員</option>
					<option value="200">自営業</option>
					<option value="300">学生</option>
					<option value="400">その他</option>
				<c:if test="${not empty member.job}">
					<c:choose>
						<c:when test="${member.job == '100' }">
						<option value = "100" selected>会社員</option>
						</c:when>
						<c:when test="${member.job == '200' }">
						<option value = "200" selected>自営業</option>
						</c:when>
						<c:when test="${member.job == '300' }">
						<option value = "300" selected>学生</option>
						</c:when>
						<c:when test="${member.job == '400' }">
						<option value = "400" selected>その他</option>
						</c:when>
					</c:choose>
				</c:if>
			</select>
		</p>

		<p>電話番号<input type="text" name="phone_number" value = "${member.phone_number}">
		</p>

		<p>メールアドレス<input type="text" name="mail_address" value = "${member.mail_address}" >
		</p>

		<button type="submit" >削除</button>
</form>

<form action="../jp.co.aforce.servlet/delete" method="get">
<button type="submit" name="rest">リセット</button>
</form>

<form action="../jp.co.aforce.servlet/menu" method="get">
		<button type="submit" name="back">戻る</button>
</form>

<%@include file="footer.html" %>