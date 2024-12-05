package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
                       "name": "viplove",
                       "job": "zion resident3333"
                   }
                        """;

    ValidatableResponse responsePatch =
        RestAssured.given()
            .header("Content-Type", "application/json")
            .body(body)
            .when()
            .patch(endpoint)
            .then()
            .assertThat()
            .statusCode(200);

    // Logging response details
    responsePatch.log().ifValidationFails();
    responsePatch.log().body();

    String name = responsePatch.extract().path("name");
    assertEquals("viplove", name);

    String job = responsePatch.extract().path("job");
    assertEquals("zion resident3333", job);
  }
}
