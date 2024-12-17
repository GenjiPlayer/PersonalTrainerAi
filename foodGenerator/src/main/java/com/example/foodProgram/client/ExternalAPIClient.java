package com.example.foodProgram.client;

import com.example.foodProgram.model.foodModel;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

    @Component
    public class ExternalAPIClient {
//adder api ting her::::
        public List<foodModel> fetchGainWeightMeals() {
            return Arrays.asList(
                    new foodModel(
                            "Stracciatella (Italian Wedding Soup)",
                            "3 1/2 c Chicken broth; homemade|1 lb Fresh spinach; wash/trim/chop|1 Egg|1 c Grated parmesan cheese|Salt and pepper; to taste",
                            "Bring 1 cup of the broth to a boil. Add spinach and cook until softened but still bright green. Remove spinach with a slotted spoon and set aside. " +
                                    "Add remaining broth to pot. Bring to a boil. Meanwhile, beat egg lightly with a fork. Beat in 1/4 cup of cheese. When broth boils pour in egg mixture, stirring constantly for a few seconds until it cooks into 'rags'. " +
                                    "Add reserved spinach, salt and pepper. Serve immediately, passing remaining cheese.",
                            "4 servings"
                    ),
                    new foodModel(
                            "Stracciatella (Italian Wedding Soup)",
                            "3 1/2 c Chicken broth; homemade|1 lb Fresh spinach; wash/trim/chop|1 Egg|1 c Grated parmesan cheese|Salt and pepper; to taste",
                            "Bring 1 cup of the broth to a boil. Add spinach and cook until softened but still bright green. Remove spinach with a slotted spoon and set aside. " +
                                    "Add remaining broth to pot. Bring to a boil. Meanwhile, beat egg lightly with a fork. Beat in 1/4 cup of cheese. When broth boils pour in egg mixture, stirring constantly for a few seconds until it cooks into 'rags'. " +
                                    "Add reserved spinach, salt and pepper. Serve immediately, passing remaining cheese.",
                            "4 servings"
                    )
            );
        }

        public List<foodModel> fetchLoseWeightMeals() {
            return Arrays.asList(
                    new foodModel(
                            "Stracciatella (Italian Wedding Soup)",
                            "3 1/2 c Chicken broth; homemade|1 lb Fresh spinach; wash/trim/chop|1 Egg|1 c Grated parmesan cheese|Salt and pepper; to taste",
                            "Bring 1 cup of the broth to a boil. Add spinach and cook until softened but still bright green. Remove spinach with a slotted spoon and set aside. " +
                                    "Add remaining broth to pot. Bring to a boil. Meanwhile, beat egg lightly with a fork. Beat in 1/4 cup of cheese. When broth boils pour in egg mixture, stirring constantly for a few seconds until it cooks into 'rags'. " +
                                    "Add reserved spinach, salt and pepper. Serve immediately, passing remaining cheese.",
                            "4 servings"
                    ),
                    new foodModel(
                            "Stracciatella (Italian Wedding Soup)",
                            "3 1/2 c Chicken broth; homemade|1 lb Fresh spinach; wash/trim/chop|1 Egg|1 c Grated parmesan cheese|Salt and pepper; to taste",
                            "Bring 1 cup of the broth to a boil. Add spinach and cook until softened but still bright green. Remove spinach with a slotted spoon and set aside. " +
                                    "Add remaining broth to pot. Bring to a boil. Meanwhile, beat egg lightly with a fork. Beat in 1/4 cup of cheese. When broth boils pour in egg mixture, stirring constantly for a few seconds until it cooks into 'rags'. " +
                                    "Add reserved spinach, salt and pepper. Serve immediately, passing remaining cheese.",
                            "4 servings"
                    )
            );
        }
    }

}
