const express = require('express');
const path = require('path');
const bodyParser = require('body-parser')
const app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, 'public')));
app.use(express.static('public'));
app.use(express.static('files'));
const http = require("http");
const multer = require("multer");
const mimeTypes = require("mime-types");




app.post('/registroprod',(req, res, next) => {

	async function CargarArchivo() {
		let formData = new FormData();
		formData.append("file", req);
		let response = await
		fetch('/api/productos', {
			method : "POST",
			body : formData
		});
		if (response.status == 200) {
			var myDiv = document.getElementById("dvTabla");
			myDiv.innerHTML = "<b>DOC enviado</b>";
		}
	}



});




app.listen(3000, () => {
	console.log('Servidor Inicia puerto 3010');
	console.log("inicion");
	console.log("inicion");
	console.log("inicion");console.log("inicion");console.log("inicion");
})
module.exports = app;