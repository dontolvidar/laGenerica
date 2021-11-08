package co.edu.lagenerica.model;

import java.sql.SQLException;
import java.sql.Statement;


public class ProductosDAO {
	public Productos registrarProducto(Productos p) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO productos VALUES ('" + p.getCodigo() + "', '" + p.getNitpro()
					+ "','" + p.getIvacompra() + "', '" + p.getNombre()  + "', '" + p.getPreciocompra()  + "', '" + p.getPrecioventa() + "');");

			estatuto.close();
			conex.close();

		} catch (SQLException e) {
			p = null;
			System.out.println(e.getMessage());
		}
		return p;
	}
}
