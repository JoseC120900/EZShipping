package pe.edu.upc.ezshipping.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tarjetas")
public class Tarjeta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nro_tarjeta", length = 16, nullable = false)
	private String nroTarjeta;

	@Column(name = "mes_vencimiento", length = 2)
	private Integer mes_vencimiento;
	
	@Column(name = "anio_vencimiento", length = 4)
	private Integer anio_vencimiento;

	@Column(name = "cvv", length = 3, nullable = false)
	private Integer cvv;

	@OneToMany(mappedBy = "tarjeta")
	private List<ClienteTarjeta> clienteTarjetas;

	@OneToMany(mappedBy = "tarjeta")
	private List<Envio> envios;

	public Tarjeta() {
		clienteTarjetas = new ArrayList<ClienteTarjeta>();
		envios = new ArrayList<Envio>();
	}

	public String getIdString() {
		return Integer.toString(id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNroTarjeta() {
		return nroTarjeta;
	}

	public void setNroTarjeta(String nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}

	public Integer getMes_vencimiento() {
		return mes_vencimiento;
	}

	public void setMes_vencimiento(Integer mes_vencimiento) {
		this.mes_vencimiento = mes_vencimiento;
	}

	public Integer getAnio_vencimiento() {
		return anio_vencimiento;
	}

	public void setAnio_vencimiento(Integer anio_vencimiento) {
		this.anio_vencimiento = anio_vencimiento;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public List<ClienteTarjeta> getClienteTarjetas() {
		return clienteTarjetas;
	}

	public void setClienteTarjetas(List<ClienteTarjeta> clienteTarjetas) {
		this.clienteTarjetas = clienteTarjetas;
	}

	public List<Envio> getEnvios() {
		return envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

}
