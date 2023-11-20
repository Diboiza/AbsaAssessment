package org.DogApi.tests;

import io.cucumber.java.bm.Tetapi;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.DogApi.steps.ApiSteps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

//@RunWith(SerenityRunner.class)
@ExtendWith(SerenityJUnit5Extension.class)
public class DogSearchTests extends UIInteractions {

    public ApiSteps dogsearch;

    @Test
    public void getAllDogBreeds()
    {
        dogsearch.getavailableBreeds();
        dogsearch.all_dog_breeds_returned_succesfully();
        dogsearch.verify_breed_is_on_the_list("retriever");
    }

    @Test
    public void getRandomImage()
    {
        dogsearch.requestRandomImage();
        dogsearch.getRandomImage();
    }
}
