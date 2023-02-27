
<%@page import="domain.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_ES" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Proyecto AccesoDatos PSP</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="estilo.css">
        <link rel="stylesheet" href="https://kit.fontawesome.com/c6b31a7173.css" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
        <jsp:include page="header.jsp" />

        <main>

            <body>

                <div class="container-flud">

                    <%
                        Usuario usuarioCreado = (Usuario) session.getAttribute("usuario");

                        if (usuarioCreado != null) {
                            System.out.println("correo desde el header " + usuarioCreado);
                        } else {
                            System.out.println("no tienes corre");
                        }

                        if (usuarioCreado != null && usuarioCreado.getRolesidRol().getNombre().equals("Profesional")) {
                    %> 


                    <c:set var="usuario" value="${usuario}" />

                    <form action="administrador?accion=enviarUpdate&id=${usuario.email}" method="post" class="form-registro " enctype="multipart/form-data" style="margin-left: 12rem; margin-bottom: 5rem;">
                        <div class="row  justify-content-center pt-5">

                            <div class="col-lg-6 text-end">
                                 <div class="col-lg-9" >
                                    <a href="index.jsp" class="btn btn-danger p-1 float-end px-3 m-2"  name="salir" >x</a>
                                </div>
                                <div class="card  w-75 mb-3">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Nombre</h6>
                                            </div>
                                            <div class="col-lg-8 text-secondary">
                                                <input type="text" class="form-control" id="nombreEditado" name="nombreEditado"  value="<c:out value="${usuario.nombre}"/>">
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Apellido</h6>
                                            </div>
                                            <div class="col-lg-8 text-secondary">
                                                <input type="text" class="form-control" id="nombreEditado" name="apellidoEditado"  value="<c:out value="${usuario.apellido}"/>">
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Correo</h6>
                                            </div>
                                            <div class="col-lg-8 text-secondary">
                                                <input type="text" class="form-control" id="nombreEditado" name="correoEditado"  value="<c:out value="${usuario.email}"/>">
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Contraseña</h6>
                                            </div>
                                            <div class="col-lg-8 text-secondary">
                                                <input type="password" class="form-control" id="contrasenaEditado" name="contrasenaEditado"  value="<c:out value="${usuario.contrasena}"/>">
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Telefono</h6>
                                            </div>
                                            <div class="col-lg-8 text-secondary">
                                                <input type="text" class="form-control" id="nombreEditado" name="telefonoEditado"  value="<c:out value="${usuario.telefono}"/>">
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Nombre empresa</h6>
                                            </div>
                                            <div class="col-lg-8 text-secondary">
                                                <input type="text" class="form-control" id="nombreEditado" name="nombreEmpresaEditado"  value="<c:out value="${usuario.nombreEmpresa}"/>">
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Descripción empresa</h6>
                                            </div>
                                            <div class="col-lg-8 text-secondary">

                                                <input type="text" class="form-control" id="nombreEditado" name="descripcionEmpresaEditado"  value=" <c:out value="${usuario.descripcionEmpresa}"/>">
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Imagen</h6>
                                            </div>
                                            <div class="col-lg-8 text-secondary">
                                                <input type="file" name="foto"><br>
                                            </div>
                                        </div>
                                        <hr>

                                    </div>
                                    <div class="row m-2 ">
                                        <div class="col-sm-12">
                                            <button type="submit" class="btn btn-success btn-lg float-end" id="editar" name="editar">Editar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>

                    <%
                    } else if (usuarioCreado != null && usuarioCreado.getRolesidRol().getNombre().equals("Cliente") || usuarioCreado.getRolesidRol().getNombre().equals("Administrador")) {


                    %> 
                    <c:set var="usuario" value="${usuario}" />

                    <form action="administrador?accion=enviarUpdate&id=${usuario.email}" method="post" class="form-registro " enctype="multipart/form-data" style="margin-left: 12rem; margin-bottom: 5rem;">
                        <div class="row  justify-content-center pt-5">

                            <div class="col-lg-6 text-end">
                                <div class="col-lg-9" >
                                    <a href="index.jsp" class="btn btn-danger p-1 float-end px-3 m-2"  name="salir" >x</a>
                                </div>
                                <div class="card  w-75 mb-3">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Nombre</h6>
                                            </div>
                                            <div class="col-lg-8 text-secondary">
                                                <input type="text" class="form-control" id="nombreEditado" name="nombreEditado"  value="<c:out value="${usuario.nombre}"/>">
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Apellido</h6>
                                            </div>
                                            <div class="col-lg-8 text-secondary">
                                                <input type="text" class="form-control" id="nombreEditado" name="apellidoEditado"  value="<c:out value="${usuario.apellido}"/>">
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Correo</h6>
                                            </div>
                                            <div class="col-lg-8 text-secondary">
                                                <input type="text" class="form-control" id="nombreEditado" name="correoEditado"  value="<c:out value="${usuario.email}"/>">
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Contraseña</h6>
                                            </div>
                                            <div class="col-lg-8 text-secondary">
                                                <input type="password" class="form-control" id="contrasenaEditado" name="contrasenaEditado"  value="<c:out value="${usuario.contrasena}"/>">
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Telefono</h6>
                                            </div>
                                            <div class="col-lg-8 text-secondary">
                                                <input type="text" class="form-control" id="nombreEditado" name="telefonoEditado"  value="<c:out value="${usuario.telefono}"/>">
                                            </div>
                                        </div>
                                        <hr>

                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Imagen</h6>
                                            </div>
                                            <div class="col-lg-8 text-secondary">
                                                <input type="file" name="foto"><br>
                                            </div>
                                        </div>
                                        <hr>

                                    </div>
                                    <div class="row m-2 ">
                                        <div class="col-sm-12">
                                            <button type="submit" class="btn btn-success btn-lg float-end" id="editar" name="editar">Editar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <%                 }
                    %> 
                </div>
                </div>

                <jsp:include page="footer.jsp" />
                <script src="https://unpkg.com/typewriter-effect@latest/dist/core.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
                <script src="https://kit.fontawesome.com/c6b31a7173.js" crossorigin="anonymous"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
                <script src="javaType.js"></script>
            </body>

</html>