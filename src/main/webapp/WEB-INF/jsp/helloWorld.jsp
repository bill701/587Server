<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Spring pagination using data tables</title>
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css"
	href="https://www.datatables.net/release-datatables/extensions/ColVis/css/dataTables.colVis.css">


<script type="text/javascript"
	src="//code.jquery.com/jquery-1.10.2.min.js"></script>
	<script type="text/javascript"
	src="//cdn.datatables.net/1.10.6/js/jquery.dataTables.js"></script>
	<script type="text/javascript"
	src="//cdn.datatables.net/plug-ins/1.10.7/api/fnReloadAjax.js"></script>

<script type="text/javascript"
	src="https://www.datatables.net/release-datatables/extensions/ColVis/js/dataTables.colVis.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script> 
<script type="text/javascript" src="resource/js/test.js"></script>
</head>
<body>
	
		<h2>
			Spring MVC pagination using data tables<br> 
			<select id='groupSelect'>
			
  <option value="volvo">Volvo</option>
  <option value="saab">Saab</option>
  <option value="opel">Opel</option>
  <option value="audi">Audi</option>
</select>
			<br>
		</h2>

		<div>
			<table width="100%"
				style="border: 3px;background: rgb(243, 244, 248);">
				<tr>
					<td>
						<table id="example" class="display" cellspacing="0" width="100%">
							<thead>
								<tr>
								    <th>Tag</th>
									<th>Name</th>
									<th>Position</th>
									<th>Office</th>
									<th>Phone</th>
									<th>Start Date</th>
									<th>Salary</th>
								</tr>
							</thead>
						</table></td>
				</tr>
			</table>
		</div>
		<div>
			<p>
			<p>
			
			<p>
			<p id="hehe" >
			<table id="example2" class="display" cellspacing="0" width="100%">
				<thead>
				<tr>
						<th>Name</th>
						<th>Position</th>
						<th>Office</th>
						<th>Phone</th>
						<th>Start Date</th>
						<th>Salary</th>
					</tr>
					
				</thead>
				<tfoot>
					<tr>
						<th>Name</th>
						<th>Position</th>
						<th>Office</th>
						<th>Phone</th>
						<th>Start Date</th>
						<th>Salary</th>
					</tr>
				</tfoot>
			</table>

		</div>


</body>
</html>