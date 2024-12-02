package org.example;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class getApiTest {
  @Test
  public void testGetApiTest() {
    String endpoint = "https://reqres.in/api/users";
    ValidatableResponse response =
        RestAssured.given()
            .queryParam("page", 1)
            .when()
            .get(endpoint)
            .then()
            .assertThat()
            .statusCode(200)
            .body("data.email", Matchers.hasItem("janet.weaver@reqres.in"));
    response.log().body();
  }

  @Test
  public void getSingleUserApiTest() {
    String endpoint = "https://reqres.in/api/users/3";
    ValidatableResponse response =
        RestAssured.given()
            .when()
            .get(endpoint)
            .then()
            .assertThat()
            .statusCode(200)
            .body("data.id", Matchers.equalTo(3))
            .body("data.email", Matchers.equalTo("emma.wong@reqres.in"));
    response.log().body();
  }
}
