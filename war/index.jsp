<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Hello App Engine</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>

<body  background="background.jpg" > 

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			
				<a class="navbar-brand" href="social" class="ex">FCI Social
					Network</a>
			
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">


			<!-- 			<ul class="nav navbar-nav navbar-right"> -->
			<!-- Large button group -->
			<!-- 				<div class="btn-group"> -->
			<!-- 					<button class="btn btn-default btn-lg dropdown-toggle" -->
			<!-- 						type="button" role="menu" data-toggle="dropdown" -->
			<!-- 						aria-labelledby="dropdownMenu3"> -->
			<!-- 						log in <span class="caret"></span> -->
			<!-- 					</button> -->
			<!-- 					<ul class="dropdown-menu" role="menu"> -->
			<style>
			b{
			color: white;
			margin-top: 30px;
			padding-top: 30px;
			}
			</style>
			
			<center>
			<form action="/social/home" method="POST">

				<b >Name:</b>
				 <input type="text"name="uname" required/> 
					<b>Password:</b>
					<input type="password"name="password" required/>
			
						
							
		
						
		<button class="btn btn-danger btn-small"><i class="icon-white icon-thumbs-up"></i> Log in</button>
			
			</form>
			</center>
			<!-- 					</ul> -->
			<!-- 				</div> -->

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>


<br><br><br>

<div align="center" style=" margin: 200px;"  >
<table cellpadding="5" bgcolor="#E8E8E8" >
<form action="/social/response" method="post">

   
   <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1" type="text" name="uname"required>
   <input type="password" class="form-control" placeholder="password" aria-describedby="basic-addon1"  name="password"required>
   <input type="text" class="form-control" placeholder="Email" aria-describedby="basic-addon1" type="text" name="email"required>
   
   </tr>
   <tr>
   
   <button type="submit" class="btn btn-danger btn-large"><i class="icon-white icon-thumbs-up" ></i> Register</button>
   
   </tr>
  </form>
  </table>
  </div>
  
  

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>


</body>
</html>
