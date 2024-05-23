package edu.badpals;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/do")
public class Resources {
    @Inject
    Service service;

    @GET
    @Path("/updateStock")
    @Transactional
    public String updateStock(){
        service.updateDatabase();
        return "Accion llevada a cabo correctamente";
    }

}
