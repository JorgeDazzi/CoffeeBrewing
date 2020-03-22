package br.dazzi.molecularcoffeebrewing.FluidSliderConfig;

import com.ramotion.fluidslider.FluidSlider;
import java.util.UUID;
import kotlin.Unit;
import lombok.Getter;


public class FluidConfig {

    private int min = 0;
    private int max = 100;
    @Getter
    private FluidSlider slider;
    @Getter
    private String unit = "g";
    @Getter
    private String name = UUID.randomUUID().toString();

    public FluidConfig(FluidSlider slider) {
        this.slider = slider;
    }

    public FluidConfig setMin(int num){
        this.min = num;
        return this;
    }

    public FluidConfig setMax(int num){
        this.max = num;
        return this;
    }

    public FluidConfig setName(String name){
        this.name = name;
        return this;
    }

    public FluidConfig setUnit(String unit){
        this.unit = unit;
        return this;
    }

    /**
     * @param enable Enable or disable (true or false) slider
     * @return self return
     */
    public FluidConfig setSliderEnable(boolean enable){
        this.slider.setOnTouchListener((v,view) -> !enable);
        return this;
    }


    /**
     * Text example: 0 g
     * @return minimum amount unit
     */
    private String getStartText(){
        return String.format(
                "%s %s",
                this.min,
                this.unit
        );
    }

    /**
     * Text example: 105 g
     * @return maximum amount unit
     */
    private String getEndText(){
        return String.format(
                "%s %s",
                this.max,
                this.unit
        );
    }

    private void setSliderText(){
        this.slider.setStartText(this.getStartText());
        this.slider.setEndText(this.getEndText());
    }

    private void setBubbleRange(){
        this.slider.setPositionListener( pos -> {
            String value = String.valueOf( (int) Math.round( this.min + ( this.max * pos ) ) );
            this.slider.setBubbleText(value);
            return Unit.INSTANCE;
        });
    }

    /**
     * Get value from slider in percentage and convert it to FluidConfig unit
     * @return slider position already converted
     */
    public float getSliderPosition(){
        return ( this.min + ( this.max * this.slider.getPosition() ) );
    }

    /**
     * convert the value to percentage, in order to represent your value in the slider
     * @param value The amount from recipe
     */
    public void setSliderPosition(float value){
        this.slider.setPosition( value / this.max );
    }

    public FluidConfig build(){
        this.setSliderText();
        this.setBubbleRange();
        this.slider.setPosition(0);

        return this;
    }
}
