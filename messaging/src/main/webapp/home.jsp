<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link href="https://fonts.googleapis.com/css?family=Indie+Flower" rel="stylesheet">
<style>
@import url('https://fonts.googleapis.com/css?family=Indie+Flower');

body{
background:url("body.jpg");

}
div.header{
border-radius:10px;
background-color:#1b1ebb;
color:white;
padding:30px;
}
div.message{
	border-radius:15px;
	width:250px;
	height:300px;
	background-color:#12ac36;
	box-shadow:10px 10px #88888f

}

img.profile{
	position:relative;
	border-radius:50px;
	width:100px;
	height:100px;
	background-color:#12ac36;
	box-shadow:3px 3px #88888f;
	margin-top:-90px;
	margin-left:1100px;
}
nav{
padding:15px;
min-width:500px;
}
nav ul{
background:linear-gradient(90deg,
rgba(255,255,255,0)0%,
rgba(255,255,255,0.2)25%,
rgba(255,255,255,0.2)75%,
rgba(255,255,255,0)100%);
box-shadow:0 0 25px rgba(0,0,0,0.1),inset 0 0 1px rgba(255,255,255,0.6);
)
}
nav ul li{
display:inline-block;
}

nav ul li a{
padding:10px;
color:#FFFFFF;
font-size:18px;
font-family:Arial;
text-decoration:none;
display:block;
}

nav ul li select{
background:linear-gradient(90deg,
rgba(255,255,255,0)0%,
rgba(255,255,255,0.2)25%,
rgba(255,255,255,0.2)75%,
rgba(255,255,255,0)100%);
box-shadow:0 0 25px rgba(0,0,0,0.1),inset 0 0 1px rgba(255,255,255,0.6);
padding:10px;
color:#FFFFFF;
font-size:18px;
font-family:Arial;
text-decoration:none;
display:block;
}
nav ul li select option{
padding:10px;
color:#000000;
font-size:18px;
font-family:Arial;
text-decoration:none;
display:block;
}

div.quiz{
	overflow:scroll;
	margin-top:-250px;
	margin-left:400px;
	position:relative;
	border-radius:5px;
	width:850px;
	height:400px;
	background-color:#2980B9  ;
	box-shadow:3px 3px #88888f;
	word-wrap:break-word;
	font-size:22px;
font-family:Arial;
text-decoration:none;

}
p#que{
border:25px;
background:linear-gradient(green,black);

}
</style>
</head>

<h2><font color="green">${status }</font></h2>
<body>
<nav>
<ul>
<li><a href="http://localhost:8888/messaging/SigninServlet?logout=yes">Logout</a></li>
<li><a href="http://localhost:8888/messaging/upload.jsp" >Upload New Profile Photo</a></li>
<li><a href="http://localhost:8888/messaging/InboxServlet?uname=${name }">Check Inbox</a></li>
<li><a href="http://localhost:8888/messaging/UpdatePassword?uname=${name }">Update Password</a></li>
<li><a href="http://localhost:8888/messaging/QuizServlet?ques=tchnclques">Technical Quiz</a></li>
<li><a href="http://localhost:8888/messaging/QuizServlet?ques=gnrlques">General Quiz</a></li>
</ul>
</nav>
<div class="header">
<h2 align="center">Welcome to My Application ${name } </font></h2><img class="profile" alt="" src="http://localhost:8888/messaging/RetrievePhotoServlet?uname=${name }"></div>
<div class="message">
<form action="./MessageServlet?uname=${name }" method="POST">
<h2>
 To:<br><input type="text" name="name" value="${clickUname }"/><br>
         
Your Message: <br><textarea row="5" column="10" name="message" width="500" height="400"></textarea>

</h2>
<input type="submit" value="Send">
</form></div>
<div class="quiz">
<h2><strong>${score }</strong></h2>
<c:set var="option" value="${option }"></c:set>
<c:set var="option1" value="msg"></c:set>
<c:set var="option2" value="radio"></c:set>
<c:set var="option3" value="checkbox"></c:set>
<c:set var="option4" value="fill"></c:set>
<c:set var="ques" value="${ques }"></c:set>
<c:choose>
<c:when test="${option eq option1 }">
<c:forEach var="list" items="${list }">
<c:set var="uname" value="${list.getSenderUname() }"></c:set>
<a href="http://localhost:8888/messaging/ClickServlet?click=${uname }">${uname }</a>
<c:out value="${list.getMessage() }"></c:out><h6>
<c:set var="createDate" value="${list.getCreateDate() }"></c:set><br>
<c:out value="  --at--  "></c:out>
<c:out value="${createDate }"></c:out><br></h6>


</c:forEach>
</c:when>
<c:when test="${option eq option2 }">
<c:set var="qno" value="${qno }"></c:set>
<c:out value="${qno+1 }/10"></c:out>
<form action="http://localhost:8888/messaging/QuizServlet?qtype=${option2 }&qno=${qno+1 }&ques=${ques }" method="POST">
<h4><c:out value="Q. ${question }"></c:out><br></h4>
<code>
<c:forEach var="co" items="${code }">
<c:out value="${co.replace(\"$\",\";\") };"></c:out><br>
</c:forEach>
</code>
<h6><c:forEach var="answer" items="${answers }">
<input type="radio" name="answer" value="${answer }">${answer }<br>
</c:forEach></h6>
<input type="submit" value="submit">

</form>
</c:when>
</c:choose>
</div>


</body>
</html>