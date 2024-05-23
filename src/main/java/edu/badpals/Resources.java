package edu.badpals;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

import edu.badpals.domain.Item;

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

    @GET
    @Path("/seeStock")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStock(){
        List<Item> items = Item.getAllItems();
        return Response.status(Response.Status.CREATED).entity(items).build();
    }

    @GET
    @Path("/see/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showItemsByName(@PathParam("name") String name){
        List<Item> items = Item.getItemsByName(name);
        return Response.status(Response.Status.CREATED).entity(items).build();
    }

}
