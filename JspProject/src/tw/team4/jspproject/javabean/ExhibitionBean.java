package tw.team4.jspproject.javabean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class ExhibitionBean implements Serializable{
	private static final long serialVersionUID = 1L;
	Integer exhibitionId;
	Integer eventId;
	Timestamp onSaleDate;
	Timestamp offSaleDate;
	Date commDate;
	Date dueDate;
	String description;
	Integer cardId;
	
	public ExhibitionBean() {
		
	}
	
	public ExhibitionBean(Integer exhibitionId,Integer eventId,Timestamp onSaleDate,Timestamp offSaleDate,Date commDate,Date dueDate,String description,Integer cardId) {
		this.exhibitionId=exhibitionId;
		this.eventId=eventId;
		this.onSaleDate=onSaleDate;
		this.offSaleDate=offSaleDate;
		this.commDate=commDate;
		this.dueDate=dueDate;
		this.description=description;
		this.cardId=cardId;
		
	}
	
	public ExhibitionBean(Integer eventId,Timestamp onSaleDate,Timestamp offSaleDate,Date commDate,Date dueDate,String description,Integer cardId) {
		this.eventId=eventId;
		this.onSaleDate=onSaleDate;
		this.offSaleDate=offSaleDate;
		this.commDate=commDate;
		this.dueDate=dueDate;
		this.description=description;
		this.cardId=cardId;
		
	}
	
	public ExhibitionBean(Timestamp onSaleDate,Timestamp offSaleDate,Date commDate,Date dueDate,String description,Integer cardId) {
		
		this.onSaleDate=onSaleDate;
		this.offSaleDate=offSaleDate;
		this.commDate=commDate;
		this.dueDate=dueDate;
		this.description=description;
		this.cardId=cardId;
		
	}
	
	public Integer getExhibitionId() {
		return exhibitionId;
	}
	public void setExhibitionId(Integer exhibitionId) {
		this.exhibitionId = exhibitionId;
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
	public Integer getCardId() {
		return cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
}
