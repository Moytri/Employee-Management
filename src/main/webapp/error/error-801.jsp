<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
			
		<title>Find Employees</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<!-- Reference Bootstrap files -->
		<link rel="stylesheet"
			 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		
		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	</head>
	<body>
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Find an Employee By ID</div>
			</div>

			<div style="padding-top: 15px" class="panel-body">	
			
				<form class="form-horizontal" action="app" method="post">
					<div class="form-group row">
					    <label for="id" class="col-sm-3 col-form-label">ID</label>
					    <div class="col-sm-9">
					      <input type="text" class="form-control-plaintext" name="id" style="width:285px;">
					      <input type="hidden" name="role" value="${role}"/>
					    </div>
					 </div>					 						 			
					<button type="submit" name="button" value="findEmployee" class="btn btn-default" style="float: right;">Search</button>
				</form>
				<h6>Result Code: <c:out value="${message.code}"/> Description: <c:out value="${message.message}"/></h6>		
			</div>
		</div>
	</body>
</html>