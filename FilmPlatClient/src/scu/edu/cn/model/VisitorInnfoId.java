package scu.edu.cn.model;

import java.util.Date;

/**
 * VisitorInnfoId entity. @author MyEclipse Persistence Tools
 */

public class VisitorInnfoId implements java.io.Serializable {

	// Fields

	private Integer visitorIp;
	private Date visitorDate;

	// Constructors

	/** default constructor */
	public VisitorInnfoId() {
	}

	/** full constructor */
	public VisitorInnfoId(Integer visitorIp, Date visitorDate) {
		this.visitorIp = visitorIp;
		this.visitorDate = visitorDate;
	}

	// Property accessors

	public Integer getVisitorIp() {
		return this.visitorIp;
	}

	public void setVisitorIp(Integer visitorIp) {
		this.visitorIp = visitorIp;
	}

	public Date getVisitorDate() {
		return this.visitorDate;
	}

	public void setVisitorDate(Date visitorDate) {
		this.visitorDate = visitorDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VisitorInnfoId))
			return false;
		VisitorInnfoId castOther = (VisitorInnfoId) other;

		return ((this.getVisitorIp() == castOther.getVisitorIp()) || (this
				.getVisitorIp() != null
				&& castOther.getVisitorIp() != null && this.getVisitorIp()
				.equals(castOther.getVisitorIp())))
				&& ((this.getVisitorDate() == castOther.getVisitorDate()) || (this
						.getVisitorDate() != null
						&& castOther.getVisitorDate() != null && this
						.getVisitorDate().equals(castOther.getVisitorDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getVisitorIp() == null ? 0 : this.getVisitorIp().hashCode());
		result = 37
				* result
				+ (getVisitorDate() == null ? 0 : this.getVisitorDate()
						.hashCode());
		return result;
	}

}