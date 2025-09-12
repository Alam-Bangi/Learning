class RecipeRunner {
    public static void main(String[] args) {
        Recipe1 recipe = new Recipe1();
        recipe.execute();
        
        RecipeWithMicrowave recipeWithMicrowave = new RecipeWithMicrowave();
        recipeWithMicrowave.execute();
    }
}
abstract class AbstractRecipe {
    void execute() {
        getReady();
        doTheDish();
        cleanup();
    } 
    abstract void getReady();
    abstract void doTheDish();
    abstract void cleanup();
}

class Recipe1 extends AbstractRecipe {
    void getReady() {
        System.out.println("Get the raw materials");
        System.out.println("Get the utensils");
    }
    void doTheDish() {
        System.out.println("Do the Dish");
    }
    void cleanup() {
        System.out.println("Cleanup the utensils");
    }
}

class RecipeWithMicrowave extends AbstractRecipe {
    void getReady() {
        System.out.println("Get the raw materials");
        System.out.println("Switch on the microwave");
    }
    void doTheDish() {
        System.out.println("Get stuff ready to cook");
        System.out.println("Put it in the microwave");
    }
    void cleanup() {
        System.out.println("Cleanup the utensils");
        System.out.println("Switch off the microwave");
    }
}