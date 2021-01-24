/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function session(id){
  if (id=="admin"){
    window.open("./RRHH/iniciarSesionRRHH.jsp");
    window.close("./index.html");
  } else {
    window.open("./Trabajador/iniciarSesionUser.jsp");
    window.close("./index.html");
  }

}

function iniciarSesion() {
  usuario = document.getElementById("idUser").value;
  password = document.getElementById("idPsw").value;

  if(usuario=="Admin"){
    if(password=="RRHH"){
      window.open("./annadirUser.jsp");
      window.close("./iniciarSesionRRHH.jsp");
    }else{
      window.alert("La contraseña no es válida");
    }
  }
  else if (usuario=="Pruebas"){
    if(password=="Pruebas"){
      window.open("./fichar.jsp");
      window.close("./iniciarSesionUser.jsp");
    }else{
      window.alert("La contraseña no es válida");
    }
  }else{
    window.alert("Ese usuario no existe");
  }
}

