package org.DogApi.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;

public class ApiSteps extends UIInteractions {

  private String url = "https://dog.ceo/api/breeds/";
  private Response response;

    @Given("There are breeds available in the API")
    public void getavailableBreeds(){
      response = SerenityRest.get(url + "list/all");

    }

    @Then("I should get all the dog breeds")
    public void all_dog_breeds_returned_succesfully(){
      response.prettyPeek();
      response.then().statusCode(200);
    }

    @Then("{breed} should be in the list")
    public void verify_breed_is_on_the_list(String breedName)
    {
      //we check for value inside retriever if the value
      response.then().body("message", Matchers.hasKey(breedName));
      System.out.println("Retriever is within the list");
    }

    @Given("I request for a random dog image")
    public void requestRandomImage()
    {
      response = SerenityRest.get(url + "image/random");

    }

    @Then("I should get a random image")
    public void getRandomImage(){
      response.then().statusCode(200);
      response.prettyPeek();
    }
}