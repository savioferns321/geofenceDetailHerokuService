package com.example.fencedetails.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.fencedetails.model.GeoFenceDetail;
import com.example.fencedetails.model.GeoFenceDetailList;
import com.example.fencedetails.service.GFDetailService;

@RestController
@RequestMapping({"gfdetailservice/rest"})
public class GFDetailController {

	@Autowired
	GFDetailService service;

	@RequestMapping(
			value = "/gfDetail/{id}",
			method = RequestMethod.GET,
			headers = "Accept=*/*",
			produces = {
					MediaType.APPLICATION_JSON_VALUE
			}
			)
	public ResponseEntity<?> getDetail(@PathVariable(value="id") String id)   {
		System.out.println("ID = " + id);
		try {
			GeoFenceDetail detail = service.fetch(id);
			return new ResponseEntity<> (detail, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(
			value = "/gfDetail",
			method = RequestMethod.POST,
			headers = "Accept=*/*",
			consumes = {
					MediaType.APPLICATION_JSON_VALUE
			},
			produces = {
					MediaType.APPLICATION_JSON_VALUE
			}
			)
	public ResponseEntity<?> createDetail(@RequestBody GeoFenceDetail detail)    {
		System.out.println(detail.getId ());
		System.out.println(detail.getFirstName ());
		System.out.println(detail.getLastName ());
		try {
			detail = service.add (detail);
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setLocation(ServletUriComponentsBuilder
					.fromCurrentRequest().path("/{id}")
					.buildAndExpand(detail.getId()).toUri());
			return new ResponseEntity<>(detail, httpHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			System.out.println(e.getMessage ());
			return new ResponseEntity<> (HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(
            value = "/gfDetail/{id}",
            method = RequestMethod.PUT,
            headers = "Accept=*/*",
            consumes = {
                MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> updateDetail(@PathVariable(value="id") String id,
                               @RequestBody GeoFenceDetail detail)    {
        System.out.println(detail.getId ());
        System.out.println(detail.getFirstName ());
        System.out.println(detail.getLastName ());
        try {
            GeoFenceDetail result = service.update (id, detail);
            return new ResponseEntity<> (result, HttpStatus.OK);
        }catch (Exception e)    {
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        }
    }

	@RequestMapping(
            value = "/gfDetail/{id}",
            method = RequestMethod.DELETE
    )
    public ResponseEntity<?> deleteDetail(@PathVariable(value="id") String id)    {

        System.out.println("ID = " + id);
        try {
            service.delete (id);
            return new ResponseEntity<> (HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(
            value = "/details",
            method = RequestMethod.GET,
            headers = "Accept=*/*",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> getAllEmployees()   {
        try {
            GeoFenceDetailList detailList = service.fetchAll();
            return new ResponseEntity<> (detailList, HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
