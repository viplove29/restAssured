package org.example;

import static io.restassured.RestAssured.given;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

public class testPutApi {

  @Test
  public void testPutApiTest() {
    String endpoint = "https://reqres.in/api/users/2";
    String body =
        """
                {
                       "name": "morpheus",
                       "job": "zion resident"
                   }
                        """;

    ValidatableResponse responsePut =
        given().body(body).when().put(endpoint).then().assertThat().statusCode(200);
    responsePut.log().body();
    responsePut.log().everything();
  }
}
