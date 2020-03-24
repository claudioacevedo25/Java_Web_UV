<%-- 
    Document   : login
    Created on : 23-oct-2019, 19:58:22
    Author     : claud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>

    <!--JQUERY-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!--BOOTSTRAP-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <!--icono-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
    <script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
    <!--css-->
    <link href="login.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div class="modal-dialog text-center">
        <div class="col-sm-8 main-section">
            <div class="modal-content">
                <div class="col-12 user-img">
                    <img src="avatar.png"/>
                </div>
                <form method="post" action="LoginServlet" class="col-12">
                  <input type="hidden" name="patch" value="<%=request.getParameter("patch") %>">
                    <div class="form-group" id="user-group">
                        <input type="text" name="user" class="form-control" id="txt_usuario" placeholder="Usuario" required/>
                    </div>
                    <div class="form-group" id="contrasena-group">
                        <input type="password" name="password" class="form-control" id="txt_password" placeholder="Contrasena" required/>
                    </div>
                    <button type="submit" name="btn_login" id="btn_login" value="ingresar" class="btn btn-primary"><i class="fas fa-sign-in-alt"></i>  Ingresar </button>
                </form>
                
            </div>
        </div>
    </div>
</body>
</html>
