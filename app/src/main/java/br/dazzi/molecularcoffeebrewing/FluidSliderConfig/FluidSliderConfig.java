package br.dazzi.molecularcoffeebrewing.FluidSliderConfig;

import android.util.Log;
import com.ramotion.fluidslider.FluidSlider;
import kotlin.Unit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FluidSliderConfig {

    private FluidSlider slider;
    private int min;
    private int max;
    private String measure;
    private String name;

    public FluidSliderConfig(int min, int max, String measure, FluidSlider slider, String name){
        this.min = min;
        this.max = max;
        this.slider = slider;
        this.measure = measure;
        this.name = name;

        this.setSliderEndText();
        this.setSliderStartText();
        this.setBubbleRange();

        this.slider.setPosition(0);
    }

    public FluidSliderConfig(int min, int max, String measure, FluidSlider slider, String name, boolean touchEnable){
        this.min = min;
        this.max = max;
        this.slider = slider;
        this.measure = measure;
        this.name = name;

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
            final String value = String.valueOf( (int) Math.round( this.min + (this.max * pos)));
            this.slider.setBubbleText(value);
            return Unit.INSTANCE;
        });
    }

    public float getSliderPostion(){
        return (this.min + (this.max * this.slider.getPosition()));
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
            this.slider.setOnTouchListener((v, event) -> true);
        }else {
            this.slider.setOnTouchListener((v, event) -> false);
        }
    }
}
