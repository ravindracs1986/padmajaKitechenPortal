<%@ page isELIgnored="false"%>
<html>
<head>


<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%-- <title>Document Singing</title>
	<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link> --%>
</head>

</head>
<body>

	<%-- <h3>Document Singing</h3>


	<div class="form-container">
		<h1>Welcome to Document Singing</h1>
		
		Click on below links to see FileUpload in action.<br/><br/>
		
		<a href="${pageContext.request.contextPath}/singleUpload">Single File Upload</a>  OR  <a href="${pageContext.request.contextPath}/multiUpload">Multi File Upload</a>
	</div> --%>
	
	<form method="post" action="userRegistration.jsp">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="firstName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lastName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="userName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Already registered!! <a href="index.jsp">Login Here</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
  </body>
</html>