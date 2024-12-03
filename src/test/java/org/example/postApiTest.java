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
                    """; // The multi-line string format using triple quotes (""") for JSON (or any text)
    // was introduced in Java 15 as part of the Text Blocks feature
    ValidatableResponse responsePost =
        RestAssured.given().body(body).when().post(endpoint).then().assertThat().statusCode(201);
    responsePost.log().body();
    responsePost.log().everything();
  }

  @Test
  public void testPostRegisterApiTest() {
    String endpoint1 = "https://reqres.in/api/register";
    String body1 =
        """
                    {
                        "email": "eve.holt@reqres.in",
                        "password": "pistol"
                    }
                        """;

    ValidatableResponse responsePost1 =
        RestAssured.given()
            .header("Content-Type", "application/json")
            .body(body1)
            .when()
            .post(endpoint1)
            .then()
            .assertThat()
            .statusCode(200);
    responsePost1.log().body();
    responsePost1.log().everything();
  }
}
