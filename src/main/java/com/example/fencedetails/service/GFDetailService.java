package com.example.fencedetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fencedetails.model.GeoFenceDetail;
import com.example.fencedetails.repository.GFDetailRepository;

@Service
public class GFDetailService {

	@Autowired
	GFDetailRepository repository;
	
	public GFDetailService() {}
	
	public GeoFenceDetail add(GeoFenceDetail detail) throws Exception{
		if(repository.findOne(detail.getId()) != null) 
			throw new Exception("Geofence already exists");
		
		return repository.save(detail);
	}
	
	public GeoFenceDetail update (String id, GeoFenceDetail detail) throws Exception {
		detailExists (id);
        return repository.save (detail);
    }

    private GeoFenceDetail detailExists (String id) throws Exception {
    	GeoFenceDetail detail = repository.findOne (id);
        if (detail == null) {
            throw new Exception ();
        }
        return detail;
    }

    public void delete (String id) throws Exception {
    	detailExists (id);
        repository.delete (id);
    }

    public GeoFenceDetail fetch (String id) throws Exception {
        return detailExists(id);
    }
	
}
