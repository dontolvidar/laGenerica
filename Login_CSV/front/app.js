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
const cors=require("cors");
const multer=require("multer");


app.use(cors());
const storage = multer.diskStorage({
	destination:'uploads/',
	filename:function (req,file,cb){
		cb("",file.originalname);
	}
});
const upload=multer({
	storage:storage
});


app.get("/enviar",(req,res)=>{
	//res.sendFile(__dirname+"/public/producto.html");
	res.send("Todo mal");
});

app.post('/enviar', upload.array('files'), function (req, res, next) {
  console.log(req.files[0]);
	// req.files is array of `photos` files
  // req.body will contain the text fields, if there were any
})

/* /* app.post('/registroprod',upload.single('files'),(req,res) => { 
 
/* const fs = require('fs')
fs.readFile(req, 'utf8' , (err, data) => {
  if (err) {
    console.error(err)
    return
  }
  console.log(data)
}); */

	 /*  console.log('body: ',req.body);
    const {codigo,nombre,nit_proveedor,precio_compra,iva,precio_venta} =req.body;
    const data = JSON.stringify({
        codigo:codigo,
		nombre:nombre,
		nit_proveedor:nit_proveedor,
		precio_compra:precio_compra,
		iva:iva,
		precio_venta:precio_venta,
		
      });
    
    const options = {
        host: "localhost",
        port: 8080,
        path: "/api/productos",
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          "Content-Length": data.length,
        },
      };
      
      
      
      req = http.request(options, (res) => {
            //status code of the request sent
            console.log("statusCode: ", res.statusCode);
            let result = "";
            // A chunk of data has been recieved. Append it with the previously retrieved chunk of data
            res.on("data", (chunk) => {
              result += chunk;
            });
            //The whole response has been received. Display it into the console.
            res.on("end", () => {
              console.log("Result is: " + result);
            });
          });
          //error if any problem with the request
          req.on("error", (err) => {
            console.log("Error: " + err.message);
          });
          //write data to request body
          req.write(data);
          //to signify the end of the request - even if there is no data being written to the request body.
          req.end();
});  */
app.listen(3000,() => {
        console.log('Servidor Inicia puerto 3001');
})
module.exports=app;