package org.example;

import static io.restassured.RestAssured.given;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

public class testPatchApi {

  @Test
  public void testPatchApiTest() {
    String endpoint = "https://reqres.in/api/users/2";
    String body =
        """
                {
                       "name": "morpheus",
                       "job": "zion resident3333"
                   }
                        """;

    ValidatableResponse responsePatch =
        given().body(body).when().patch(endpoint).then().assertThat().statusCode(200);
    responsePatch.log().body();
    responsePatch.log().status();
    responsePatch.log().everything();
  }
}
