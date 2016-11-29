package todoapp.models;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class User {
	@Id
	private String id;
	
	@NotBlank
	@Indexed(unique=true)
	private String userId;
	@NotBlank
	private String password;
	
	private Date date = new Date();
	
	public  User(String userId,String password){
		this.userId=userId;
		this.password=password;
	}
	
	public User() {
		super();
	}
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}







	@Override
    public String toString() {
        return String.format(
                "User[id=%s, userId='%s', password='%s', date='%s']",
                id, userId, password, date);
    }		
}
