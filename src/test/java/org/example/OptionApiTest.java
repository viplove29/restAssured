package org.example;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

public class OptionApiTest {

  @Test
  public void testOptionApiTest() {
    String endpoint = "https://reqres.in/api/users";
    ValidatableResponse response =
        RestAssured.given().when().options(endpoint).then().assertThat().statusCode(204);
    response.log().everything();
  }
}
