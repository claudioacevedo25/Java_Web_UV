<%-- 
    Document   : AltaMateria
    Created on : 30-oct-2019, 1:29:19
    Author     : claud
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALTA DE MATERIAS</title>
    </head>
    <body>
        <h1>MATERIAS</h1>
        <br> 
        <div class="formulario">
            <form action="ServletMaterias" method="POST" id="formularioMateria">
                <input type="hidden" name="txt_id"  id="txt_id" value="${materiaAeditar.id}">
		<label for="" class="">NOMBRE</label>
                <input type="text" name="txt_nombre" class="form-control form-control-lg" id="txt_nombre" value="${materiaAeditar.nombre}">                   
                <div class="alert alert-danger" role="alert" id="cajaError">
                    <p>Verifique que esten cargados todos los elemnetos</p>
                </div>
		<input type="submit" value="ENVIAR" class="btn btn-primary">
            </form>
        </div>
        
    </body>
</html>
