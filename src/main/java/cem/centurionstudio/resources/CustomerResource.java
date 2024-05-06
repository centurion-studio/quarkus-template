package cem.centurionstudio.resources;

import cem.centurionstudio.domain.Customer;
import cem.centurionstudio.services.CustomerService;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Path("/api/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    private CustomerService customerService;

    @GET
    @APIResponses(
            value = {
                    @APIResponse(
                            responseCode = "200",
                            description = "Get All Customers",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(type = SchemaType.ARRAY, implementation = Customer.class)
                            )
                    )
            }
    )
    public Response get() {
        return Response.ok(customerService.findAll()).build();
    }

    @GET
    @Path("/{customerId}")
    @APIResponses(
            value = {
                    @APIResponse(
                            responseCode = "200",
                            description = "Get Customer by customerId",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(type = SchemaType.OBJECT, implementation = Customer.class)
                            )
                    ),
                    @APIResponse(
                            responseCode = "404",
                            description = "No Customer found for customerId provided",
                            content = @Content(mediaType = "application/json")
                    ),
            }
    )
    public Response getById(@PathParam("customerId") Integer customerId) {
        Optional<Customer> optional = customerService.findById(customerId);
        return !optional.isEmpty() ? Response.ok(optional.get()).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @APIResponses(
            value = {
                    @APIResponse(
                            responseCode = "201",
                            description = "Customer Created",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(type = SchemaType.OBJECT, implementation = Customer.class)
                            )
                    ),
                    @APIResponse(
                            responseCode = "400",
                            description = "Customer already exists for customerId",
                            content = @Content(mediaType = "application/json")
                    ),
            }
    )
    public Response post(@Valid Customer customer) {
        final Customer saved = customerService.save(customer);
        return Response.status(Response.Status.CREATED).entity(saved).build();
    }

    @PUT
    @APIResponses(
            value = {
                    @APIResponse(
                            responseCode = "200",
                            description = "Customer updated",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(type = SchemaType.OBJECT, implementation = Customer.class)
                            )
                    ),
                    @APIResponse(
                            responseCode = "404",
                            description = "No Customer found for customerId provided",
                            content = @Content(mediaType = "application/json")
                    ),
            }
    )
    public Response put(@Valid Customer customer) {
        final Customer saved = customerService.update(customer);
        return Response.ok(saved).build();
    }
}
