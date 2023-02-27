<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="es_ES" />

<!DOCTYPE html>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
<link rel="stylesheet" href="estilo.css">
<link rel="stylesheet" href="https://kit.fontawesome.com/c6b31a7173.css" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<title>miWeB.</title>
<%
    String correo = (String) session.getAttribute("email");

    if (correo != null) {
        System.out.println("correo desde el header " + correo);
    } else {
        System.out.println("no tienes corre");
    }


%> 



<button type="button" id="logIn" class="btn btn-success btn-primary-outline-success" data-toggle="modal" data-target="#modalRegistroCliente"><i class="far fa-user" style="padding-right:4px;"></i>Identifícate</button>

<div class="modal fade" id="modalRegistroCliente" tabindex="-1" role="dialog" style="margin-top:9em;  "aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog">

        <div class="modal-content d-flex justify-content-center">

            <div class="row">
                <div class="col pt-4" style="padding-left:200px;">

                    <h1 class="p-2 fs-2 text-center">Bienvenido <%=correo%></h1>
                </div>
                <div class="col" style="width:150px;">
                    <button type="submit" class="btn btn-danger p-1 float-end px-3 m-2" data-dismiss="modal"  name="salir" >x</button>
                </div>
            </div>
            <div class="modal-body p-2 ">
                

           
                    <div class="col text-center p-2 mt-2">

                        <button type="submit" class="btn btn-success mb-3" name="enviar" value="Enviar"  >Editar Perfil</button>

                    </div>
                  <div class="col text-center p-2 mt-2">

                        <button type="submit" class="btn btn-success mb-3" name="enviar" value="Enviar"  >Ver Chats</button>

                    </div>
       
       
            </div>
            <!--<a href="administrador.php" class="btn btn-success float-end" style="margin:1rem;">Volver</a>-->
        </div>
    </div>

</div>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="validacionRegistro.js"></script>