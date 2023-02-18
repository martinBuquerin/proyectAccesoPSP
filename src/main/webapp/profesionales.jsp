<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="es_ES" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/5c465338f1.js" crossorigin="anonymous"></script> 
        <title>JSP Page</title>
    </head>
    <body>
        <section id="profesionales">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card-header">
                            <h4>Listado Profesionales</h4>
                        </div>
                        <div class="container  d-flex" >
                            <c:forEach var="profesionales" items="${profesionales}" varStatus="status">
                               
                                      
                                <div class="row border border-gray border-1 rounded-3 shadow bg-body rounded" style="width: 26rem; margin:5px">
                                    <div class="col mt-1">
                                        <h5 class="card-title">${profesionales.nombreEmpresa}</h5>
                                        <div class="row">
                                            <div class="col mt-1 ml-2">
                                                <p>${profesionales.descripcionEmpresa}</p>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col mt-2">
                                        <img src="recursos/imagenes/5059.jpg" class="card-img-top" alt="...">
                                    </div>

                                    <div class="row m-0">

                                        <div class="col mb-2 mt-1">
                                            <p
                                                style=" width: 99% ;color: #78BE20; font-weight: 600;font-style: normal;text-align: center;padding-top: 7px;">
                                                Ver ficha completa</p>
                                            <a href="#" style=" width: 100% ;background-color:#78BE20; color: #fff; font-weight: 600;font-style: normal;"
                                               class=" btn" data-toggle="modal" data-target="#myModal">Nuevo Chat</a>

                                        </div>
                                    </div>

                                </div>


                            </c:forEach> 
                        </div>
                        <a href="index.jsp" class="btn btn-secondary">
                            <i class="fas fa-angle-double-right"></i> Inicio
                        </a>

                    </div>
                </div>
            </div>
                        </section>

                        </body>
                        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
                        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
                        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

                        </html>
