package tw.team4.jspproject.javabean;

import java.io.Serializable;


public class EventBean implements Serializable {
	private static final long serialVersionUID = 1L;
	Integer eventId;
	Integer typeId;
	String eventName;
	String eventLocation;
	byte[] eventImage;
	Integer organizationId;
	Integer companyId;
	
	public EventBean() {
	}
	
	public EventBean(Integer eventId,Integer typeId, String eventName,String eventLocation,
			byte[] eventImage, Integer organizationId, Integer companyId) {
		this.eventId=eventId;
		this.typeId=typeId;
		this.eventName=eventName;
		this.eventLocation=eventLocation;
		this.eventImage=eventImage;
		this.organizationId = organizationId;
		this.companyId=companyId;
			
	}
	
	public EventBean(Integer typeId, String eventName,String eventLocation,
			byte[] eventImage, Integer organizationId, Integer companyId) {
		this.typeId=typeId;
		this.eventName=eventName;
		this.eventLocation=eventLocation;
		this.eventImage=eventImage;
		this.organizationId = organizationId;
		this.companyId=companyId;
		
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public byte[] getEventImage() {
		return eventImage;
	}

	public void setEventImage(byte[] eventImage) {
		this.eventImage = eventImage;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	
	
}
