package co.edu.lagenerica.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.lagenerica.model.Productos;
import co.edu.lagenerica.model.Tutorial;

public interface ProductoRepository extends MongoRepository<Productos, String>{
	//List<Tutorial> findByTitleContaining(String title);
	 // List<Tutorial> findByPublished(boolean published);
}
