package scu.edu.cn.model;

/**
 * ManagerInfo entity. @author MyEclipse Persistence Tools
 */

public class ManagerInfo implements java.io.Serializable {

	// Fields

	private Integer managerId;
	private String managerName;
	private String managerPassword;

	// Constructors

	/** default constructor */
	public ManagerInfo() {
	}

	/** full constructor */
	public ManagerInfo(String managerName, String managerPassword) {
		this.managerName = managerName;
		this.managerPassword = managerPassword;
	}

	// Property accessors

	public Integer getManagerId() {
		return this.managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPassword() {
		return this.managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

}