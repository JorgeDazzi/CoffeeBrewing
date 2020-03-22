package br.dazzi.molecularcoffeebrewing.formula;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Formula {

    private CoffeeRatio ratio;
    private float cupVolume;//ml
    private int cupLimit;
    private String formulaName;


    public String getFormulaSignature(){
        return String.format(
                "%s: [%s:%s]\nCup Limit: %s",
                this.formulaName,
                this.ratio.getWaterRatio(),
                this.ratio.getCoffeeRatio(),
                this.cupLimit
        );
    }

    public int getMaxCup(){
        return this.cupLimit;
    }

    public int getMaxWater(){
        return (int) Math.ceil( this.cupLimit * this.cupVolume );
    }

    public int getMaxCoffee(){
        return (int) Math.ceil( (this.cupLimit * this.cupVolume) / this.ratio.getWaterRatio() );
    }

    private Recipe getProportionByCup(float cups){

        return new Recipe(
                Math.round( cups ),
                Math.round( (this.cupVolume * cups) ),
                Math.round( (this.cupVolume * cups) / this.ratio.getWaterRatio() )
        );
    }

    private Recipe getProportionByWater(float water){

        return new Recipe(
                Math.round( water / this.cupVolume ),
                Math.round( (this.cupVolume * (water / this.cupVolume)) ),
                Math.round( (this.cupVolume * (water / this.cupVolume)) / this.ratio.getWaterRatio() )
        );
    }

    private Recipe getProportionByCoffee(float coffee){

        return new Recipe(
                Math.round( (coffee * this.ratio.getWaterRatio()) / this.cupVolume ),
                Math.round( coffee * this.ratio.getWaterRatio() ),
                Math.round( coffee )
        );
    }

    public Recipe getProportion(String item, float amount ){
        switch (item){
            case "Coffee":
                return this.getProportionByCoffee(amount);
            case "Water":
                return this.getProportionByWater(amount);
            case "Cup":
                return this.getProportionByCup(amount);
            default:
                return this.getProportionByCup(0);
        }
    }


}
