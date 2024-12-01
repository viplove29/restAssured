package org.example;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

public class testGetApi {
  @Test
  public void testGetApiTest() {
    String endpoint = "https://reqres.in/api/users";
    ValidatableResponse response =
        given()
            .queryParam("page", 1)
            .when()
            .get(endpoint)
            .then()
            .assertThat()
            .statusCode(200)
            .body("data.email", hasItem("janet.weaver@reqres.in"));
    response.log().body();
  }

  @Test
  public void testGetSingleUserApi() {
    String endpoint = "https://reqres.in/api/users/3";
    ValidatableResponse response =
        given()
            .when()
            .get(endpoint)
            .then()
            .assertThat()
            .statusCode(200)
            .body("data.id", equalTo(3))
            .body("data.email", equalTo("emma.wong@reqres.in"));
    response.log().body();
  }
}
