<%@page import="java.util.Set"%>
<%@page import="domain.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_ES" />
<!DOCTYPE html>
<%
    Usuario correo = (Usuario) session.getAttribute("email");

    // session.setAttribute("correo", correo.getEmail());
    if (correo != null) {
        System.out.println("correo desde el header " + correo);
    } else {
        System.out.println("no tienes corre");
    }
%>

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



        <div class="container-fluid  " style="width: 100%; padding-top:2rem; ">
            <div class="row row-cols-auto d-flex justify-content-center" style="width:100%;  ">


                <div class="col" style="margin-left:6px;; width:20%;padding-top:2rem; ">
                    <c:forEach var="resultado" items="${contratos}" varStatus="status">
                        <div class="col m-2">
                            <div class="row border border-gray border-1 shadow bg-body">
                                <div class="row">
                                    <div class="col  ">
                                        <img src="./recursos/imagenes/pintorTarjeta.png" >
                                    </div>
                                    <div class="col">
                                        <p >${resultado.ofreceidOfrece.usuarioEmail.email}</p>
                                        <p >${resultado.ofreceidOfrece.servicioidServicio.nombre}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>


                <div class="col" style="margin-left:6px; padding-bottom: 2rem; width: 50%; padding-top:2rem; ">
                    <div class="card " style="border-radius:3%;">
                        <div class="card-header " style="border-radius:2rem; margin-top:1px;" >
                            Chat
                        </div>
                        <div class="card-body" >
                            <p>mensajes aca</p>
                            <p>mensajes aca</p>
                            <p>mensajes aca</p>
                            <p>mensajes aca</p>
                            <p>mensajes aca</p>
                            <p>mensajes aca</p>
                            <p>mensajes aca</p>
                            <p>mensajes aca</p>
                            <p>mensajes aca</p>
                            <p>mensajes aca</p>
                            <p>mensajes aca</p>
                        </div>
                        <div class="card-footer" style="border-radius:1rem; margin-top:1px;">
                            <form class="overflow-auto">
                                <div class="form-group " >
                                    <label for="mensaje">Mensaje</label>
                                    <input type="text" class="form-control" id="mensaje" />
                                </div>
                                <button type="submit" class="btn btn-success float-end">Enviar</button>
                            </form>
                        </div>
                    </div>
                </div>
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