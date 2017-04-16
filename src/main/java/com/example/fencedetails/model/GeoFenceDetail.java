package com.example.fencedetails.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "GeoFenceDetail")
public class GeoFenceDetail {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private double lat;
	private double lng;
	private long radius;
	
	public GeoFenceDetail() {}

	public GeoFenceDetail(String id, String firstName, String lastName, double lat, double lng, long radius) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lat = lat;
		this.lng = lng;
		this.radius = radius;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public long getRadius() {
		return radius;
	}

	public void setRadius(long radius) {
		this.radius = radius;
	}
	
	@Override
	public String toString() {
		return String.format(" FirstName : %s, LastName %s, Latitude: %f, Longitude: %f, Radius: %d, ID: %s", 
				firstName, lastName, lat, lng, radius, id);
	}
}
