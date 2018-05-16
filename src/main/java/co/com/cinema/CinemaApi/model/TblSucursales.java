package co.com.cinema.CinemaApi.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "tbl_sucursales")
public class TblSucursales {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	private String direccion;
	
	private String administrador;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id")
	private TblCiudades ciudad;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getAdministrador() {
		return administrador;
	}

	public void setAdministrador(String administrador) {
		this.administrador = administrador;
	}

	public TblCiudades getCiudad() {
		return ciudad;
	}

	public void setCiudad(TblCiudades ciudad) {
		this.ciudad = ciudad;
	}
	
	
}
