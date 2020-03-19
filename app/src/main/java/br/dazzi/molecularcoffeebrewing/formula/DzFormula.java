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
    private double cup = 59.3; //ml

    public String getFormula() {
        return formula;
    }

    private String formula = "D.[Z^2] v1.5";

    public String getRatios(){
        return String.format("%s:%s",this.pureWater, this.coffeeGrounds);
    }


    public float getCoffeeAmountByCups(float cups){
        //grams
        return (int) Math.round( (this.cup * cups * 1.0) / this.pureWater );
        //return (float) ((this.cup * cups * 1.0) / this.pureWater);
    }


    public float getWaterAmountByCups(float cups){
        //ml || cc
        return (float) Math.round(this.cup * cups * 1.0);
        //return (float) (this.cup * cups * 1.0);
    }


    public float getCoffeeAmountByWater(float water){
        //grams
        return (int) Math.round( water / ( this.pureWater * 1.0) );
        //return (float) (water / ( this.pureWater * 1.0));
    }


    public float getCupsAmountByWater(float water){
        //ml || cc
        return (int) Math.round ( water / (this.cup * 1.0));
        //return (float) ( water / (this.cup * 1.0));
    }

    public float getWaterAmountByCoffee(float coffee){
        //grams
        return (int) Math.ceil( coffee * this.pureWater * 1.0 );
        //return (float) ( coffee * this.pureWater * 1.0 );
    }


    public float getCupsAmountByCoffee(float coffee){
        //ml || cc
        return (int) Math.ceil ( (coffee * this.pureWater * 1.0) / this.cup );
        //return (float) ( (coffee * this.pureWater * 1.0) / this.cup * 1.0 );
    }


}
