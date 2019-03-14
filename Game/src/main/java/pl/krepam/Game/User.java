package pl.krepam.Game;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Users")
public class User {
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id = 0;
	
	@Column(name="name")
	@NotNull
	private String name;
	
	@Column(name="passwd")
	@NotNull
	private String passwd;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", passwd=" + passwd + "]";
	}

	public User(Integer id, @NotNull String name, @NotNull String passwd) {
		super();
		this.id = id;
		this.name = name;
		this.passwd = passwd;
	}

	public User() {
		super();
	}

	public User(@NotNull String name, @NotNull String passwd) {
		super();
		this.name = name;
		this.passwd = passwd;
	}
	
	
}
