package co.edu.lagenerica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.edu.lagenerica.model.ProductosDAO;
import co.edu.lagenerica.model.Productos;
import co.edu.lagenerica.model.Tutorial;
import co.edu.lagenerica.repository.ProductoRepository;
import co.edu.lagenerica.repository.TutorialRepository;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProductosController {
	@Autowired
	  ProductoRepository productoRepository;
	
//	@PostMapping("/productos")
//	  public ResponseEntity<List<Productos>> postProductos(@RequestParam(required = true) Productos productos) {
//		System.out.println("Algo nuevo");  
//		try {
//			    List<Productos> producto = new ArrayList<Productos>();
//
//				/*
//				 * if (title == null) tutorialRepository.findAll().forEach(tutorials::add); else
//				 * tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
//				 * 
//				 * if (tutorials.isEmpty()) { return new
//				 * ResponseEntity<>(HttpStatus.NO_CONTENT); }
//				 */
//
//			    return new ResponseEntity<>(producto, HttpStatus.OK);
//			  } catch (Exception e) {
//			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//			  }
//	  }
	@PostMapping("/productos")
	  public ResponseEntity<Productos> createProducto(@RequestBody MultipartFile files) {
		  try {
			  	//(long codigo, String nombre, long nit_proveedor, double precio_compra, double iva,double precio_venta)
				  Productos producto=null;  
				  Productos _producto = productoRepository.save(new Productos(producto.getCodigo(), producto.getNombre(),producto.getNit_proveedor(),producto.getPrecio_compra(),producto.getIva(),producto.getPrecio_venta()));
			    return new ResponseEntity<>(_producto, HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	
	
}
