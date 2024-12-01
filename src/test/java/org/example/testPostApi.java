package org.example;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class testPostApi {

    @Test
    public void testPostApi() {
        String endpoint="https://reqres.in/api/users";
        String body = """
                {
                      "name": "viplove2",
                      "job": "leader"
                  }
                """;

        ValidatableResponse response1 = given().body(body).
                when().post(endpoint).then();
        response1.log().body();

    }
}
