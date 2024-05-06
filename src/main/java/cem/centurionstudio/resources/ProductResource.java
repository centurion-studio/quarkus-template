package cem.centurionstudio.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

@Path(value = "/products")
public class ProductResource {

    @GET()
    @Path(value = "/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getProduct(String id, SecurityContext security) {
        return Response.ok().build();
    }
}
