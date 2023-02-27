function validar(){
    var email, clave,expresion;
   const correo= false;
   const contra = false;
    email=document.getElementById("email").value;
    clave=document.getElementById("contrasena").value;
 
    //para validar el correo
    expresion=/^([\da-z_\.-]+)@([\da-z.-]+)\.([a-zA-Z\.]{2,6})+$/;

    if(email===""||clave===""){
        alert("Todos los campos son obligatorios");
        return false;
    }
    
    if(!expresion.test(email)){
        alert("Correo no válido");
        return false;
    }else{
        correo = true;
    }


    if(clave.length>100){
        alert("La clave tienen como maximo 100 caracteres");
        return false;
    }else{
        contra = true;
    }
    
    if(contra==true&&correo==true){
        
        alert('Registrado correctamente');
    }else{
        alert('Error');
    }
    
   
   }