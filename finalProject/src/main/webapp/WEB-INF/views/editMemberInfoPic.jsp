<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Member</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Change your profile</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<h1>Uploade a new profile here</h1>

<form method="POST" action="upload" enctype="multipart/form-data">
    <input type="file" name="file" /><br/><br/>
    <input type="submit" value="Upload" />
</form> 
<h2>${message}</h2>
	</section>
</body>
</html>

