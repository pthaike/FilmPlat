package scu.edu.cn.model;

import java.util.Date;

/**
 * BackVisitRecord entity. @author MyEclipse Persistence Tools
 */

public class BackVisitRecord implements java.io.Serializable {

	// Fields

	private BackVisitRecordId id;
	private Date visitDate;

	// Constructors

	/** default constructor */
	public BackVisitRecord() {
	}

	/** full constructor */
	public BackVisitRecord(BackVisitRecordId id, Date visitDate) {
		this.id = id;
		this.visitDate = visitDate;
	}

	// Property accessors

	public BackVisitRecordId getId() {
		return this.id;
	}

	public void setId(BackVisitRecordId id) {
		this.id = id;
	}

	public Date getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

}