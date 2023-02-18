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
    <body>



        <section id="usuarios">
            <div class="container">
                <div class="row">
                    <div class="col-md-9">
                        <div class="card-header">
                            <h4>Listado Clientes</h4>
                        </div>
                        <table class="table table-striped">
                            <thead class="thead-dark">
                                <tr>
                                    
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Email</th>
                                    <th>Telefono</th>
                                    <th>Fecha Alta</th>
                                    <th>Contraseña</th>
                                    <th>Rol</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="usuario" items="${usuarios}" varStatus="status">
                                    <tr>
                                       
                                        <td>${usuario.nombre}</td>
                                        <td> ${usuario.apellido}</td>
                                        <td> ${usuario.email}</td>
                                        <td> ${usuario.telefono}</td>
                                        <td> ${usuario.fechaAlta}</td>
                                        <td> ${usuario.contrasena}</td>
                                        <td> ${usuario.rolesidRol}</td>
                                     
                                        <td>
                                            <a href="administrador?accion=editar&id=${usuario.email}" class="btn btn- btn-warning">
                                                <i class="fas fa-angle-double-right"></i> Editar
                                            </a>
                                        </td>
                                         <td>
                                            <a href="administrador?accion=eliminar&id=${usuario.email}" class="btn btn- btn-danger">
                                                <i class="fas fa-angle-double-right"></i> Eliminar
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
        <img src="WEB-INF/recursos/img1.jpg" alt=""/>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>
