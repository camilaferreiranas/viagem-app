package br.com.camilaferreiranas.reserva;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/reserva")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReservaResource {

    @GET
    public List<Reserva> get() {
        return Reserva.listAll();
    }

    @POST
    @Transactional
    public Response insert(Reserva reserva) {
        reserva.id = null;
        reserva.persist();
        return Response.status(Response.Status.CREATED).entity(reserva).build();
    }
}
