package org.example;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
                       "name": "morpheusViplove",
                       "job": "zion resident"
                   }
                        """;

    ValidatableResponse responsePut =
        RestAssured.given()
            .header("Content-Type", "application/json")
            .body(body)
            .when()
            .put(endpoint)
            .then()
            .assertThat()
            .statusCode(200)
            .time(lessThan(3000L));

    // Logging response details
    responsePut.log().ifValidationFails();
    responsePut.log().body();

    String name = responsePut.extract().path("name");
    assertEquals("morpheusViplove", name);

    String job = responsePut.extract().path("job");
    assertEquals("zion resident", job);
  }
}
