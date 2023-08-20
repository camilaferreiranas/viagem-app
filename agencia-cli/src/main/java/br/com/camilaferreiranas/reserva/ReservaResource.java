package br.com.camilaferreiranas.reserva;

import br.com.camilaferreiranas.cliente.Cliente;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/reserva-cli")
public class ReservaResource {

    @Inject
    @RestClient
    ReservaService reservaService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("newReserva")
    public Response newReserva() {
        Cliente cliente = Cliente.of(1, "Camila");
        Response response = reservaService.newReserva(cliente);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }
}
