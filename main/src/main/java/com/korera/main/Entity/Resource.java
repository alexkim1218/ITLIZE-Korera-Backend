// default package
package com.korera.main.Entity;
// Generated Oct 18, 2019 10:06:43 AM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Resource generated by hbm2java
 */
@Entity
@Table(name = "Resource", catalog = "KoreraSchema", uniqueConstraints = @UniqueConstraint(columnNames = "resourceCode"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Resource implements java.io.Serializable {

	private Integer resourceId;
	private String resourceName;
	private int resourceCode;
	private String extraColsVal;

	public Resource() {
	}

	public Resource(String resourceName, int resourceCode) {
		this.resourceName = resourceName;
		this.resourceCode = resourceCode;
	}

	public Resource(String resourceName, int resourceCode, String extraColsVal) {
		this.resourceName = resourceName;
		this.resourceCode = resourceCode;
		this.extraColsVal = extraColsVal;
	}

	public Resource(Integer resourceId, String resourceName, int resourceCode, String extraColsVal) {
		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.resourceCode = resourceCode;
		this.extraColsVal = extraColsVal;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "resourceID", unique = true, nullable = false)
	public Integer getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	@Column(name = "resourceName", nullable = false, length = 256)
	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	@Column(name = "resourceCode", unique = true, nullable = false)
	public int getResourceCode() {
		return this.resourceCode;
	}

	public void setResourceCode(int resourceCode) {
		this.resourceCode = resourceCode;
	}

	@Column(name = "extraColsVal", length = 256)
	public String getExtraColsVal() {
		return this.extraColsVal;
	}

	public void setExtraColsVal(String extraColsVal) {
		this.extraColsVal = extraColsVal;
	}

}
