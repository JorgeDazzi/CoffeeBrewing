package br.dazzi.molecularcoffeebrewing;

import android.util.Log;

import com.ramotion.fluidslider.FluidSlider;

import br.dazzi.molecularcoffeebrewing.FluidSliderConfig.FluidSliderConfig;
import br.dazzi.molecularcoffeebrewing.formula.DzFormula;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

class MolecularCoffeeHandle {

    private DzFormula secret = new DzFormula();
    private FluidSliderConfig waterBar;
    private FluidSliderConfig coffeeBar;
    private FluidSliderConfig cupBar;

    public MolecularCoffeeHandle(FluidSliderConfig waterBar, FluidSliderConfig coffeeBar, FluidSliderConfig cupBar) {
        this.waterBar = waterBar;
        this.coffeeBar = coffeeBar;
        this.cupBar = cupBar;

        this.setListenerCupBar();
        this.setListenerCoffeeBar();
        this.setListenerWaterBar();
    }

    private void setListenerCupBar(){

        this.cupBar.getSlider().setEndTrackingListener(() -> {

            //Get Cups from Cup Slider bar
                final float cups = this.cupBar.getSliderPosition();
                Log.d("Cup-Amount", ""+cups);
                Log.d("Cup-Amount-original", ""+this.cupBar.getSlider().getPosition());

            //Calc Coffee Grounds Amount [ g ]
                final float coffee = this.secret.getCoffeeAmountByCups(cups);
                Log.d("Coffee-Amount", ""+coffee);
                this.coffeeBar.setSliderPosition(coffee);

            //Calc Water Amount [ ml || cc ]
                final float water = this.secret.getWaterAmountByCups(cups);
                Log.d("Water-Amount", ""+water);
                this.waterBar.setSliderPosition(water);

            return Unit.INSTANCE;
        });
    }

    private void setListenerCoffeeBar(){
        this.coffeeBar.getSlider().setEndTrackingListener(() -> {

            //Get Coffee from Coffee Slider bar
                final float coffee = this.coffeeBar.getSliderPosition();
                Log.d("CB-Coffee-Amount", ""+coffee);

            //Calc Cup Grounds Amount [ g ]
                final float cup = this.secret.getCupsAmountByCoffee(coffee);
                Log.d("CB-Cup-Amount", ""+cup);
                this.cupBar.setSliderPosition(cup);

            //Calc Water Amount [ ml || cc ]
                final float water = this.secret.getWaterAmountByCoffee(coffee);
                Log.d("CB-Water-Amount", ""+water);
                this.waterBar.setSliderPosition(water);

            return Unit.INSTANCE;
        });
    }

    private void setListenerWaterBar(){
        this.waterBar.getSlider().setEndTrackingListener(() -> {

            //Get Water from Water Slider bar
            final float water = this.waterBar.getSliderPosition();
            Log.d("WB-Water-Amount", ""+water);

            //Calc Coffee Grounds Amount [ g ]
            final float cup = this.secret.getCupsAmountByWater(water);
            Log.d("WB-Cup-Amount", ""+cup);
            this.cupBar.setSliderPosition(cup);

            //Calc Water Amount [ ml || cc ]
            final float coffee = this.secret.getCoffeeAmountByWater(water);
            Log.d("WB-Coffee-Amount", ""+coffee);
            this.coffeeBar.setSliderPosition(coffee);

            return Unit.INSTANCE;
        });
    }

    private void setDisableListener(FluidSlider slider){
        slider.setEndTrackingListener(() -> null);
    }

}
