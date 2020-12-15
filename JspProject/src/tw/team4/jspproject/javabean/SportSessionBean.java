package tw.team4.jspproject.javabean;

import java.io.Serializable;
import java.sql.Timestamp;

public class SportSessionBean implements Serializable {
	private static final long serialVersionUID = 1L;
	Integer sportSessionId;
	Integer sportId;
	Timestamp sessionDate;
	
	public SportSessionBean() {
		
	}
	
	public SportSessionBean(Integer sportSessionId,Integer sportId,Timestamp sessionDate) {
		this.sportSessionId=sportSessionId;
		this.sportId = sportId;
		this.sessionDate = sessionDate;
	}
	
	public SportSessionBean(Integer sportId,Timestamp sessionDate) {
		this.sportId = sportId;
		this.sessionDate = sessionDate;
	}
	
	public Integer getSportSessionId() {
		return sportSessionId;
	}
	public void setSportSessionId(Integer sportSessionId) {
		this.sportSessionId = sportSessionId;
	}
	public Integer getSportId() {
		return sportId;
	}
	public void setSportId(Integer sportId) {
		this.sportId = sportId;
	}
	public Timestamp getSessionDate() {
		return sessionDate;
	}
	public void setSessionDate(Timestamp sessionDate) {
		this.sessionDate = sessionDate;
	}
}
