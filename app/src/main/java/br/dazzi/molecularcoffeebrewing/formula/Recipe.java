package br.dazzi.molecularcoffeebrewing.formula;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Recipe {

    private int cups;
    private int water;
    private int coffeeGrounds;

}
