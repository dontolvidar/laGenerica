package co.edu.lagenerica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import co.edu.lagenerica.model.ProductosDAO;
import co.edu.lagenerica.model.Productos;
import co.edu.lagenerica.model.Tutorial;
import co.edu.lagenerica.repository.ProductoRepository;
import co.edu.lagenerica.repository.TutorialRepository;

public class ProductosController {
	@Autowired
	  ProductoRepository productoRepository;
	
	@PostMapping("/tutorials")
	  public ResponseEntity<Productos> createTutorial(@RequestBody Productos producto) {
		  try {
			    Productos _producto = productoRepository.save(new Productos(producto.getCodigo(), producto.getNombre(),producto.getNit_proveedor(),producto.getPrecio_compra(),producto.getIva(), producto.getPrecio_venta()));
			    return new ResponseEntity<>(_producto, HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	
	
}
