package todoapp.models;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="requestletters")
public class StatusReport {
	@Id
	private String id;
	
	@NotBlank
	@Indexed
	private String userId;
	
	private String content;
	private Boolean completed = false;	

	private Date date = new Date();
	public StatusReport() {
		super();
	}
	
	
	public StatusReport(String userId, String content) {
		this.userId=userId;
		this.content=content;
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



	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Boolean getCompleted() {
		return completed;
	}


	public void setCompleted(Boolean completed) {
		this.completed = completed;
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
                "RequestLetter[id=%s, content='%s',date='%s',userid='%s']",
                id, content,date,userId);
    }		
}
