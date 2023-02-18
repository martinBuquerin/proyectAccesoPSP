
<%@page import="domain.Roles"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_ES" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<%
    String correo = (String) session.getAttribute("email");

    if (correo != null) {
        System.out.println("correo desde el header " + correo);
    } else {
        System.out.println("no tienes corre");
    }

    if (correo == null) {
%> 


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><img style="width: 90px;height: 50px;" src="../imagenes/img1.jpg"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse " id="navbarSupportedContent">

            <ul class="navbar-nav me-auto mb-2  ">
                <li class="nav-item "><a class="nav-link active" style="width: 390px;" aria-current="page" href="#">            </a></li>


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







            <a href="#" style=" font-weight: 600;font-style: normal;" class=" btn btn-success float-end" data-toggle="modal" data-target="#myModal"><i class="far fa-user"></i>Identificate</a>




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

            <ul class="navbar-nav me-auto mb-2  ">
                <li class="nav-item "><a class="nav-link active" style="width: 390px;" aria-current="page" href="#">            </a></li>


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
<div class="modal fade" id="myModal">
    <form action="usuario?accion=validarLogin" method="post" class="form-registro" role="form">
        <div class="modal-dialog modal-dialog-centered modal-xl">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="m-2 ">

                    <button type="button" class="btn float-end" data-dismiss="modal"><i class="fa-solid fa-circle-xmark"></i></button>
                </div>


                <div class="bg-white p-5 rounded-5 text-secondary shadow" >
                    <div class="d-flex justify-content-center rounded-5">
                        <img src="./recursos/imagenes/login-icon.svg" alt="login-icon" style="height: 7rem" />
                    </div>
                    <div class="text-center fs-1 fw-bold rounded-5">Login</div>
                    <div class="input-group mt-4 rounded-5" >

                        <input class="form-control bg-light rounded-5" type="text" name="email" placeholder="Email" />
                    </div>
                    <div class="input-group mt-1 rounded-5">

                        <input class="form-control bg-light rounded-5" type="password" name="contrasena" placeholder="Contraseña" />
                    </div>
                    <div class="d-flex justify-content-around mt-1 rounded-5">
                        <div class="d-flex align-items-center gap-1 rounded-5">
                            <input class="form-check-input" type="checkbox" />
                            <div class="pt-1" style="font-size: 0.9rem">Recuerdame</div>
                        </div>
                        <div class="pt-1">
                            <a href="#" class="text-decoration-none text-success fw-semibold fst-italic rounded-5"
                               style="font-size: 1.5rem">¿Ha olvidado su contraseña?</a>
                        </div>
                    </div>
                    <input class="btn btn-success text-white w-100 mt-4 fw-semibold shadow-sm rounded-5" type="submit">
                    <div class="d-flex gap-1 justify-content-center mt-1 rounded-5">
                        <div>¿No tienes cuenta?</div>
                        <a href="" data-toggle="modal" data-target="#modalRegistro" data-dismiss="modal"  class="text-decoration-none text-success fw-semibold rounded-5">Registrate</a>
                    </div>
                    <div class="p-3">
                        <div class="border-bottom text-center rounded-5" style="height: 0.9rem">
                            <span class="bg-white px-3">or</span>
                        </div>
                    </div>
                    <div class="btn d-flex gap-2 justify-content-center border mt-3 shadow-sm rounded-5">
                        <img src="./recursos/imagenes/google-icon.svg" alt="google-icon" style="height: 1.6rem" />
                        <div class="fw-semibold text-secondary rounded-5">Continua con Google</div>
                    </div>
                </div>



            </div>

        </div>
    </form>
</div>

<%
    List<Roles> rol = (List<Roles>) session.getAttribute("modalRegistro");
    System.out.println("roles en header" + rol);
    if (rol != null) {

    }
%>
<div class="modal fade" id="modalRegistro">
    <form action="administrador?accion=insertar" method="post" class="form-registro" role="form">
        <div class="modal-dialog modal-dialog-centered modal-xl">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="m-2 ">

                    <button type="button" class="btn float-end" data-dismiss="modal"><i class="fa-solid fa-circle-xmark"></i></button>
                </div>


                <div class="bg-white p-5 rounded-5 text-secondary shadow" >
                    <div class="d-flex justify-content-center rounded-5">
                        <img src="./recursos/imagenes/login-icon.svg" alt="login-icon" style="height: 7rem" />
                    </div>
                    <div class="text-center fs-1 fw-bold rounded-5">Registro</div>
                    <div class="input-group mt-4 rounded-5" >

                        <input class="form-control bg-light rounded-5" type="email" name="email" placeholder="Email" />
                    </div>
                    <div class="input-group mt-1 rounded-5">

                        <input class="form-control bg-light rounded-5" type="password" name="contrasena" placeholder="Contraseña" />
                    </div>

                    <div class="input-group mt-1 rounded-5">


                        <select name="rol" class="form-control bg-light rounded-5" >
                            <option class="form-control bg-light rounded-5">Selecciona un rol:</option>

                            <<option value="Administrador">Administrador</option>
                            <<option value="Profesional">Profesional</option>
                            <<option value="Cliente">Cliente</option>
                           

                        </select>




                    </div>


                    <input class="btn btn-success text-white w-100 mt-4 fw-semibold shadow-sm rounded-5" type="submit">

                    <div class="p-3">
                        <div class="border-bottom text-center rounded-5" style="height: 0.9rem">
                            <span class="bg-white px-3">or</span>
                        </div>
                    </div>
                    <div class="btn d-flex gap-2 justify-content-center border mt-3 shadow-sm rounded-5">
                        <img src="./recursos/imagenes/google-icon.svg" alt="google-icon" style="height: 1.6rem" />
                        <div class="fw-semibold text-secondary rounded-5">Continua con Google</div>
                    </div>
                </div>



            </div>

        </div>
    </form>
</div>




<div class="modal fade" id="myModalLogueado">
    <div class="modal-dialog ">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="m-2 ">

                <button type="button" class="btn float-end" data-dismiss="modal"><i class="fa-solid fa-circle-xmark"></i></button>
            </div>
            <div class="modal-body ">


                <form class="p-4 mt-4" action="" method="POST">

                    <div class="d-flex justify-content-center align-content-center mt-4 ">
                        <a data-toggle="modal" data-target="#modificarPerfil" data-dismiss="modal" class="btn btn-success">Perfil</a>
                    </div>
                    <hr>

                    <div class="d-flex justify-content-center align-content-center mt-4">
                        <a href="cerrarSesion.jsp" class="btn btn-success">Cerrar Sesion</a>
                    </div>
                </form>


            </div>

        </div>

    </div>
</div>



<script src="recursos/bootStrap/js/bootstrap.min.js"></script>
<script src="recursos/java.js"></script>
<script src="recursos/fontAw/js/all.js"></script>

