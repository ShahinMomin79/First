package DAO;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class studentDAO {
	
	@Id
	private  int id;
	private String name;
	private String email;
	private  String city;

}
