<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
			
		<title>Add Employees</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<!-- Reference Bootstrap files -->
		<link rel="stylesheet"
			 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		
		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	</head>
	<body>		
		<div style="margin-top: 20px;">			
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Add Employees</div>
				</div>
				<div style="padding-top: 15px" class="panel-body">	
					<form class="form-horizontal" action="app" method="post">
						<div class="form-group row">
						    <label for="id" class="col-sm-3 col-form-label">ID</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control-plaintext" name="id" style="width:285px;">
						    </div>
						 </div>
						 
						<div class="form-group row">
						    <label for="first_name" class="col-sm-3 col-form-label">First Name</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control-plaintext" name="first_name" style="width:285px;">
						    </div>
						 </div>		
						 
						<div class="form-group row">
						    <label for="last_name" class="col-sm-3 col-form-label">Last Name</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control-plaintext" name="last_name" style="width:285px;">
						    </div>
						 </div>	
						 
						<div class="form-group row">
						    <label for="dob" class="col-sm-3 col-form-label">DOB</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control-plaintext" name="dob" placeholder="YYYY/MM/DD" style="width:285px;">
						    </div>
						 </div>							 						 			
						<button type="submit" name="button" value="addEmployee" class="btn btn-default" style="float: right;">Add Employees</button>				
						<c:if test="${message.code == 200}">
							<h6>Result Code: <c:out value="${message.code}"/> Description: <c:out value="${message.message}"/></h6>
						</c:if>
						<c:if test="${message.code == 901 && param.button == 'addEmployee'}">
							<h6>Result Code: <c:out value="${message.code}"/> Description: <c:out value="${message.message}"/></h6>
						</c:if>
						<c:if test="${message.code == 900}">
							<h6>Result Code: <c:out value="${message.code}"/> Description: <c:out value="${message.message}"/></h6>
						</c:if>
					</form>	
				</div>
			</div>
		</div>
	</body>

</html>