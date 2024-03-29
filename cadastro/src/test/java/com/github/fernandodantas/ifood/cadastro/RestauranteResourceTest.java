package com.github.fernandodantas.ifood.cadastro;

import javax.ws.rs.core.Response.Status;

import com.github.database.rider.core.api.dataset.DataSet;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.approvaltests.Approvals;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;


import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;


@DBRider
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE)
@QuarkusTest
//@QuarkusTestResource(CadastroTestLifecycleManager.class) versão mais atual não precisa desse trecho de código
public class RestauranteResourceTest {

    @Test
    @DataSet("restaurantes-cenario-1.yml")
    public void testBuscarRestaurantes() {
        String resultado = given()
                .when().get("/restaurantes")
                .then()
                .statusCode(Status.OK.getStatusCode())
                .extract().asString();
        Approvals.verifyJson(resultado);
    }

    private RequestSpecification given() {
        return RestAssured.given()
                .contentType(ContentType.JSON);
    }

    @Test
    @DataSet("restaurantes-cenario-1.yml")
    public void testAlterarRestaurante() {
        Restaurante dto = new Restaurante();
        dto.nome = "novoNome";
        Long parameterValue = 123L;
        given()
                .with().pathParam("id", parameterValue)
                .body(dto)
                .when().put("/restaurantes/{id}")
                .then()
                .statusCode(Status.NO_CONTENT.getStatusCode())
                .extract().asString();

        Restaurante findById = Restaurante.findById(parameterValue);

        //poderia testar todos os outros atribudos
        Assert.assertEquals(dto.nome, findById.nome);

    }
}