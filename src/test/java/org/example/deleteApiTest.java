package org.example;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

public class deleteApiTest {

  @Test
  public void testDeleteApiTest() {

    // Base URL for the API
    RestAssured.baseURI = "https://reqres.in";

    String endpoint = "/api/users/2";

    ValidatableResponse responseDelete =
        RestAssured.given()
            .header("Content-Type", "application/json")
            .when()
            .delete(endpoint)
            .then()
            .assertThat()
            .statusCode(204);
    responseDelete.log().body();
    responseDelete.log().everything();
  }
}
