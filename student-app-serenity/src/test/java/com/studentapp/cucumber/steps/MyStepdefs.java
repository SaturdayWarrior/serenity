package com.studentapp.cucumber.steps;


import com.studentapp.studentinfo.StudentSteps;
import com.studentapp.utils.TestUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.Matchers.hasValue;


public class MyStepdefs {
static String email = null;
    static ValidatableResponse responce;
    @Steps
    StudentSteps studentSteps;

    @When("^User sends a GET request to list endpoint$")
    public void userSendsAGETRequestToListEndpoint() {
        responce = studentSteps.getAllStudentInfo();
    }

    @Then("^User must get back a valid status code 200$")
    public void userMustGetBackAValidStatusCode() {
        responce.statusCode(200);

    }

    @When("^I create a new student by providing the information firstName \"([^\"]*)\" lastName \"([^\"]*)\" email \"([^\"]*)\" programme \"([^\"]*)\" courses \"([^\"]*)\"$")
    public void iCreateANewStudentByProvidingTheInformationFirstNameLastNameEmailProgrammeCourses(String firstName, String lastName, String _email, String programme, String courses) {
        List<String> courseList = new ArrayList<>();
        courseList.add(courses);
        email = TestUtils.getRandomValue()+ _email;
        responce = studentSteps.createStudent(firstName,lastName,email,programme,courseList);
    }

    @Then("^I verify that the student with \"([^\"]*)\" is created$")
    public void iVerifyThatTheStudentWithIsCreated(String _email) {
        responce.statusCode(200);
        HashMap<String, Object> studentInfo = studentSteps.getStudentInfoByEmail(_email);
        Assert.assertThat(studentInfo,hasValue(email));

    }
}
