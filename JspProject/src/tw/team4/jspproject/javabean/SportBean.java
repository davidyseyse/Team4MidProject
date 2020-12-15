package tw.team4.jspproject.javabean;

import java.io.Serializable;
import java.sql.Timestamp;

public class SportBean implements Serializable {
	private static final long serialVersionUID = 1L;
	Integer sportId;
	Integer eventId;
	Timestamp onSaleDate;
	Timestamp offSaleDate;
	String description;
	Integer cardId;
	
	public SportBean() {
		
	}
	
	public SportBean(Integer sportId,Integer eventId,Timestamp onSaleDate,Timestamp offSaleDate,String description,Integer cardId) {
		this.sportId = sportId;
		this.eventId = eventId;
		this.onSaleDate=onSaleDate;
		this.offSaleDate=offSaleDate;
		this.description=description;
		this.cardId=cardId;
	}
	
	public SportBean(Integer eventId,Timestamp onSaleDate,Timestamp offSaleDate,String description,Integer cardId) {
		this.eventId = eventId;
		this.onSaleDate=onSaleDate;
		this.offSaleDate=offSaleDate;
		this.description=description;
		this.cardId=cardId;
	}

	public Integer getSportId() {
		return sportId;
	}

	public void setSportId(Integer sportId) {
		this.sportId = sportId;
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
