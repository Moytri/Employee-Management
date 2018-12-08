<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<!doctype html>
<html lang="en">

	<head>
		
		<title>Employee List</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<!-- Reference Bootstrap files -->
		<link rel="stylesheet"
			 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		
		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
<style>
	table {
	    font-family: arial, sans-serif;
	    border-collapse: collapse;
	    width: 100%;
	}
	
	td, th {
	    border: 1px solid #dddddd;
	    text-align: left;
	    padding: 8px;
	}
	
	tr:nth-child(even) {
	    background-color: #dddddd;
	}
</style>
	
	</head>
	<body>
		<div style="margin-top: 20px;">			
			<div class="panel panel-info" align="left">

				<div class="panel-heading">
					<div class="panel-title">Employees List</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">	
	                           
					<display:table name="${emps}" sort="list" pagesize="5" id="table1" export="false" 
						requestURI="/app" varTotals="emp" decorator="ca.bcit.comp4613.dao.DateDecorator"> 		                           
		                <display:setProperty name="paging.banner.placement">bottom</display:setProperty>
		                <display:column property="ID" title="ID"/>
		                <display:column property="firstName" title="First Name" sortable="true" headerClass="sortable"/>
		                <display:column property="lastName" title="Last Name"/>
		                <display:column property="dob" sortable="true" headerClass="sortable" title="DOB" />
		            </display:table>
				</div>				
			</div>
		</div>
	</body>

</html>
