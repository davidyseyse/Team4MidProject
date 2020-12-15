package tw.team4.jspproject.javabean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class AttractionBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Integer attractionId;
	Integer eventId;
	Timestamp onSaleDate;
	Timestamp offSaleDate;
	Date commDate;
	Date dueDate;
	String description;
	
	public AttractionBean() {
		
	}
	
	public AttractionBean(Integer attractionId,Integer eventId,Timestamp onSaleDate,Timestamp offSaleDate,Date commDate,Date dueDate,String description) {
		this.attractionId=attractionId;
		this.eventId=eventId;
		this.onSaleDate=onSaleDate;
		this.offSaleDate=offSaleDate;
		this.commDate=commDate;
		this.dueDate=dueDate;
		this.description=description;
	}
	
	public AttractionBean(Integer eventId,Timestamp onSaleDate,Timestamp offSaleDate,Date commDate,Date dueDate,String description) {
		this.eventId=eventId;
		this.onSaleDate=onSaleDate;
		this.offSaleDate=offSaleDate;
		this.commDate=commDate;
		this.dueDate=dueDate;
		this.description=description;
	}
	
	public AttractionBean(Timestamp onSaleDate,Timestamp offSaleDate,Date commDate,Date dueDate,String description) {
		this.onSaleDate=onSaleDate;
		this.offSaleDate=offSaleDate;
		this.commDate=commDate;
		this.dueDate=dueDate;
		this.description=description;
	}

	public Integer getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(Integer attractionId) {
		this.attractionId = attractionId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Timestamp getOnSaleDate() {
		return onSaleDate;
	}

	public void setOnSaleDate(Timestamp onSaleDate) {
		this.onSaleDate = onSaleDate;
	}

	public Timestamp getOffSaleDate() {
		return offSaleDate;
	}

	public void setOffSaleDate(Timestamp offSaleDate) {
		this.offSaleDate = offSaleDate;
	}

	public Date getCommDate() {
		return commDate;
	}

	public void setCommDate(Date commDate) {
		this.commDate = commDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
