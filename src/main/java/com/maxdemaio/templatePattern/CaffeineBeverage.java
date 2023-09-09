package com.maxdemaio.templatePattern;

public abstract class CaffeineBeverage {
    public final void prepareRecipe() {
        /**
         * Now, the same prepareRecipe() method will be used to make both Tea and Coffee.
         * prepareRecipe() is declared final because we don’t want our subclasses
         * to be able to override this method and change the recipe!
         * We’ve generalized steps 2 and 4 to brew() the beverage and addCondiments().
         * Because Coffee and Tea handle these methods in different ways,
         * they’re going to have to be declared as abstract.
         * Let the subclasses worry about that stuff!
         * Remember, we moved these into the CaffeineBeverage class (back in our class diagram).
         */

        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }
}