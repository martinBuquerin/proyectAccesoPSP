<%@page import="domain.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_ES" />
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/5c465338f1.js" crossorigin="anonymous"></script> 

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>

    <body>
        <jsp:include page="header.jsp" />

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
            <div class="container-fluid w-50 mt-5" >
                <p class="text-center fs-2 fw-bold pb-4">Edici�n de perfil</p>

                <form action="administrador?accion=enviarUpdate&id=${usuario.email}" method="post" class="form-registro" enctype="multipart/form-data" class="d-flex w-50 ">
                    <div class="row">
                        <div class="col">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control w-50" id="nombreEditado" name="nombreEditado"  value="<c:out value="${usuario.nombre}"/>">

                            <label for="apellido">Apellido</label>
                            <input type="text" class="form-control w-50" id="apellidoEditado" name="apellidoEditado" placeholder="Apellidos" value="<c:out value="${usuario.apellido}"/>">


                            <label for="email">Email</label>
                            <input type="text" class="form-control w-50" id="correoEditado" name="correoEditado" placeholder="Email" value="<c:out value="${usuario.email}"/>">

                            <label for="telefono">Telefono</label>
                            <input type="text" class="form-control w-50" id="telefonoEditado" name="telefonoEditado" placeholder="Telefono" value="<c:out value="${usuario.telefono}"/>">
                        </div>
                        <div class="col">

                            <label for="contrasena">Contrase�a</label>
                            <input type="password" class="form-control w-50" id="contrasenaEditado" name="contrasenaEditado" placeholder="Contrase�a" value="<c:out value="${usuario.contrasena}"/>">


                            <label for="nombreEmpresa">Nombre de la empresa</label>
                            <input type="text" class="form-control w-50" id="nombreEmpresaEditado" name="nombreEmpresaEditado" placeholder="Nombre Empresa" value="<c:out value="${usuario.nombreEmpresa}"/>">

                            <label for="descripcionEmpresa">Descripci�n de la empresa</label>
                            <input type="text" class="form-control w-50" id="descripcionEmpresaEditado" name="descripcionEditado" placeholder="Descripcion Empresa" value="<c:out value="${usuario.descripcionEmpresa}"/>">


                            <label>Imagen</label>
                            <input type="file" name="foto"><br>
                        </div>



                    </div>

                    <div class="col text-center p-2 mt-2 mb-4">
                        <input type="hidden" id="id2" name="id2" value="${email}">
                        <button type="submit" class="btn btn-success btn-lg" id="editar" name="editar">Editar</button>
                    </div>
                </form>
            </div>

        <%
            }else if (usuarioCreado != null && usuarioCreado.getRolesidRol().getNombre().equals("Cliente")){


        %> 
              <c:set var="usuario" value="${usuario}" />
            <div class="container-fluid w-50 mt-5" >
                <p class="text-center fs-2 fw-bold pb-4">Edici�n de perfil</p>

                <form action="administrador?accion=enviarUpdate&id=${usuario.email}" method="post" class="form-registro" enctype="multipart/form-data" class="d-flex w-50 ">
                    <div class="row">
                        <div class="col">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control w-50" id="nombreEditado" name="nombreEditado"  value="<c:out value="${usuario.nombre}"/>">

                            <label for="apellido">Apellido</label>
                            <input type="text" class="form-control w-50" id="apellidoEditado" name="apellidoEditado" placeholder="Apellidos" value="<c:out value="${usuario.apellido}"/>">


                            <label for="email">Email</label>
                            <input type="text" class="form-control w-50" id="correoEditado" name="correoEditado" placeholder="Email" value="<c:out value="${usuario.email}"/>">

                            <label for="telefono">Telefono</label>
                            <input type="text" class="form-control w-50" id="telefonoEditado" name="telefonoEditado" placeholder="Telefono" value="<c:out value="${usuario.telefono}"/>">
                        </div>
                        <div class="col">

                            <label for="contrasena">Contrase�a</label>
                            <input type="password" class="form-control w-50" id="contrasenaEditado" name="contrasenaEditado" placeholder="Contrase�a" value="<c:out value="${usuario.contrasena}"/>">


                            <label>Imagen</label>
                            <input type="file" name="foto"><br>
                        </div>



                    </div>

                    <div class="col text-center p-2 mt-2 mb-4">
                        <input type="hidden" id="id2" name="id2" value="${email}">
                        <button type="submit" class="btn btn-success btn-lg" id="editar" name="editar">Editar</button>
                    </div>
                </form>
            </div>

        
             <%
           

}
        %> 

        <jsp:include page="footer.jsp" />
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>

</html>