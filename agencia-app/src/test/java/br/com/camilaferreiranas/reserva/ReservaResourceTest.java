package br.com.camilaferreiranas.reserva;

import br.com.camilaferreiranas.cliente.Cliente;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jakarta.json.bind.JsonbBuilder;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestHTTPEndpoint(ReservaResource.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReservaResourceTest {


    @Test
    @DisplayName("Should create a reserva")
    @Order(1)
    void createReserva() {

        var cliente = new Cliente();
        cliente.nome = "Camila";
        cliente.id = 1L;
        var reserva = new Reserva();
        reserva.cliente = cliente;

        var response = given()
                .contentType(ContentType.JSON)
                .body(JsonbBuilder.create().toJson(reserva))
                .when().post()
                .then().extract().response();
        assertEquals(201, response.statusCode());


    }

    @Test
    @DisplayName("Should list all reservas")
    @Order(2)
    void listAllReservas() {
        given()
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .body("size()", Matchers.is(1));
    }



}