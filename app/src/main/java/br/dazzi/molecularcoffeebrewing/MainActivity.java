package br.dazzi.molecularcoffeebrewing;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import br.dazzi.molecularcoffeebrewing.FluidSliderConfig.FluidSliderConfig;
import br.dazzi.molecularcoffeebrewing.ListenerHandle.ListenerHandle;
import br.dazzi.molecularcoffeebrewing.formula.RosiechenFormula;

public class MainActivity extends Activity {

    private FluidSliderConfig coffeeBar;
    private FluidSliderConfig waterBar;
    private FluidSliderConfig cupsBar;
    private ListenerHandle sliderListener;
    private RosiechenFormula rosieCrema;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);





        //Set Formula
            this.rosieCrema = new RosiechenFormula();

        // Fluid slider - Cups Qty
            this.cupsBar = new FluidSliderConfig(0, this.rosieCrema.getMaxCup(), "cup", findViewById(R.id.slider_cups_qtd), "Cup");

        // Fluid slider - Water Amount
            this.waterBar = new FluidSliderConfig(0, this.rosieCrema.getMaxWater(), "ml", findViewById(R.id.slider_water),"Water",true);

        // Fluid slider - Coffee Amount
            this.coffeeBar = new FluidSliderConfig(0, this.rosieCrema.getMaxCoffee(), "g", findViewById(R.id.slider_coffee_beans), "Coffee",true);

        // Set listeners handle
            this.sliderListener = new ListenerHandle(this.waterBar, this.coffeeBar, this.cupsBar, this.rosieCrema);
    }


    public void about(View view){
        Uri uriUrl = Uri.parse("https://jorgedazzi.github.io/CoffeeBrewing/");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
