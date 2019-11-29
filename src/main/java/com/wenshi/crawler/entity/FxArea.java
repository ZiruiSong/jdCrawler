package com.wenshi.crawler.entity;

import javax.persistence.*;

/**
 * WhArea entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fx_area")
public class FxArea implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "area_id", unique = true, nullable = false)
	private Long areaId;
	@Column(name = "area_name")
	private String areaName;
	@Column(name = "parent_area_id")
	private Integer parentAreaId;
	@Column(name = "area_type")
	private Integer areaType;
	@Column(name = "zip")
	private String zip;

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getParentAreaId() {
		return parentAreaId;
	}

	public void setParentAreaId(Integer parentAreaId) {
		this.parentAreaId = parentAreaId;
	}

	public Integer getAreaType() {
		return areaType;
	}

	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "FxArea{" +
				"areaId=" + areaId +
				", areaName='" + areaName + '\'' +
				", parentAreaId=" + parentAreaId +
				", areaType=" + areaType +
				", zip='" + zip + '\'' +
				'}';
	}
}