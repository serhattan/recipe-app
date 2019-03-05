package com.springframework.recipeapp.controllers.bootstrap;

import com.springframework.recipeapp.controllers.model.*;
import com.springframework.recipeapp.controllers.repositories.CategoryRepository;
import com.springframework.recipeapp.controllers.repositories.RecipeRepository;
import com.springframework.recipeapp.controllers.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
        log.debug("Loading Bootstap Data");
    }

    private List<Recipe> getRecipes() {

        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByUom("Pinch");

        if (!pinchUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> tableSpoonUomUomOptional = unitOfMeasureRepository.findByUom("Tablespoon");

        if (!tableSpoonUomUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByUom("Teaspoon");

        if (!teaSpoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByUom("Dash");

        if (!dashUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByUom("Ounce");

        if (!ounceUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        UnitOfMeasure eachUom = pinchUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomUomOptional.get();
        UnitOfMeasure teaSpoonUom = teaSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = ounceUomOptional.get();

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if (!americanCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if (!mexicanCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category Not Found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

        Recipe tacoRecipe = new Recipe();
        tacoRecipe.setDescription("Spicy grilled chicken tacos! Quick marinade, then grill.");
        tacoRecipe.setPrepTime(20);
        tacoRecipe.setCookTime(15);
        tacoRecipe.setServing(5);
        tacoRecipe.setDifficulty(Difficulty.MEDIUM);
        //spcyGrldChknTaco.setSource("www.simplyrecipes.com");
        //spcyGrldChknTaco.setUrl("http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        tacoRecipe.setDirections("Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, " +
                "cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose " +
                "paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer " +
                "inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. " +
                "As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for " +
                "a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. " +
                "Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned " +
                "sour cream. Serve with lime wedges.\n");

        Note note = new Note();
        note.setRecipeNotes("Any and every kind of leftover can go inside a warm tortilla, " +
                "usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night " +
                "snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and " +
                "sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble " +
                "the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "The ancho chiles I use in the marinade are named for their wide shape. They are large, have a deep " +
                "reddish brown color when dried, and are mild in flavor with just a hint of heat. You can find " +
                "ancho chile powder at any markets that sell Mexican ingredients, or online.\n" +
                "I like to put all the toppings in little bowls on a big platter at the center of the table: " +
                "avocados, radishes, tomatoes, red onions, wedges of lime, and a sour cream sauce. " +
                "I add arugula, as well – this green isn’t traditional for tacos, but we always seem to have some " +
                "in the fridge and I think it adds a nice green crunch to the tacos.\n");

        tacoRecipe.setNote(note);


        tacoRecipe.getIngredients().add(new Ingredient("ancho chili powder",new BigDecimal(2), tableSpoonUom));
        tacoRecipe.getIngredients().add(new Ingredient("dried oregano",new BigDecimal(1),teaSpoonUom));
        tacoRecipe.getIngredients().add(new Ingredient("dried cumin",new BigDecimal(1),teaSpoonUom));
        tacoRecipe.getIngredients().add(new Ingredient("sugar",new BigDecimal(1),teaSpoonUom));
        tacoRecipe.getIngredients().add(new Ingredient("salt",new BigDecimal(1/2),teaSpoonUom));
        tacoRecipe.getIngredients().add(new Ingredient("finely chopped garlic clove",new BigDecimal(1),dashUom));
        tacoRecipe.getIngredients().add(new Ingredient("finely grated orange zest",new BigDecimal(1),tableSpoonUom));
        tacoRecipe.getIngredients().add(new Ingredient("fresh squeezed orange juice",new BigDecimal(3),tableSpoonUom));
        tacoRecipe.getIngredients().add(new Ingredient("olive oil",new BigDecimal(2),tableSpoonUom));
        tacoRecipe.getIngredients().add(new Ingredient("chicken thighs",new BigDecimal(5),dashUom));
        tacoRecipe.getIngredients().add(new Ingredient("corn tortillas",new BigDecimal(8),dashUom));
        tacoRecipe.getIngredients().add(new Ingredient("baby arugula",new BigDecimal(3),eachUom));
        tacoRecipe.getIngredients().add(new Ingredient("sliced ripe avocados",new BigDecimal(2),dashUom));
        tacoRecipe.getIngredients().add(new Ingredient("thinly sliced radishes",new BigDecimal(4),dashUom));
        tacoRecipe.getIngredients().add(new Ingredient("halved cherry tomatoes",new BigDecimal(0.5),pintUom));
        tacoRecipe.getIngredients().add(new Ingredient("thinly sliced red onions",new BigDecimal(0.25),dashUom));
        tacoRecipe.getIngredients().add(new Ingredient("roughly chopped cilantro",new BigDecimal(1),pintUom));
        tacoRecipe.getIngredients().add(new Ingredient("sour cream",new BigDecimal(0.5),eachUom));
        tacoRecipe.getIngredients().add(new Ingredient("wedges cut lime",new BigDecimal(1),dashUom));

        tacoRecipe.getCategories().add(americanCategory);
        tacoRecipe.getCategories().add(mexicanCategory);

        recipes.add(tacoRecipe);

        return recipes;
    }
}
