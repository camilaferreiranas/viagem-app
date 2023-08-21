package br.com.camilaferreiranas.cliente;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @GET
    public List<Cliente> get() {

        return Cliente.listAll();
    }

    @GET
    @Path("/findById")
    public Cliente findById(@QueryParam("id") long id) {
        return Cliente.findById(id);
    }

    @Transactional
    @DELETE
    @Path("/deleteById")
    public void deleteById(@QueryParam("id") long id) {
        Cliente.deleteById(id);
    }

    @Transactional
    @POST
    public Response insert(Cliente cliente) {
        cliente.id = null;
        cliente.persist();
        return Response.status(Response.Status.CREATED).entity(cliente).build();
    }
}
