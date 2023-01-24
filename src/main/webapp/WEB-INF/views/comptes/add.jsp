<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
 <title>TP JAVA</title>
</head>
<body>
 <center>
  <h1>Formulaire de création de comptes</h1>
        <h2>
            <a href="/compte">Liste compte</a>
        </h2>
 </center>
    <div align="center">
        <form method="post" action='compte' autocomplete="off" style="font-family:Roboto;">
            <% if(request.getAttribute("success") != null){%>
                <div class="row">
                    <div class="col-md-12">
                        <span class='text-danger'><%= request.getAttribute("success") %></span>
                    </div>
                </div>
            <%}%>
            <%if(request.getAttribute("error") != null){%>
                <div class="row">
                    <div class="col-md-12">
                        <span class='text-danger'><%= request.getAttribute("error") %></span>
                    </div>
                </div>
            <%}%>
        	<div class="row">
        		<div class="col-md-12">
        			<input type='text' name='username' required/>
        			<input type='password' name='password' required/>
        			<input type='submit' name='submit'/>
        		</div>
        	</div>
        </form>
    </div>
</body>
</html>
