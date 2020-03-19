package br.dazzi.molecularcoffeebrewing.formula;

/**
 * Quickly reminder,
 * if you are going to change this measurement.
 * please don't mix Metric with Imperial measures (vice versa).
 * if you are this kind, you have your place in hell booked.
 */
public class DzFormula {

    private int coffeeGrounds = 1;
    private int pureWater = 17;
    private int cup = 177; //ml

    public String getRatios(){
        return String.format("%s:%s",this.pureWater, this.coffeeGrounds);
    }


    public int getCoffeeAmount(int cups){
        //grams
        return (int) Math.round( (this.cup * cups * 1.0) / this.pureWater );
    }


    public int getWaterAmount(int cups){
        //ml || cc
        return (int) Math.round(this.cup * cups * 1.0);
    }


}
