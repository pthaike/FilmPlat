package scu.edu.cn.model;

/**
 * VisitorInnfo entity. @author MyEclipse Persistence Tools
 */

public class VisitorInnfo implements java.io.Serializable {

	// Fields

	private VisitorInnfoId id;
	private String visitorExplorer;
	private String visitorArea;
	private String visitorHd;
	private String visitorOs;
	private String visitorLanguage;
	private String visitorEndtype;

	// Constructors

	/** default constructor */
	public VisitorInnfo() {
	}

	/** full constructor */
	public VisitorInnfo(VisitorInnfoId id, String visitorExplorer,
			String visitorArea, String visitorHd, String visitorOs,
			String visitorLanguage, String visitorEndtype) {
		this.id = id;
		this.visitorExplorer = visitorExplorer;
		this.visitorArea = visitorArea;
		this.visitorHd = visitorHd;
		this.visitorOs = visitorOs;
		this.visitorLanguage = visitorLanguage;
		this.visitorEndtype = visitorEndtype;
	}

	// Property accessors

	public VisitorInnfoId getId() {
		return this.id;
	}

	public void setId(VisitorInnfoId id) {
		this.id = id;
	}

	public String getVisitorExplorer() {
		return this.visitorExplorer;
	}

	public void setVisitorExplorer(String visitorExplorer) {
		this.visitorExplorer = visitorExplorer;
	}

	public String getVisitorArea() {
		return this.visitorArea;
	}

	public void setVisitorArea(String visitorArea) {
		this.visitorArea = visitorArea;
	}

	public String getVisitorHd() {
		return this.visitorHd;
	}

	public void setVisitorHd(String visitorHd) {
		this.visitorHd = visitorHd;
	}

	public String getVisitorOs() {
		return this.visitorOs;
	}

	public void setVisitorOs(String visitorOs) {
		this.visitorOs = visitorOs;
	}

	public String getVisitorLanguage() {
		return this.visitorLanguage;
	}

	public void setVisitorLanguage(String visitorLanguage) {
		this.visitorLanguage = visitorLanguage;
	}

	public String getVisitorEndtype() {
		return this.visitorEndtype;
	}

	public void setVisitorEndtype(String visitorEndtype) {
		this.visitorEndtype = visitorEndtype;
	}

}