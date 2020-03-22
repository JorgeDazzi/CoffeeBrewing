package br.dazzi.molecularcoffeebrewing.formula;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CoffeeRatio {


    private int waterRatio;
    private String waterUnit;

    private int coffeeRatio;
    private String coffeeUnit;

    private int cupRatio;
    private String cupUnit;



}
