package scu.edu.cn.model;

/**
 * CUserinfo entity. @author MyEclipse Persistence Tools
 */

public class CUserinfo implements java.io.Serializable {

	// Fields

	private Integer parameterId;
	private Integer maxBuyAmount;
	private Integer buyDeadline;

	// Constructors

	/** default constructor */
	public CUserinfo() {
	}

	/** full constructor */
	public CUserinfo(Integer maxBuyAmount, Integer buyDeadline) {
		this.maxBuyAmount = maxBuyAmount;
		this.buyDeadline = buyDeadline;
	}

	// Property accessors

	public Integer getParameterId() {
		return this.parameterId;
	}

	public void setParameterId(Integer parameterId) {
		this.parameterId = parameterId;
	}

	public Integer getMaxBuyAmount() {
		return this.maxBuyAmount;
	}

	public void setMaxBuyAmount(Integer maxBuyAmount) {
		this.maxBuyAmount = maxBuyAmount;
	}

	public Integer getBuyDeadline() {
		return this.buyDeadline;
	}

	public void setBuyDeadline(Integer buyDeadline) {
		this.buyDeadline = buyDeadline;
	}

}