package com.korera.main.Entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ProjectUser", catalog = "KoreraSchema")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProjectUser {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "puID", unique = true, nullable = false)
	private Integer puID;
	
	@Column(name = "pid")
	private Integer pid;
	@Column(name = "uid")
	private Integer uid;
	
	public ProjectUser(Integer pid, Integer uid) {
		this.pid = pid;
		this.uid = uid;
	}
	
	public Integer getPrID() {
		return this.puID;
	}
	
	public Integer getPid() {
		return this.pid;
	}
	
	public Integer getUid() {
		return this.uid;
	}

}
