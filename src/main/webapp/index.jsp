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
        <title>Document</title>



        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>

    <body>
        <jsp:include page="header.jsp" />

        <main>

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