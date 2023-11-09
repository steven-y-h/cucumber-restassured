package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

public class FooterStep {
    Response response;

    @Given("[Footer] send {string} request to {string}")
    public void footerSendRequestTo(String method, String url) throws Exception {
        switch (method) {
            case "GET" -> response = given().contentType(ContentType.JSON).get(url);
            case "POST" -> response = post(url);
            default -> throw new Exception();
        }
        //System.out.println(response.prettyPrint());
    }

    @Then("[Footer] validate json schema by {string}")
    public void footerValidateJsonSchemaBy(String path) {
        assertThat("Json schema is not valid", response.getBody().prettyPrint(), matchesJsonSchemaInClasspath(path));
    }
}
