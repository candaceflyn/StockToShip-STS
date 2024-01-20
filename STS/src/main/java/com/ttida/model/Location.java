package com.ttida.model;

import jakarta.persistence.*;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @Column(name = "location_id", nullable = false)
    private Long locationId;

    @Column(name = "location_description", nullable = false)
    private String locationDescription;

    @Column(name = "status_code", nullable = false)
    private int statusCode;

    @Column(name = "location_length", nullable = false)
    private int locationLength;

    @Column(name = "location_width", nullable = false)
    private int locationWidth;

    @Column(name = "location_height", nullable = false)
    private int locationHeight;

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(Long locationId, String locationDescription, int statusCode, int locationLength, int locationWidth,
			int locationHeight) {
		super();
		this.locationId = locationId;
		this.locationDescription = locationDescription;
		this.statusCode = statusCode;
		this.locationLength = locationLength;
		this.locationWidth = locationWidth;
		this.locationHeight = locationHeight;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getLocationLength() {
		return locationLength;
	}

	public void setLocationLength(int locationLength) {
		this.locationLength = locationLength;
	}

	public int getLocationWidth() {
		return locationWidth;
	}

	public void setLocationWidth(int locationWidth) {
		this.locationWidth = locationWidth;
	}

	public int getLocationHeight() {
		return locationHeight;
	}

	public void setLocationHeight(int locationHeight) {
		this.locationHeight = locationHeight;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationDescription=" + locationDescription + ", statusCode="
				+ statusCode + ", locationLength=" + locationLength + ", locationWidth=" + locationWidth
				+ ", locationHeight=" + locationHeight + "]";
	}

    
}

