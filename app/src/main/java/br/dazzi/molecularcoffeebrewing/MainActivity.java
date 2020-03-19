package br.dazzi.molecularcoffeebrewing;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import br.dazzi.molecularcoffeebrewing.FluidSliderConfig.FluidSliderConfig;

public class MainActivity extends Activity {

    private FluidSliderConfig coffeeBar;
    private FluidSliderConfig waterBar;
    private FluidSliderConfig cupsBar;
    private MolecularCoffeeHandle sliderListener;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Fluid slider - Cups Qty
        this.cupsBar = new FluidSliderConfig(0, 10*3, "cup", findViewById(R.id.slider_cups_qtd));

        // Fluid slider - Water Amount
        this.waterBar = new FluidSliderConfig(0, 2000, "ml", findViewById(R.id.slider_water),true);

        // Fluid slider - Coffee Amount
        this.coffeeBar = new FluidSliderConfig(0, 200, "g", findViewById(R.id.slider_coffee_beans), true);


        MolecularCoffeeHandle sliderListener = new MolecularCoffeeHandle(this.waterBar, this.coffeeBar, this.cupsBar);
    }
}
