const express = require('express');
const path = require('path');
const bodyParser = require('body-parser')
const app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:false}));
app.use(express.static(path.join(__dirname,'public')));
app.use(express.static('public'));
app.use(express.static('files'));
const http = require("http");
//-------------------validar que no haya errores----------------------
/* let x=10;
const p=new Promise((resolve,reject)=>{
	if (x==10){
		resolve("La varible es igual a 10")
	}
	else{
		reject("La variable no es igual a 10")
	}
});
p
.then(res=> {
	console.log("Sucess: "+res);}
)
.catch(error=>{
	console.log("Error: "+error)
}); */

let telefonos=[{id:1,telefono:4478186},{id:2,telefono:1818484}];
let usuarios=[{id:1,nombre:"Marcos"},{id:2,nombre:"Favios"}];

//funciones promesas
const obtenerUsuario = id => {
	return new Promise ((resolve,reject)=>
	{
	if (usuarios.find(usuario => usuario.id===id))
		{console.log("el usuario existe")
		resolve(obtenerTelefono(id));}
	else
		reject("El usuario no existe");
	}
	);
	
};
const obtenerTelefono = id => {
	return new Promise ((resolve,reject)=>
	{
	if (telefonos.find(telefonos => telefonos.id===id))
		resolve("el telefono existe");
	else
		reject("El telefono no existe");
	}
	);
};

//hacer que estas dos vayan una tras de otra
obtenerUsuario(1)
	.then(res=>{
		return (res);
	})
	.then (mensaje=>{
		console.log(mensaje)
	})
	.catch(error=>{
		console.log(error);
	});



app.listen(3000,() => {
        console.log('Servidor Inicia puerto 3000');
})
module.exports=app;