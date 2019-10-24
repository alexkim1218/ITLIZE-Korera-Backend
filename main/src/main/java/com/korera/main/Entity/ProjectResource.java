package com.korera.main.Entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ProjectResource", catalog = "KoreraSchema")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProjectResource implements java.io.Serializable{
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "prID", unique = true, nullable = false)
	private Integer prID;
	
	@Column(name = "pid")
	private Integer pid;
	@Column(name = "rid")
	private Integer rid;
	
	public ProjectResource() {
		
	}
	
	public ProjectResource(Integer pid, Integer rid) {
		this.pid = pid;
		this.rid = rid;
	}
	
	public Integer getPrID() {
		return this.prID;
	}
	
	public Integer getPid() {
		return this.pid;
	}
	
	public Integer getRid() {
		return this.rid;
	}
	
}
