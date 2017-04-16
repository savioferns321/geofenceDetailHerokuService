package com.example.fencedetails.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.fencedetails.model.GeoFenceDetail;

public interface GFDetailRepository  extends CrudRepository<GeoFenceDetail, String>{

}
