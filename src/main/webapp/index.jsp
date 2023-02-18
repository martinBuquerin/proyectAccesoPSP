<%-- 
    Document   : index
    Created on : 31-ene-2023, 10:16:33
    Author     : Martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Proyecto AccesoDatos PSP</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style>
            #conEstilo {
                background: url("./imagenes/fodo55.jpg") no-repeat center center fixed;
                background-size: cover;
                }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp" />

        <main>

            <body>


                <div id="conEstilo" class="container-fluid pt-4" style="padding-bottom: 14rem; ">
                    <!-- SECCION DEL BUSCADOR-->
                    <h3 style="text-shadow: #000000 1px 1px 1px;text-align: center; font-family: calendas; font-size:8rem; color:#FFFFFB; padding-top:12rem">
                        Encuentra servicios y profesionales</h3>
                    <!--<h3 style="text-shadow: #FFFFFB 1px 1px 1px; text-align: center; font-family: calendas; font-size:3.5rem; color:#079719;">para tu hogar, oficina o local.</h3>-->
                    <form class="justify-content-center d-flex" action="./busqueda.php" method="POST" style="padding-bottom: 14rem; ">
                        <div class="row mt-5" style="text-align: center;">
                            <div class="col-auto mb-3 " style="padding-top:5rem;" style="width: 190rem;">
                                <label for="exampleInputEmail1" style="text-shadow: #000000 1px 1px 1px;text-align: center; font-family: calendas; font-size:2.6rem; color:#FFFFFB;">¿Qué
                                    servicio buscas?</label>
                                <div class="row" style="padding-top: 2rem;">
                                    <div class="col">
                                        <input type="text" class="form-control " name="servicio" style="width: 65rem" />
                                    </div>
                                    <div class="col">
                                        <button class="btn btn-success float-end" type="submit">Buscar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>


                    <!-- carousel -->

                    <div class=" container mt-4 mb-4">

                        <br><br>


                        <div class="slider d-flex justify-content-center">

                            <div id="carouselExampleSlidesOnly" class="carousel slide   w-90 h-70  " data-bs-ride="carousel" data-bs-interval="5000">
                                <div class="carousel-inner  ">
                                    <div class="carousel-item active">
                                        <img class="d-inline img-fluid" src="recursos/imagenes/cerrajero1.jpg" alt="...">
                                    </div>
                                    <div class="carousel-item">
                                        <img class="d-inline img-fluid" src="recursos/imagenes/cortinas.jpg" alt="...">
                                    </div>
                                    <div class="carousel-item">
                                        <img class="d-inline img-fluid" src="recursos/imagenes/climatizacion.jpg" alt="..." ">
                                    </div>
                                    <div class=" carousel-item">
                                        <img class="d-inline img-fluid" src="recursos/imagenes/deco.jpg" alt="...">
                                    </div>
                                </div>
                            </div>

                        </div>


                    </div>




                    <br><br>
                </div>


                <div class="container-fluid" style="background-color: #FFF5E4;">
                    <div class="container pt-4 pb-4">
                        <h6 style="width:100%; text-align: center;">¿Como funciona?</h6>
                    </div>


                    <div class="container-fluid p-4 mb-4 d-flex justify-content-center">


                        <div class="row row-cols-auto justify-content-center ">



                            <div class="col m-4">
                                <div class="row p-3 border border-gray border-1 rounded-3 shadow bg-body rounded" style="width: 20rem; margin: 5px;">
                                    <img class="rounded mx-auto d-block" src="recursos/imagenes/i-busca.svg" style="width: 150px; height: 170px;">
                                    <div>
                                        <p>1. Busca</p>
                                    </div>
                                    <div>
                                        <p>Cuéntanos qué te gustaría hacer y dónde</p>
                                    </div>
                                </div>
                            </div>


                            <div class="col m-4">
                                <div class="row p-3 border border-gray border-1 rounded-3 shadow bg-body rounded" style="width: 20rem; margin: 5px;">
                                    <img class="rounded mx-auto d-block" src="recursos/imagenes/i-elige.svg" style="width: 150px; height: 170px;">
                                    <div>
                                        <p>2. Elige</p>
                                    </div>
                                    <div>
                                        <p>Elige al profesional que se adapte a tus necesidades</p>
                                    </div>
                                </div>
                            </div>


                            <div class="col m-4">
                                <div class="row p-3 border border-gray border-1 rounded-3 shadow bg-body rounded" style="width: 20rem; margin: 5px;">
                                    <img class="rounded mx-auto d-block" src="recursos/imagenes/i-contacta.svg" style="width: 150px; height: 170px;">
                                    <div>
                                        <p>3. Contacta</p>
                                    </div>
                                    <div>
                                        <p>Chatea con tu profesional y reserva tu cita</p>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <div id="conEstilo" class="container-fluid">
                    <div class="container  pt-4 pb-4">
                        <h6 style="text-shadow: #000000 1px 1px 1px;text-align: center; font-family: calendas; font-size:2.8rem; color:#FFFFFB; padding-top:2rem">
                            Servicios destacados </h6>
                    </div>


                    <div class="container-fluid  pt-4 pb-4 mb-4 d-flex justify-content-center">
                        <div class="row row-cols-auto justify-content-center">

                            <div class="col">
                                <div class="row border border-gray border-1 rounded-3 shadow bg-body rounded" style="width: 20rem; margin: 5px;">
                                    <div class="row m-2">
                                        <div class="col pt-1  ">
                                            <i class="fa-solid fa-hammer"></i>
                                        </div>
                                        <div class="col">
                                            <p>sdf</p>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="col">
                                <div class="row border border-gray border-1 rounded-3 shadow bg-body rounded" style="width: 20rem; margin: 5px;">
                                    <div class="row m-2">
                                        <div class="col pt-1  ">
                                            <i class="fa-solid fa-hammer"></i>
                                        </div>
                                        <div class="col">
                                            <p>sdf</p>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col">
                                <div class="row border border-gray border-1 rounded-3 shadow bg-body rounded" style="width: 20rem; margin: 5px;">
                                    <div class="row m-2">
                                        <div class="col pt-1  ">
                                            <i class="fa-solid fa-hammer"></i>
                                        </div>
                                        <div class="col">
                                            <p>sdf</p>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col">
                                <div class="row border border-gray border-1 rounded-3 shadow bg-body rounded" style="width: 20rem; margin: 5px;">
                                    <div class="row m-2">
                                        <div class="col pt-1  ">
                                            <i class="fa-solid fa-hammer"></i>
                                        </div>
                                        <div class="col">
                                            <p>sdf</p>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col">
                                <div class="row border border-gray border-1 rounded-3 shadow bg-body rounded" style="width: 20rem; margin: 5px;">
                                    <div class="row m-2">
                                        <div class="col pt-1  ">
                                            <i class="fa-solid fa-hammer"></i>
                                        </div>
                                        <div class="col">
                                            <p>sdf</p>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col">
                                <div class="row border border-gray border-1 rounded-3 shadow bg-body rounded" style="width: 20rem; margin: 5px;">
                                    <div class="row m-2">
                                        <div class="col pt-1  ">
                                            <i class="fa-solid fa-hammer"></i>
                                        </div>
                                        <div class="col">
                                            <p>sdf</p>
                                        </div>
                                    </div>
                                </div>
                            </div>



                        </div>
                    </div>
                </div>
            </body>



            <footer class="bg-success ">
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

    </body>

    <script src="./recursos/lb/js/bootstrap.min.js"></script>

