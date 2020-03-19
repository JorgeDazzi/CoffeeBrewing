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
    private int cup = 59; //ml

    public String getRatios(){
        return String.format("%s:%s",this.pureWater, this.coffeeGrounds);
    }


    public int getCoffeeAmountByCups(int cups){
        //grams
        return (int) Math.round( (this.cup * cups * 1.0) / this.pureWater );
    }


    public int getWaterAmountByCups(int cups){
        //ml || cc
        return (int) Math.round(this.cup * cups * 1.0);
    }


    public int getCoffeeAmountByWater(int water){
        //grams
        return (int) Math.round( water / ( this.pureWater * 1.0) );
    }


    public int getCupsAmountByWater(int water){
        //ml || cc
        return (int) Math.round ( water / (this.cup * 1.0));
    }

    public int getWaterAmountByCoffee(int coffee){
        //grams
        return (int) Math.round( coffee * this.pureWater * 1.0 );
    }


    public int getCupsAmountByCoffee(int coffee){
        //ml || cc
        return (int) Math.round ( (coffee * this.pureWater * 1.0) / this.cup );
    }


}
