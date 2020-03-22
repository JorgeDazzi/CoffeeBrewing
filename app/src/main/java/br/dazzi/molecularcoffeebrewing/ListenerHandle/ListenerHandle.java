package br.dazzi.molecularcoffeebrewing.ListenerHandle;

import br.dazzi.molecularcoffeebrewing.FluidSliderConfig.FluidSliderConfig;
import br.dazzi.molecularcoffeebrewing.formula.Formula;
import br.dazzi.molecularcoffeebrewing.formula.Recipe;
import kotlin.Unit;
import lombok.Setter;

public class ListenerHandle {

    @Setter
    private Formula formula;
    private FluidSliderConfig waterBar;
    private FluidSliderConfig coffeeBar;
    private FluidSliderConfig cupBar;

    public ListenerHandle(FluidSliderConfig waterBar, FluidSliderConfig coffeeBar, FluidSliderConfig cupBar, Formula formula) {
        this.waterBar = waterBar;
        this.coffeeBar = coffeeBar;
        this.cupBar = cupBar;
        this.formula = formula;

        this.setListener(this.cupBar);
        this.setListener(this.coffeeBar);
        this.setListener(this.waterBar);
    }


    private void setListener(FluidSliderConfig fluid){

        fluid.getSlider().setEndTrackingListener( () -> {

            float amount = fluid.getSliderPostion();
            Recipe recipe = this.formula.getProportion(fluid.getName(), amount);

            this.cupBar.setSliderPosition(recipe.getCups());
            this.coffeeBar.setSliderPosition(recipe.getCoffeeGrounds());
            this.waterBar.setSliderPosition(recipe.getWater());

            return Unit.INSTANCE;
        });

    }

}
