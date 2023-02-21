
<%@page import="domain.Roles"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_ES" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
<link rel="stylesheet" href="estilo.css">
<link rel="stylesheet" href="https://kit.fontawesome.com/c6b31a7173.css" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<title>miWeB.</title>
<%
    String correo = (String) session.getAttribute("email");

    if (correo != null) {
        System.out.println("correo desde el header " + correo);
    } else {
        System.out.println("no tienes corre");
    }

    if (correo == null) {
%> 

<nav class="navbar navbar-expand-lg navbar-light p-3" id="menu">
    <div class="container">
        <a class="navbar-brand" href="#">
            <span class="fs-5 text-success fw-bold">miWeB.</span>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mx-auto mb-2 ml-6 mb-lg-0 " style="width: 500px;">
                <li class="nav-item ">
                    <a class="nav-link" aria-current="page" href="index.jsp">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#equipo">Servicios</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#seccion-contacto">Soy profesional</a>
                </li>
            </ul>
            <form class="d-flex">
                <!--<a href="#" style=" font-weight: 600;font-style: normal;" class=" btn btn-success float-end" data-toggle="modal" data-target="#modalRegistroAdmninistrador"><i class="far fa-user"></i>Identifícate</a>-->
                <button type="button" id="logIn" class="btn btn-success btn-primary-outline-success" data-toggle="modal" data-target="#modalLogin"><i class="far fa-user" style="padding-right:4px;"></i>Identifícate</button>

            </form>
        </div>

    </div>
</nav>

<% } else {

%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><img style="width: 90px;height: 50px;" src="recursos/imagenes/fotoBarra.png"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse " id="navbarSupportedContent">

            <ul class="navbar-nav ms-auto mb-2  ">
                <li class="nav-item "><a class="nav-link active" aria-current="page" href="#">            </a></li>


                <li class="nav-item ">
                    <a class="nav-link active" aria-current="page" href="#">Servicios</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Provincias</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Beneficios</a>
                </li>
            </ul>


            <a href="#" style=" font-weight: 600;font-style: normal;" class=" btn btn-success float-end" data-toggle="modal" data-target="#myModalLogueado"><i class="far fa-user"></i>

                <%=correo%></a>



            <!--  <a href="#" style=" font-weight: 600;font-style: normal;" class=" btn btn-success float-end" data-toggle="modal" data-target="#myModal"><i class="far fa-user"></i>Identificate</a>-->



        </div>
    </div> 
</nav>

<% }%>


<div class="modal fade" id="modalLogin" tabindex="-1" role="dialog" style="margin-top:9em;  "aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog">

        <div class="modal-content d-flex justify-content-center">

            <div class="row">
                <div class="col pt-4" style="padding-left:200px;">

                    <h1 class="p-2 fs-2 text-center">Login</h1>
                </div>
                <div class="col" style="width:150px;">
                    <button type="submit" class="btn btn-danger p-1 float-end px-3 m-2" data-dismiss="modal"  name="salir" >x</button>
                </div>
            </div>
            <div class="modal-body p-2 ">
                <form action="usuario?accion=validarLogin" method="POST">
                    <div class="form-group p-2">
                        <div class="row">
                            <div class="col " style="padding-left:7em; padding-top: 0.5em;">
                                 <p class="fs-5 font-weight-normal">Email</p>
                            </div>
                            <div class="col">
                                <input type="email" class="form-control mt-1" name="email" style="width: 12em; height: 2em; margin-right:4em;">
                            </div>
                        </div>
                    </div>

                    <div class="form-group p-2 pb-4 border-2 border-gray border-bottom ">
                        <div class="row">
                            <div class="col " style="padding-left:5em; padding-top: 0.5em;">
                                <p class="fs-5 font-weight-normal">Contraseña</p>
                            </div>
                            <div class="col">
                                <input type="password" class="form-control mt-1" name="contrasena" style="width: 12em;  height: 2em; margin-right:4em;">
                            </div>
                        </div>
                        <p  class="text-end m-2"> <a href="#">He olvidado mi contraseña.</a></p>
                    </div>

                    <div class="form-group p-2">
                        <div class="row">
                            <div class="col d-flex justify-content-center ">
                                <p class="f-1 m-2">Conectarse con <span class="text-primary">G</span><span class="text-danger">o</span><span class="text-warning">o</span><span class="text-primary">g</span>l<span class="text-success">e</span></p>
                                <img class="m-2"src="./imagenes/google-icon.svg" height="24px" width="24px"/>
                            </div>
                            
                        </div>
                    </div>
                    <div class="col text-center p-2 mt-2">

                        <button type="submit" class="btn btn-success mb-3" name="enviar" value="Enviar">Iniciar Sesión</button>
                        <p>¿No tienes una cuenta? <a href="#">Registrate</a></p>
                    </div>
                </form>
            </div>
            <!--<a href="administrador.php" class="btn btn-success float-end" style="margin:1rem;">Volver</a>-->
        </div>
    </div>

</div>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
