package scu.nine.modle;

/**
 * MovieType entity. @author MyEclipse Persistence Tools
 */

public class MovieType implements java.io.Serializable {

	// Fields

	private Integer movieId;
	private MovieInfo movieInfo;
	private Integer typeComedy;
	private Integer typeAction;
	private Integer typeLove;
	private Integer typeFiction;
	private Integer typeDracula;

	// Constructors

	/** default constructor */
	public MovieType() {
	}

	/** minimal constructor */
	public MovieType(MovieInfo movieInfo) {
		this.movieInfo = movieInfo;
	}

	/** full constructor */
	public MovieType(MovieInfo movieInfo, Integer typeComedy,
			Integer typeAction, Integer typeLove, Integer typeFiction,
			Integer typeDracula) {
		this.movieInfo = movieInfo;
		this.typeComedy = typeComedy;
		this.typeAction = typeAction;
		this.typeLove = typeLove;
		this.typeFiction = typeFiction;
		this.typeDracula = typeDracula;
	}

	// Property accessors

	public Integer getMovieId() {
		return this.movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public MovieInfo getMovieInfo() {
		return this.movieInfo;
	}

	public void setMovieInfo(MovieInfo movieInfo) {
		this.movieInfo = movieInfo;
	}

	public Integer getTypeComedy() {
		return this.typeComedy;
	}

	public void setTypeComedy(Integer typeComedy) {
		this.typeComedy = typeComedy;
	}

	public Integer getTypeAction() {
		return this.typeAction;
	}

	public void setTypeAction(Integer typeAction) {
		this.typeAction = typeAction;
	}

	public Integer getTypeLove() {
		return this.typeLove;
	}

	public void setTypeLove(Integer typeLove) {
		this.typeLove = typeLove;
	}

	public Integer getTypeFiction() {
		return this.typeFiction;
	}

	public void setTypeFiction(Integer typeFiction) {
		this.typeFiction = typeFiction;
	}

	public Integer getTypeDracula() {
		return this.typeDracula;
	}

	public void setTypeDracula(Integer typeDracula) {
		this.typeDracula = typeDracula;
	}

}