package co.edu.lagenerica.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ProductosController {

	@PutMapping("/producto/registrarProducto")
	public Productos registrarProducto(@RequestBody Productos p) {
		ProductosDAO dao =  new ProductosDAO();
		return dao.registrarProducto(p);	
	}
}
