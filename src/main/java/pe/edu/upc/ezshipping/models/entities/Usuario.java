package pe.edu.upc.ezshipping.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pe.edu.upc.ezshipping.utils.Segmento;

//Se guarda el usuario y su estado de actividad
@Entity
@Table(name = "users")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 30, nullable = false)
	private String username;
	
	@Column(length = 60, nullable = false)
	private String password;
	
	private boolean enable;
	
	//menu para saber si es cliente o trabajador
	@Column(name = "segmento", nullable = false)
	private Segmento segmento;
	
	//identificador de segmento
	@Column(name = "id_segmento", nullable = false)
	private Integer idSegmento;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Authority> authorities;
	
	public Usuario() {
		this.enable = true;
		this.authorities = new ArrayList<>();
	}
	public Usuario( String username, String password ) {
		this.username = username;
		this.password = password;
		this.enable = true;
		this.authorities = new ArrayList<>();
	}
	public void addAuthority( String auth ) {
		Authority authority = new Authority();
		authority.setAuthority( auth ) ;
		authority.setUsuario( this );
		
		this.authorities.add( authority );
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public Segmento getSegmento() {
		return segmento;
	}
	public void setSegmento(Segmento segmento) {
		this.segmento = segmento;
	}
	public Integer getIdSegmento() {
		return idSegmento;
	}
	public void setIdSegmento(Integer idSegmento) {
		this.idSegmento = idSegmento;
	}
	public List<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
}
