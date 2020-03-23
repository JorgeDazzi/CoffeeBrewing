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
                "Cup"
                ),
                59,
                30,
                "Rosiechen Crema"
        );
    }
}
