package tw.team4.jspproject.javabean;

import java.io.Serializable;

public class PriceBean implements Serializable {
	private static final long serialVersionUID = 1L;
	Integer priceId;
	Integer eventId;
	String name;
	Integer cost;
	
	public PriceBean() {
		
	}
	
	public PriceBean(Integer priceId,Integer eventId,String name,Integer cost) {
		this.priceId = priceId;
		this.eventId = eventId;
		this.name = name;
		this.cost = cost;
	}
	
	public PriceBean(Integer eventId,String name,Integer cost) {
		this.eventId = eventId;
		this.name = name;
		this.cost = cost;
	}
	
	public PriceBean(String name,Integer cost) {
		
		this.name = name;
		this.cost = cost;
	}

	public Integer getPriceId() {
		return priceId;
	}

	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
}
