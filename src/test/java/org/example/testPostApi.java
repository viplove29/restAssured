package org.example;

import static io.restassured.RestAssured.given;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

public class testPostApi {

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
        given().body(body).when().post(endpoint).then().assertThat().statusCode(201);
    responsePost.log().body();
    responsePost.log().everything();
  }
}
