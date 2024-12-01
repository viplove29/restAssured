package org.example;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

public class postApiTest {

  @Test
  public void testPostApiTest() {
    String endpoint = "https://reqres.in/api/users";
    String body =
        """
                    {
                          "name": "viplove2",
                          "job": "leader"
                      }
                    """;

    ValidatableResponse responsePost =
        RestAssured.given().body(body).when().post(endpoint).then().assertThat().statusCode(201);
    responsePost.log().body();
    responsePost.log().everything();
  }
}
