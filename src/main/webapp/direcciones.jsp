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
        <section id="direcciones">
            <div class="container">
                <div class="row">
                    <div class="col-md-9">
                        <div class="card-header">
                            <h4>Listado Profesionales</h4>
                        </div>
                        <table class="table table-striped">
                            <thead class="thead-dark">
                                <tr>

                                    <th>iD</th>
                                    <th>Calle</th>
                                    <th>Numero</th>
                                    <th>Piso</th>
                                    <th>Cp</th>
                                    <th>Localidad</th>
                                    <th>Provincia</th>
                                    <th>Pais</th>

                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="direcciones" items="${direcciones}" varStatus="status">
                                    <tr>
                                        <td>${direcciones.idDireccion}</td>
                                        <td>${direcciones.calle}</td>
                                        <td>${direcciones.numero}</td>
                                        <td>${direcciones.piso}</td>
                                        <td>${direcciones.cp}</td>
                                        <td>${direcciones.localidad}</td>
                                        <td>${direcciones.provincia}</td>
                                        <td>${direcciones.pais}</td>
                                        <td>${direcciones.usuarioEmail}</td>

                                        <td>
                                            <a href="" class="btn btn-secondary">
                                                <i class="fas fa-angle-double-right"></i> Editar
                                            </a>
                                        </td>
                                    </tr> 
                                </c:forEach> 
                            </tbody>
                        </table>
                    </div>
                    <td>
                        <a href="index.jsp" class="btn btn-secondary">
                            <i class="fas fa-angle-double-right"></i> Inicio
                        </a>
                    </td>

                </div>
            </div>
        </section>

    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</html>
