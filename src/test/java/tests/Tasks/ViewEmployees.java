package tests.Tasks;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewEmployees {

    //1. Use any 2 methods(Get, and Delete) from end-points listed in
    //  http://dummy.restapiexample.com/
    //2. Perform assertions for
    //   - Get & Delete - Status code to be Successful.
    //   - Get - Return specific Employee details(Any).
    //   - Delete - "message": "successfully! deleted Records".

    @Test
    public void viewEmployeesTest1(){

        //http://dummy.restapiexample.com/api/v1/employees
        Response response = RestAssured.get("http://dummy.restapiexample.com/api/v1/employees");

        System.out.println(response.statusCode());
        System.out.println(response.body().prettyPeek());
    }

    @Test
    public void VerifyEmployeesTest2(){

        Response response = RestAssured.get("http://dummy.restapiexample.com/api/v1/employees");

        //Verify Status code 200
        Assert.assertEquals(response.statusCode(),200);

        //Verify body contains Tiger Nixon
        Assert.assertTrue(response.body().asString().contains("Tiger Nixon"));

    }


    @Test
    public void DeleteEmployee() {

        Response response = RestAssured.given().
                when().delete("http://dummy.restapiexample.com/api/v1/delete/3")
                .then().assertThat().statusCode(200)
                .log().body().extract().response();

        String jsonString = response.asString();

        Assert.assertEquals(jsonString.contains("Successfully! Record has been deleted"),true);


         }

    }
