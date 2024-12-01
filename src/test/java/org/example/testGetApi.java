package org.example;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

public class testGetApi {
  @Test
  public void testGetApi() {
    String endpoint = "https://reqres.in/api/users";
    ValidatableResponse response =
        given().queryParam("page", 452).when().get(endpoint).then().assertThat().statusCode(200);
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
    System.out.println(response.log().body());
  }
}
