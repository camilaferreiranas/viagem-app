package br.com.camilaferreiranas.cliente;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jakarta.json.bind.JsonbBuilder;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class ClienteResourceTest {

    @Test
    @DisplayName("Should list all clients")
    void listAllUsers() {

        given()
                .contentType(ContentType.JSON)
                .when().get("/cliente")
                .then()
                .statusCode(200)
                .body("size()", Matchers.is(4));

    }

    @Test
    @DisplayName("Should present a user given an id")
    void findUserById() {
        var userId = 1;
        var response = given()
                .queryParam("id", userId)
                .contentType(ContentType.JSON)
                .when().get("/cliente/findById")
                .then()
                .extract().response();
        assertNotNull(response.jsonPath().getString("id"));

    }

    @Test
    @DisplayName("Should delete the client using the id")
    void deleteClientById() {
        var clientId = 2;
        given()
                .queryParam("id", clientId)
                .when().delete("/cliente/deleteById")
                .then()
                .statusCode(204);

    }

    @Test
    @DisplayName("Should create a cliente")
    void createCliente() {
        var body = new Cliente();
        body.nome = "Camila";
        var response = given()
                .contentType(ContentType.JSON)
                .body(JsonbBuilder.create().toJson(body))
                .when()
                .post("/cliente")
                .then().extract().response();

        assertEquals(201, response.statusCode());
        assertNotNull(response.jsonPath().getString("id"));


    }
}