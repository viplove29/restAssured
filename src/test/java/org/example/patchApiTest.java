package org.example;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

public class patchApiTest {

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
        RestAssured.given().body(body).when().patch(endpoint).then().assertThat().statusCode(200);
    responsePatch.log().body();
    responsePatch.log().status();
    responsePatch.log().everything();
  }
}
