package com.caoqian.movie.domain;

public class Movie {

	private Integer id;
	private String name;//电影名称
	private String actor;//导演
	private Double price; //价格  -包装类
	private String uptime;  //上映时间
	private Integer longtime;  //电影时间长度
	private String type;  //电影类型
	private String area;//区域
	private Integer years;//年代
	private Integer status;//1：即将上映 2,正在热映 3：已经下架
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getUptime() {
		return uptime;
	}
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}
	public Integer getLongtime() {
		return longtime;
	}
	public void setLongtime(Integer longtime) {
		this.longtime = longtime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Integer getYears() {
		return years;
	}
	public void setYears(Integer years) {
		this.years = years;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	public Movie() {
		super();
	}
	public Movie(Integer id, String name, String actor, Double price, String uptime, Integer longtime, String type,
			String area, Integer years, Integer status) {
		super();
		this.id = id;
		this.name = name;
		this.actor = actor;
		this.price = price;
		this.uptime = uptime;
		this.longtime = longtime;
		this.type = type;
		this.area = area;
		this.years = years;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", actor=" + actor + ", price=" + price + ", uptime=" + uptime
				+ ", longtime=" + longtime + ", type=" + type + ", area=" + area + ", years=" + years + ", status="
				+ status + "]";
	}
	
	
	
	
	
	
}
