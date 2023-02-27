<%@page import="domain.Usuario"%>
<%@page import="domain.Ofrece"%>
<%@page import="java.util.List"%>
<%@page import="web.imagen"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.Base64"%>
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



<%
     List<Usuario>  serv = (List<Usuario>) session.getAttribute("servicios");
 
    %>





    <body>
       

        <div class="container  d-flex" >
                        
            <div class="row row-cols-auto">

                <c:forEach var="servicio" items="${servicios}" varStatus="status">

                    <div class="row border border-gray border-1 rounded-3 shadow bg-body rounded" style="width: 22rem; margin:5px">
                        <div class="col mt-2 ">
                  
                           
                            <div class="row">
                                <div class="col mt-2 ml-2">
                                    <p>${servicio.nombreEmpresa}</p>
                                    <p>${servicio.descripcionEmpresa}</p>
                                </div>
                            </div>
                        </div>

                        <div class="col mt-2 pt-4" >
                            <!-- <?php echo "<img style='margin-left:40px;' src='" . $result->imagen . "' width='120' height='100'>" . "</img>"; ?>-->
                            <img th:src="@{'data:image/jpeg;base64,''..base64_encode${servicio.imagen}.'}">
                           <!--  <img height="100" width="80" src="data:image/jpeg;base64,'.base64_encode<%//${servicio.usuarioEmail.imagen}%>.'" class="card-img-top" alt="..." />-->
                        </div>

                        <div class="row m-0">

                            <div class="col mb-2 mt-1">
                                <p style=" width: 99% ;color: #78BE20; font-weight: 600;font-style: normal;text-align: center;padding-top: 7px;">
                                    Ver ficha completa</p>
                                <a href="" style=" width: 100% ;background-color:#78BE20; color: #fff; font-weight: 600;font-style: normal;" class=" btn mb-4" data-toggle="modal" data-target="#modalLogin" >Nuevo Chat</a>

                            </div>

                        </div>







                    </div>
                  

                </c:forEach> 
            </div>

        </div>

    </div>



    <jsp:include page="footer.jsp" />
    <img src="WEB-INF/recursos/img1.jpg" alt=""/>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


</html>
