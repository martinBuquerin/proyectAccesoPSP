

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../recursos/fontAw/css/all.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>          

    </head>
  
  <a href="#" style=" width: 100% ;background-color:#78BE20; color: #fff; font-weight: 600;font-style: normal;"
            class=" btn" data-toggle="modal" data-target="#myModal">Nuevo Chat</a>

  <!--modal-dialog modal-dialog-centered-->
  <div class="modal fade" id="myModal">
    <div class="modal-dialog modal-dialog-centered modal-xl">

      <!-- Modal content-->
      <div class="modal-content">
        <br><br>
        <br>
        <hr><br>
        <div class="modal-body">
          <h4 class="modal-title" style="text-align: center;">Login</h4>
          <form>
            <div class="mb-3">
              <label for="exampleInputEmail1" class="form-label">Usuario</label>
              <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">

            </div>
            <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">Contraseña</label>
              <input type="password" class="form-control" id="exampleInputPassword1">
            </div>
            <div class="d-flex justify-content-center align-content-center ">
              <button type="submit" class="btn btn-primary">Entrar</button>
            </div>
          </form>
          <br>
          <hr>
          <br>
          <h4 class="modal-title" style="text-align: center;">Registrarse</h4>
          <form>
            <div class="mb-3">
              <label for="exampleInputEmail1" class="form-label">Usuario</label>
              <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">

            </div>
            <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">Contraseña</label>
              <input type="password" class="form-control" id="exampleInputPassword1">
            </div>
            <div class="d-flex justify-content-center align-content-center ">
              <button type="submit" class="btn btn-primary">Registrarse</button>
            </div>
          </form>
          <br>

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
        </div>
      </div>

    </div>
  </div>
           
</html>