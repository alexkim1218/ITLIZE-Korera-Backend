package Entity;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "Resource")
public class Resource {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resourceID;
	
	@Column
	private String resourceName;
	
	@Column
	private int resourceCode;
	
	@Column
	private String extraCols;

	@Column
	private String extraColsType;
	
	@Column
	private String extraColsVal;

	public int getResourceID() {
		return resourceID;
	}

	public void setResourceID(int resourceID) {
		this.resourceID = resourceID;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public int getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(int resourceCode) {
		this.resourceCode = resourceCode;
	}
	
	public String getExtraCols() {
		return extraCols;
	}

	public void setExtraCols(String extraCols) {
		this.extraCols = extraCols;
	}

	public String getExtraColsType() {
		return extraColsType;
	}

	public void setExtraColsType(String extraColsType) {
		this.extraColsType = extraColsType;
	}

	public String getExtraColsVal() {
		return extraColsVal;
	}

	public void setExtraColsVal(String extraColsVal) {
		this.extraColsVal = extraColsVal;
	}
	
	@Override
	public String toString() {
		return  "Resource Code: " + resourceCode + " | Name: " + resourceName;
	}
}
