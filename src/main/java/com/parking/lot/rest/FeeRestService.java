package com.parking.lot.rest;


import com.parking.lot.FeeStructure;
import com.parking.lot.service.FeeService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/")
public class FeeRestService {

    private FeeService feeService;



   public FeeRestService (FeeService feeService) {
       this.feeService = feeService;

    }



    @GET
    @Path("/fee")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FeeStructure> getFee() {


        return (List< FeeStructure>) (feeService.getFeeStructure());


    }



}
