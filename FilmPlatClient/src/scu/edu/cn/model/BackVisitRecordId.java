package scu.edu.cn.model;

/**
 * BackVisitRecordId entity. @author MyEclipse Persistence Tools
 */

public class BackVisitRecordId implements java.io.Serializable {

	// Fields

	private Integer backVisitId;
	private Integer managerId;

	// Constructors

	/** default constructor */
	public BackVisitRecordId() {
	}

	/** full constructor */
	public BackVisitRecordId(Integer backVisitId, Integer managerId) {
		this.backVisitId = backVisitId;
		this.managerId = managerId;
	}

	// Property accessors

	public Integer getBackVisitId() {
		return this.backVisitId;
	}

	public void setBackVisitId(Integer backVisitId) {
		this.backVisitId = backVisitId;
	}

	public Integer getManagerId() {
		return this.managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BackVisitRecordId))
			return false;
		BackVisitRecordId castOther = (BackVisitRecordId) other;

		return ((this.getBackVisitId() == castOther.getBackVisitId()) || (this
				.getBackVisitId() != null
				&& castOther.getBackVisitId() != null && this.getBackVisitId()
				.equals(castOther.getBackVisitId())))
				&& ((this.getManagerId() == castOther.getManagerId()) || (this
						.getManagerId() != null
						&& castOther.getManagerId() != null && this
						.getManagerId().equals(castOther.getManagerId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getBackVisitId() == null ? 0 : this.getBackVisitId()
						.hashCode());
		result = 37 * result
				+ (getManagerId() == null ? 0 : this.getManagerId().hashCode());
		return result;
	}

}