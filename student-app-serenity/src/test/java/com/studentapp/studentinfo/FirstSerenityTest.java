package com.studentapp.studentinfo;

import com.studentapp.constants.EndPoints;
import com.studentapp.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest extends TestBase {

    @Test
    public void getAllStudents() {
        SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_STUDENT)
                .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void thisIsFailing() {
        SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_STUDENT)
                .then()
                .log().all()
                .statusCode(400);
    }

    @Pending
    @Test
    public void thisIsASkip() {

    }

    @Test
    public void thisIsTestWithError() {
        System.out.println("this is error test " + (5 / 0));
    }

    @Test
    public void manual() {

    }

    @Test
    public void thisIsCompromised() throws FileNotFoundException {
        File file = new File("E://file.txt");
        FileReader fr = new FileReader(file);
    }


    @Title("This test will get all student details")
    @Test
    public void test001() {
        SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_STUDENT)
                .then()
                .log().all()
                .statusCode(200);

    }
}