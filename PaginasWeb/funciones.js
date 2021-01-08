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

function iniciarSesion() {
  usuario = document.getElementById("idUser").value;
  password = document.getElementById("idPsw").value;

  if(usuario=="Admin"){
    if(password=="RRHH"){
      window.open("./listaUsuario.html");
      window.close("./iniciarSesion.html");
    }else{
      window.alert("La contraseña no es válida");
    }
  }
  else if (usuario=="Pruebas"){
    if(password=="Pruebas"){
      window.open("./user.html");
      window.close("./iniciarSesion.html");
    }else{
      window.alert("La contraseña no es válida");
    }
  }else{
    window.alert("Ese usuario no existe");
  }
}