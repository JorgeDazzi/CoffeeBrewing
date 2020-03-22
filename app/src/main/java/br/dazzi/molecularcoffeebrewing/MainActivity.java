package br.dazzi.molecularcoffeebrewing;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import br.dazzi.molecularcoffeebrewing.FluidSliderConfig.FluidConfig;
import br.dazzi.molecularcoffeebrewing.ListenerHandle.ListenerHandle;
import br.dazzi.molecularcoffeebrewing.formula.RosiechenFormula;

public class MainActivity extends Activity {

    private FluidConfig coffeeBar;
    private FluidConfig waterBar;
    private FluidConfig cupsBar;
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

        // Set Cup Slider
            this.cupsBar = new FluidConfig( findViewById( R.id.slider_cups_qtd ) )
                .setMax( this.rosieCrema.getMaxCup() )
                .setName( "Cup" )
                .setUnit( this.rosieCrema.getRatio().getCupUnit() )
                .build();

        // Set Coffee Slider
            this.coffeeBar = new FluidConfig( findViewById( R.id.slider_coffee_beans ) )
                 .setMax( this.rosieCrema.getMaxCoffee() )
                 .setUnit( this.rosieCrema.getRatio().getCoffeeUnit() )
                 .setName( "Coffee" )
                 .setSliderEnable( true )
                 .build();

            this.waterBar = new FluidConfig( findViewById( R.id.slider_water ) )
                .setMax( this.rosieCrema.getMaxWater() )
                .setName( "Water" )
                .setUnit( this.rosieCrema.getRatio().getWaterUnit() )
                .setSliderEnable( true )
                .build();

        // Set Listeners
            this.sliderListener = new ListenerHandle(this.waterBar, this.coffeeBar, this.cupsBar, this.rosieCrema);
    }


    public void about(View view){
        Uri uriUrl = Uri.parse("https://jorgedazzi.github.io/CoffeeBrewing/");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
