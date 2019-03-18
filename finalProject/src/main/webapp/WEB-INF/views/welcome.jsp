<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1> ${greeting} </h1>
				<p> ${tagline} </p>
  					Welcome  ${member.firstName} !
 
			</div>	 
 
				  <div class="container">
					<c:choose>
					    <c:when test="${empty member}">
      					<a href="<spring:url value= '/member/login'/>" class="btn btn-default pull-right"> Login</a>
      					<a href="<spring:url value= '/member/signUp'/>" class="btn btn-default pull-right"> SingUp</a>
      					<a href="<spring:url value= '/materials/upload'/>" class="btn btn-default pull-right"> Add Material</a>
      					<a href="<spring:url value="/members/edit" />" class="btn btn-default pull-right">Edit Member</a>	
		 				<a href="<spring:url value="/members/editPic"/>" class="btn btn-default pull-right">Edit Member Picture</a>
					    </c:when>
					    <c:otherwise>
		 					<a href="<spring:url value="/members/edit" />" class="btn btn-default pull-right">Edit Member</a>	
		 					<a href="<spring:url value="/members/editPic"/>" class="btn btn-default pull-right">Edit Member Picture</a>	
		 					<br>
		 					<br>
		 					<a href="<spring:url value='/logout' />" class="btn btn-default pull-right"> Logout</a>
		 
 					    </c:otherwise>
					</c:choose>	
 					 <a href="<spring:url value='/members' />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> Go to Community
					</a>
				</div>	
	 			<div class="pull-left"> <h3>${SpecialBlurb}</h3> </div>
		</div>	
	</section>
	
</body>
</html>
