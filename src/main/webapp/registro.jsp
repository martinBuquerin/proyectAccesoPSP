<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_ES" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>

            <link rel="stylesheet" type="text/css" href="/recursos/fontAw/css/all.css">
            <link rel="stylesheet" type="text/css" href="recursos/estilo.css">
            <link rel="stylesheet" type="text/css" href="recursos/bootStrap/css/bootstrap.min.css">

            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        
        </head>


        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid ">
                <img style="width: 120px;height: 50px;" src="recursos/imagenes/log.png">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse " id="navbarSupportedContent">

                    <ul class="navbar-nav me-auto mb-2  ">
                        <li class="nav-item "><a class="nav-link active" style="width: 390px;" aria-current="page" href="#">
                            </a></li>


                        <li class="nav-item ">
                            <div class="dropdown pt-3">
                                <a class="nav-link active" href="#" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
                                    Servicios
                                </a>

                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">

                                  


                                    <li><a class="dropdown-item" href="nombre"><?php echo $result->nombre; ?></a></li>

                                  

                                </ul>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Provincias</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Beneficios</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">¿Eres Profesional?</a>
                        </li>
                    </ul>

                    <ul class="navbar-nav me-auto mb-2  float-end">
                        <li class="nav-item ">


                            <a href="#" style=" font-weight: 600;font-style: normal;" class=" btn btn-success float-end" data-toggle="modal" data-target="#myModal"><i class="far fa-user"></i>
                                Identificate</a>
                        </li>
                    </ul>





                </div>
            </div>
        </nav>









        <body>

            <div class="container-fluid d-flex pt-4 bg-body rounded" style="width: 100%; height:1000px; ">
                <form action="administrador?accion=insertar" method="post" class="form-registro" role="form">
                    <h3>Registro/// aca poner la barra de progrso</h3>
                    <div class="contenedor">   
                        <div class="form-group">

                            <input type="text" id="nombre" name="email" placeholder="Email" class="input-100">

                        </div>
                        <div class="form-group">

                            <input type="text" id="apellidos" name="contrasena" placeholder="Contraseña" class="input-100">
                        </div>
                        <select name="rol" class="input-100">
                            <c:forEach var="rol" items="${roles}" varStatus="status">

                                <option>${rol.nombre}</option>
                            </c:forEach> 

                        </select>



                        <div class="contenedor-btn">
                            <input type="submit" name="enviar" value="Enviar" class="btn-send bg-primary">

                        </div>
                </form>

            </div>

        </body>




        <footer class="bg-success mt-4 fixed-bottom">
            <!-- Grid container -->
            <div class="container p-4">
                <!--Grid row-->
                <div class="row row-cols-4 justify-content-center">

                    <!--Grid column-->
                    <div class="col m-4 ">
                        <h5 class="text-uppercase mb-0">Legal</h5>

                        <ul class="list-unstyled  mb-0" style="padding-top: 2em;">

                            <li>
                                <a href="#!" class="text-dark" style="text-decoration: none">Sobre nosotros</a>
                            </li>
                            <li>
                                <a href="#!" class="text-dark" style="text-decoration: none">Contacta con nosotros</a>
                            </li>

                        </ul>
                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col m-4 ">
                        <h5 class="text-uppercase">Sobre Hogami</h5>

                        <ul class="list-unstyled mb-0" style="padding-top: 2em;">

                            <li>
                                <a href="#!" class="text-dark" style="text-decoration: none">Aviso legal</a>
                            </li>
                            <li>
                                <a href="#!" class="text-dark" style="text-decoration: none">Política de privacidad</a>
                            </li>
                            <li>
                                <a href="#!" class="text-dark" style="text-decoration: none">Política de cookies</a>
                            </li>

                        </ul>
                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col m-4">
                        <h5 class="text-uppercase mb-0">Sobre Hogami</h5>

                        <ul class="list-unstyled" style="padding-top: 2em;">

                            <li>
                                <a href="#!" class="text-dark" style="text-decoration: none">¿Cómo funciona?</a>
                            </li>
                            <li>
                                <a href="#!" class="text-dark" style="text-decoration: none">FAQs</a>
                            </li>

                        </ul>
                    </div>
                    <!--Grid column-->
                </div>
                <!--Grid row-->
            </div>
            <!-- Grid container -->


        </footer>
        <script src="recursos/bootStrap/js/bootstrap.min.js"></script>
        <script src="recursos/java.js"></script>
        <script src="recursos/fontAw/js/all.js"></script>
    </body>

</html>