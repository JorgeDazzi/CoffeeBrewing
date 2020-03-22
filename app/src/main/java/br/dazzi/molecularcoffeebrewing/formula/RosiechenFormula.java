package br.dazzi.molecularcoffeebrewing.formula;

public class RosiechenFormula extends Formula {

    public RosiechenFormula() {
        super(
                new CoffeeRatio(
                17,
                "ml",
                1,
                "g",
                59,
                "ml"
                ),
                59,
                30,
                "Rosiechen Crema"
        );
    }
}
