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
            <a href="/droit">Liste role</a>
        </h2>
 </center>
    <div align="center">
        <form method="post" action='droit' autocomplete="off" style="font-family:Roboto;">
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
        			<input type='text' name='name' required placeholder="role"/>
        			<input type='submit' name='submit'/>
        		</div>
        	</div>
        </form>
    </div>
</body>
</html>
