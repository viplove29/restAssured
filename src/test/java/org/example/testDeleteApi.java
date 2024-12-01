package org.example;

import static io.restassured.RestAssured.given;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

public class testDeleteApi {

  @Test
  public void testDeleteApi() {
    String endpoint = "https://reqres.in/api/users/2";
    ValidatableResponse responseDelete =
        given().when().delete(endpoint).then().assertThat().statusCode(204);
    responseDelete.log().body();
    responseDelete.log().everything();
  }
}
