<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_ES" />
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/5c465338f1.js" crossorigin="anonymous"></script> 
        <title>Testing</title>
    </head>

    <jsp:include page="header.jsp" />









    <body>

        <div class="container  d-flex" >
            <div class="row row-cols-auto">

                <c:forEach var="usuario" items="${usuarios}" varStatus="status">
                    <div class="card m-3" style="width: 21rem;">
                        <!--<img src="..." class="card-img-top" alt="...">-->
                        <h3>${usuario.nombre} ${usuario.apellido}</h3>
                        <div class="card-body">
                            <!--<h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>-->
                            <p class="card-text"><b>Email:</b> ${usuario.email}</p>
                            <p class="card-text"><b>Teléfono:</b> ${usuario.telefono}</p>
                            <p class="card-text"><b>Fecha de alta:</b> ${usuario.fechaAlta}</p>
                            <p class="card-text"><b>Contrasena:</b> ${usuario.contrasena}</p>
                            <p class="card-text"><b>Rol:</b> ${usuario.rolesidRol.getNombre()}</p>
                        </div>
                        <div class="card-footer">
                            `<div class="row row-cols-2 justify-content-center mb-3" style="width: 18rem;">
                                <div class="col">
                                    <a href="administrador?accion=editar&id=${usuario.email}"  class="btn btn- btn-warning">
                                        <i class="fas fa-angle-double-right"></i> Editar </a>
                                </div>
                                <div class="col " >
                                    <a href="administrador?accion=eliminar&id=${usuario.email}" class="btn btn- btn-danger">
                                        <i class="fas fa-angle-double-right"></i> Eliminar </a>
                                </div>
                            </div>
                        </div>
                    </div>


                </c:forEach> 
            </div>

        </div>
        <div class="row  mb-5">

            <a href="administrador.jsp" class="btn btn-primary"> <i class="fas fa-angle-double-right"></i> Volver </a>
        </div>
    </div>



    <jsp:include page="footer.jsp" />
    <img src="WEB-INF/recursos/img1.jpg" alt=""/>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


</html>
