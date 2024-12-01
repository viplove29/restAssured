package org.example;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

public class deleteApiTest {

  @Test
  public void testDeleteApiTest() {
    String endpoint = "https://reqres.in/api/users/2";
    ValidatableResponse responseDelete =
        RestAssured.given().when().delete(endpoint).then().assertThat().statusCode(204);
    responseDelete.log().body();
    responseDelete.log().everything();
  }
}
