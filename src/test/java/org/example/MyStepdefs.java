package org.example;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class MyStepdefs {
    private int firstNumber;
    private int secondNumber;
    private int result;
    private Scenario scenario;

    @Before
    public void setup(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("I have first number {int}")
    public void iHaveFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
        scenario.log("First number: " + this.firstNumber);
    }

    @Given("I have second number {int}")
    public void iHaveSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
        scenario.log("Second number: " + this.secondNumber);
    }

    @When("I add them together")
    public void iAddThemTogether() {
        result = firstNumber + secondNumber;
    }

    @Then("Result will be {int}")
    public void resultWillBe(int result) {
        scenario.log("Result: " + this.result);
        Assertions.assertEquals(result, this.result);
    }
}