</html>


















<section class="container" style="width: 90%">
    <!-- SECCION DEL BUSCADOR-->
    <br><br><br><br><br><br>
    <form action="usuario?accion=buscarServicio" method="post" class="form-registro" role="form">
        <div class="row" style="height: 320px ; padding-left: 14em;">
            <div class="col mb-3">

                <label for="exampleInputEmail1" class="form-label ">¿Qué servicio buscas?</label>
                <input type="text" class="form-control" name="servicio" id="servicio">

            </div>

            <div class="col mb-3">

                <div class="contenedor-btn">
                    <input type="submit" name="enviar" value="Enviar" class="btn-send bg-primary">

                </div> 
            </div>
        </div>

    </form>

</section>






<a href="administrador?accion=registro" class="btn btn-success">Registro</a>
<a href="administrador?accion=verUsuarios" class="btn btn-success">Listar Usuarios</a>
<a href="administrador?accion=verProfesionales" class="btn btn-success">Listar Profesionales</a>
<a href="administrador?accion=verDirecciones" class="btn btn-success">Listar Direcciones</a>
<!-- carousel -->


<div class="  bg-light" style="width: 100%;">
    <br><br>
    <div class="container text-center my-3">
        <h2 class="font-weight-light">Novedades</h2>
        <div class="row my-auto justify-content-center">
            <div id="recipeCarousel" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner" style="width: 100%;" role="listbox">

                    <div class="carousel-item active">
                        <div class="col-md-3">
                            <div class="card">
                                <div class="card-img">
                                    <img src="imagenes/img1.jpg" class="img-fluid" alt="">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="carousel-item">
                        <div class="col-md-3">
                            <div class="card">
                                <div class="card-img">
                                    <img src="imagenes/img1.jpg" class="img-fluid" alt="">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="carousel-item">
                        <div class="col-md-3">
                            <div class="card">
                                <div class="card-img">
                                    <img src="imagenes/img1.jpg" class="img-fluid" alt="">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="carousel-item">
                        <div class="col-md-3">
                            <div class="card">
                                <div class="card-img">
                                    <img src="imagenes/img1.jpg" class="img-fluid" alt="">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="carousel-item">
                        <div class="col-md-3">
                            <div class="card">
                                <div class="card-img">
                                    <img src="imagenes/img1.jpg" class="img-fluid" alt="">
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <a class="carousel-control-prev bg-transparent w-aut" href="#recipeCarousel" role="button"
                   data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                </a>
                <a class="carousel-control-next bg-transparent w-aut" href="#recipeCarousel" role="button"
                   data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                </a>
            </div>
        </div>
        <h5 class="mt-2 fw-light">Servicios </h5>
    </div>
    <br><br>
</div>

<br><br><br>


</main>
<jsp:include page="footer.jsp" />
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


</body>


</html>