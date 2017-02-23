/**
 * 
 */
function validacion(){
	
	var nombre = document.getElementById('txtUsuario').value;
	
	if( nombre == null || nombre.length == 0 || /^\s+$/.test(nombre)){
		alert("Nombre es campo obligatorio");
		return false;
	}
}