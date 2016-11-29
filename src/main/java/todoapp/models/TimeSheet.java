package todoapp.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="timesheets")
public class TimeSheet {
	@Id
	private String id;
	
	@NotBlank
	@Indexed
	private String userId;
	
	private List<Integer> hours;
	private List<Date> dates;
	private Boolean completed = false;	

	private Date date = new Date();
	public TimeSheet() {
		super();
	}
	
	
	public TimeSheet(String userId) {
		this.userId=userId;
		this.hours=new ArrayList<Integer>();
		this.hours.add(0);
		this.hours.add(0);
		this.hours.add(0);
		this.hours.add(0);
		this.hours.add(0);
		this.hours.add(0);
		this.hours.add(0);
		this.completed=false;
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


	public List<Integer> getHours() {
		return hours;
	}


	public List<Date> getDates() {
		return dates;
	}


	public void setDates(List<Date> dates) {
		this.dates = dates;
	}


	public void setHours(List<Integer> hours) {
		this.hours = hours;
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
                "RequestLetter[id=%s, completed='%s', hours='%s',date='%s',userid='%s']",
                id, completed, hours,date,userId);
    }

}
