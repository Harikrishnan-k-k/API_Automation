package Base;

import Actions.AssertActions;
import endpoints.APIConstants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import modules.payload;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public payload payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;


    @BeforeTest
    public void setConfig(){
        System.out.println("Before test");
        System.out.println("Before Test");
        payloadManager = new payload();
        assertActions = new AssertActions();
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstants.BaseURL)
                .addHeader("Content-Type","application/json")
                .build().log().all();

/*
        requestSpecification = RestAssured.
                given()
                .baseUri(APIConstants.BASE_URL)
                .contentType(ContentType.JSON)
                .log().all();
*/
    }

    public String getToken(){
        return null;
    }
}
