package org.example;


import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class testGetApi {
    @Test
    public void testGetApi() {
        String endpoint="https://reqres.in/api/users";
        ValidatableResponse response = given().queryParam("page", 2).when().get(endpoint).then();
        response.log().body();

    }
}