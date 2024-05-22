package edu.badpals;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/do")
public class Resources {
    @Inject
    Service service;

    @GET
    @Path("/updateStock")
    @Transactional
    public void updateStock(){
        service.updateDatabase();
    }

}
