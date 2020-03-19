package br.dazzi.molecularcoffeebrewing;

import android.util.Log;

import br.dazzi.molecularcoffeebrewing.FluidSliderConfig.FluidSliderConfig;
import br.dazzi.molecularcoffeebrewing.formula.DzFormula;
import kotlin.Unit;

class MolecularCoffeeHandle {

    private DzFormula secret = new DzFormula();
    private FluidSliderConfig waterBar;
    private FluidSliderConfig coffeeBar;
    private FluidSliderConfig cupBar;

    public MolecularCoffeeHandle(FluidSliderConfig waterBar, FluidSliderConfig coffeeBar, FluidSliderConfig cupBar) {
        this.waterBar = waterBar;
        this.coffeeBar = coffeeBar;
        this.cupBar = cupBar;

        this.setListenerWaterBar();
    }

    private void setListenerWaterBar(){
        this.cupBar.getSlider().setEndTrackingListener(() -> {

            //Get Cups from Water Slider bar
            final int cups = (int)( 0 + (10 * this.cupBar.getSlider().getPosition()));
            Log.d("Cup-Amount", ""+cups);

            //Calc Coffee Grounds Amount [ g ]
            final float coffee = this.secret.getCoffeeAmount(cups);
            Log.d("Coffee-Amount", ""+coffee);
            this.coffeeBar.setSliderPosition(coffee);

            //Calc Water Amount [ ml || cc ]
            final float water = this.secret.getWaterAmount(cups);
            Log.d("Water-Amount", ""+water);
            this.waterBar.setSliderPosition(water);

            return Unit.INSTANCE;
        });
    }

}
