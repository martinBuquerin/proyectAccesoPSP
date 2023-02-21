<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_ES" />
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




        <div class="container-fluid m-4 d-flex justify-content-center">
            <div class="row row-cols-auto justify-content-center m-4">

                <c:forEach var="resultado" items="${profesionales}" varStatus="status">



                    <div class="row border border-gray border-1 rounded-3 shadow bg-body rounded" style="width: 22rem; margin:5px">
                        <div class="col mt-2">
                            <h5 class="card-title pt-4">${resultado.nombreEmpresa}</h5>
                            <div class="row">
                                <div class="col mt-2 ml-2">
                                    <p>${resultado.descripcionEmpresa}</p>
                                </div>
                            </div>
                        </div>

                        <div class="col mt-2 pt-4" >
                            <!-- <?php echo "<img style='margin-left:40px;' src='" . $result->imagen . "' width='120' height='100'>" . "</img>"; ?>-->
                         <img height="100" width="80" src="data:image/jpeg;base64,'.base64_encode${resultado.imagen}.'" class="card-img-top" alt="..." />
                        </div>

                        <div class="row m-0">

                            <div class="col mb-2 mt-1">
                                <p style=" width: 99% ;color: #78BE20; font-weight: 600;font-style: normal;text-align: center;padding-top: 7px;">
                                    Ver ficha completa</p>
                                <a href="#" style=" width: 100% ;background-color:#78BE20; color: #fff; font-weight: 600;font-style: normal;" class=" btn mb-4" data-toggle="modal" data-target="#myModal">Nuevo Chat</a>

                            </div>

                        </div>







                    </div>

                </c:forEach> 



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