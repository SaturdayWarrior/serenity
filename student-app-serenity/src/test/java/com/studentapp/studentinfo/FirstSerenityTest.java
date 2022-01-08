package com.studentapp.studentinfo;

import com.studentapp.constants.EndPoints;
import com.studentapp.testbase.TestBase;
import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest extends TestBase {

    @Test
    public void getAllStudents() {
        RestAssured.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_STUDENT)
                .then()
                .log().all()
                .statusCode(200);

    }

}
