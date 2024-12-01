package org.example;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

public class putApiTest {

  @Test
  public void putApiTest() {
    String endpoint = "https://reqres.in/api/users/2";
    String body =
        """
                {
                       "name": "morpheus",
                       "job": "zion resident"
                   }
                        """;

    ValidatableResponse responsePut =
        RestAssured.given().body(body).when().put(endpoint).then().assertThat().statusCode(200);
    responsePut.log().body();
    responsePut.log().everything();
  }
}
