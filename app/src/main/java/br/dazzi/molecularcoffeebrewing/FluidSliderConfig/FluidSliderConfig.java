package br.dazzi.molecularcoffeebrewing.FluidSliderConfig;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.ramotion.fluidslider.FluidSlider;

import kotlin.Unit;

public class FluidSliderConfig {

    private FluidSlider slider;
    private int min;
    private int max;
    private String measure;

    public FluidSliderConfig(int min, int max, String measure, FluidSlider slider){
        this.min = min;
        this.max = max;
        this.slider = slider;
        this.measure = measure;

        this.setSliderEndText();
        this.setSliderStartText();
        this.setBubbleRange();

        this.slider.setPosition(0);
    }

    public FluidSliderConfig(int min, int max, String measure, FluidSlider slider, boolean touchEnable){
        this.min = min;
        this.max = max;
        this.slider = slider;
        this.measure = measure;

        this.setSliderEndText();
        this.setSliderStartText();
        this.setBubbleRange();

        this.slider.setPosition(0);
        this.setSliderEnable(touchEnable);
    }

    private String getStartText(){
        return String.format("%s %s", this.min,this.measure);
    }
    private String getEndText(){
        return String.format("%s %s", this.max,this.measure);
    }

    private void setSliderStartText(){
        this.slider.setStartText(this.getStartText());
    }
    private void setSliderEndText(){
        this.slider.setEndText(this.getEndText());
    }

    private void setBubbleRange(){
        this.slider.setPositionListener(pos -> {
            final String value = String.valueOf( (int)( this.min + (this.max * pos)));
            this.slider.setBubbleText(value);
            return Unit.INSTANCE;
        });
    }

    public void setSliderPosition(float value){
        Log.d("Pos-Amount", ""+((value / this.max)));

        this.slider.setPosition((float) (value / this.max) );
    }

    public FluidSlider getSlider(){
        return this.slider;
    }

    private void setSliderEnable(boolean enable){
        if(!enable) {
            this.slider.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });
        }else {
            this.slider.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return false;
                }
            });
        }
    }
}
