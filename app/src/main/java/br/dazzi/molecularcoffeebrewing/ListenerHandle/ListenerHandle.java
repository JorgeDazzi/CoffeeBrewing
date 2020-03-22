package br.dazzi.molecularcoffeebrewing.ListenerHandle;

import br.dazzi.molecularcoffeebrewing.FluidSliderConfig.FluidConfig;
import br.dazzi.molecularcoffeebrewing.formula.Formula;
import br.dazzi.molecularcoffeebrewing.formula.Recipe;
import kotlin.Unit;
import lombok.Setter;

public class ListenerHandle {

    @Setter
    private Formula formula;
    private FluidConfig waterBar;
    private FluidConfig coffeeBar;
    private FluidConfig cupBar;

    public ListenerHandle(FluidConfig waterBar, FluidConfig coffeeBar, FluidConfig cupBar, Formula formula) {
        this.waterBar = waterBar;
        this.coffeeBar = coffeeBar;
        this.cupBar = cupBar;
        this.formula = formula;

        this.setListener(this.cupBar);
        this.setListener(this.coffeeBar);
        this.setListener(this.waterBar);
    }


    private void setListener(FluidConfig fluid){

        fluid.getSlider().setEndTrackingListener( () -> {

            float amount = fluid.getSliderPosition();
            Recipe recipe = this.formula.getProportion(fluid.getName(), amount);

            this.cupBar.setSliderPosition(recipe.getCups());
            this.coffeeBar.setSliderPosition(recipe.getCoffeeGrounds());
            this.waterBar.setSliderPosition(recipe.getWater());

            return Unit.INSTANCE;
        });

    }

}
