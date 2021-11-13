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

app.get('/find',(req,resp) => { 
    http
    .get("http://localhost:8080/api/tutorials", (resp) => {
      let data = "";
      // A chunk of data has been recieved. Append it with the previously retrieved chunk of data
      resp.on("data", (chunk) => {
        data += chunk;
      });
  
      // when the whole response is received, parse the result and Print it in the console
      resp.on("end", () => {
        console.log(JSON.parse(data));
      });
    })
    .on("error", (err) => {
      console.log("Error: " + err.message);
    });
  });

 
  app.post('/save',(req,res) => { 
      console.log('body: ',req.body);
    const {title,description} =req.body;
    const data = JSON.stringify({
        description: description,
        title: title,
      });
    
    const options = {
        host: "localhost",
        port: 8080,
        path: "/api/tutorials",
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
});


app.post('/registroprod',(req,res) => { 
 
/* const fs = require('fs')
fs.readFile(req, 'utf8' , (err, data) => {
  if (err) {
    console.error(err)
    return
  }
  console.log(data)
}); */

	  console.log('body: ',req.body);
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
});
app.listen(3000,() => {
        console.log('Servidor Inicia puerto 3000');
})
module.exports=app;