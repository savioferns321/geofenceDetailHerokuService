package com.example.fencedetails.model;

import java.util.ArrayList;
import java.util.List;

public class GeoFenceDetailList {

	private List<GeoFenceDetail> geoFenceDetails;
	
	public GeoFenceDetailList() {
		geoFenceDetails = new ArrayList<>();
	}

	public List<GeoFenceDetail> getGeoFenceDetails() {
		return geoFenceDetails;
	}

	public void setGeoFenceDetails(List<GeoFenceDetail> geoFenceDetails) {
		this.geoFenceDetails = geoFenceDetails;
	}
}
