package co.edu.lagenerica.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		Productos _producto=null;
			try {
			  File fl = new File("C:\\ArchivosRecibidos\\" + files.getOriginalFilename());
			  files.transferTo(fl);
			  
			  FileReader fr = new FileReader(fl);
              BufferedReader br = new BufferedReader(fr);
              String linea = "";
              while ((linea = br.readLine()) != null) {
                  String[] tokens = linea.split(",");
                //(long codigo, String nombre, long nit_proveedor, double precio_compra, double iva,double precio_venta)
				  Productos producto = new Productos(Long.parseLong(tokens[0]),(tokens[1]) ,Long.parseLong(tokens[2]),Double.parseDouble(tokens[3]), Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5]));
                  _producto = productoRepository.save(new Productos(producto.getCodigo(), producto.getNombre(),producto.getNit_proveedor(),producto.getPrecio_compra(),producto.getIva(),producto.getPrecio_venta()));
              }
              br.close();
              fr.close();
			  	
				  
			    
				return new ResponseEntity<>(_producto, HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	
	
}
