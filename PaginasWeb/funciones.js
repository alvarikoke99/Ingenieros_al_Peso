function annadirUsuario() {
    var table = document.getElementById("tabla");
    var row = table.insertRow(0);
    var id = row.insertCell(0);
    var nombre = row.insertCell(1);
    var apellido = row.insertCell(2);
    var departamento = row.insertCell(3);
    var editar = row.insertCell(4);
    var eliminar = row.insertCell(5);
    id.innerHTML = "id";
    nombre.innerHTML = "nombre";
    apellido.innerHTML = "apellido";
    departamento.innerHTML = "departamento";
    editar.innerHTML = "editar";
    eliminar.innerHTML = "eliminar";
}

function session(id){
  if (id=="admin"){
    window.open("./iniciarSesionRRHH.html");
    window.close("./index.html");
  } else {
    window.open("./iniciarSesionUser.html");
    window.close("./index.html");
  }

}

function iniciarSesion() {
  usuario = document.getElementById("idUser").value;
  password = document.getElementById("idPsw").value;

  if(usuario=="Admin"){
    if(password=="RRHH"){
      window.open("./listaUsuario.html");
      window.close("./iniciarSesionRRHH.html");
    }else{
      window.alert("La contraseña no es válida");
    }
  }
  else if (usuario=="Pruebas"){
    if(password=="Pruebas"){
      window.open("./fichar.html");
      window.close("./iniciarSesionUser.html");
    }else{
      window.alert("La contraseña no es válida");
    }
  }else{
    window.alert("Ese usuario no existe");
  }
}

function fichar(elem) {
  if (elem = "e") {
    
  } else {

  }
}

function solicitarInforme() {
  if(document.getElementById("empresa").checked){

  }else if(document.getElementById("proyecto").checked){

  }else if(document.getElementById("empleado").checked){

  }else if(document.getElementById("semanal").checked){

  }else if(document.getElementById("mensual").checked){

  }else if(document.getElementById("anual").checked){

  }else {
    
  }
}