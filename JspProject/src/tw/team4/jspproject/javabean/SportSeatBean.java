package tw.team4.jspproject.javabean;

import java.io.Serializable;

public class SportSeatBean implements Serializable {
	private static final long serialVersionUID = 1L;
	Integer sportSeatId;
	Integer eventId;
	Integer sportSessionId;
	Integer priceId;
	String area;
	Integer seatNo;
	
	public SportSeatBean() {
		
	}
	
	public SportSeatBean(Integer sportSeatId,Integer eventId,Integer sportSessionId,Integer priceId,String area,Integer seatNo) {
		this.sportSeatId = sportSeatId;
		this.eventId = eventId;
		this.sportSessionId = sportSessionId;
		this.priceId = priceId;
		this.area = area;
		this.seatNo=seatNo;
	}
	public SportSeatBean(Integer eventId,Integer sportSessionId,Integer priceId,String area,Integer seatNo) {
		this.eventId = eventId;
		this.sportSessionId = sportSessionId;
		this.priceId = priceId;
		this.area = area;
		this.seatNo=seatNo;
	}

	public Integer getSportSeatId() {
		return sportSeatId;
	}

	public void setSportSeatId(Integer sportSeatId) {
		this.sportSeatId = sportSeatId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getSportSessionId() {
		return sportSessionId;
	}

	public void setSportSessionId(Integer sportSessionId) {
		this.sportSessionId = sportSessionId;
	}

	public Integer getPriceId() {
		return priceId;
	}

	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}
	
	
}
