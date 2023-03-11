package net.theclient.hacks.Screens;

import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.LiteralText;
import net.theclient.hacks.Main;

public class ConfigScreen extends Screen {

    private final Screen parent;
    private final GameOptions settings;

    public ConfigScreen(Screen parent, GameOptions gameOptions){
        super((new LiteralText("The Client")));
        this.parent = parent;
        this.settings = gameOptions;
    }

    //Flight text for Button
    LiteralText flightText(){
        if(Main.isFlightEnabled)
            return new LiteralText("Flight enabled");
        else
            return new LiteralText("Flight disabled");
    }

    //Anti Hurt Cam text for Button
    LiteralText hurtCamText(){
        if(Main.isHurtCamEnabled)
            return new LiteralText("Hurt Cam disabled");
        else
            return new LiteralText("Hurt Cam enabled");
    }

    //Speed text for Button
    LiteralText sprintText(){
        if(Main.isSprintEnabled)
            return new LiteralText("Sprint enabled");
        else
            return new LiteralText("Sprint disabled");
    }

    //Auto Totem text for Button
    LiteralText autoTotemText(){
        if(Main.isAutoTotemEnabled)
            return new LiteralText("Auto Totem enabled");
        else
            return new LiteralText("Auto Totem disabled");
    }
    //No Fall text for Button
    LiteralText noFallText(){
        if(Main.isNoFallEnabled)
            return new LiteralText("No Fall enabled");
        else
            return new LiteralText("No Fall disabled");
    }
    //Speed text for Button
    LiteralText speedText(){
        if(Main.isSpeedEnabled)
            return new LiteralText("Speed enabled");
        else
            return new LiteralText("Speed disabled");
    }
    //Full Bright text for Button
    LiteralText fullBrightText(){
        if(Main.isfullBrightEnabled)
            return new LiteralText("Full Bright enabled");
        else
            return new LiteralText("Full Bright disabled");
    }
    //Entity Outline text for Button
    LiteralText entityOutlineText(){
        if(Main.isEntityOutlinetEnabled)
            return new LiteralText("Entity Outline enabled");
        else
            return new LiteralText("Entity Outline disabled");
    }

    protected void init(){

        this.addDrawableChild(new ButtonWidget(10, 10, 90, 20, new LiteralText("Back"), (button -> {
            this.client.setScreen(new GameMenuScreen(true));
        })));

        //Flight Button
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 90, 200, 20, flightText(), (button -> {
            Main.isFlightEnabled = !Main.isFlightEnabled;
            button.setMessage(flightText());
                })));

        //Speed Button
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 115, 200, 20, sprintText(), (button -> {
            Main.isSprintEnabled = !Main.isSprintEnabled;
            button.setMessage(sprintText());
        })));

        //Flight Button
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 140, 200, 20, hurtCamText(), (button -> {
            Main.isHurtCamEnabled = !Main.isHurtCamEnabled;
            button.setMessage(hurtCamText());
        })));

        //Auto Totem Button
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 165, 200, 20, autoTotemText(), (button -> {
            Main.isAutoTotemEnabled = !Main.isAutoTotemEnabled;
            button.setMessage(autoTotemText());
        })));

        //No Fall Button
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 190, 200, 20, noFallText(), (button -> {
            Main.isNoFallEnabled = !Main.isNoFallEnabled;
            button.setMessage(noFallText());
        })));

        //Speed Button
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 215, 200, 20, speedText(), (button -> {
            Main.isSpeedEnabled = !Main.isSpeedEnabled;
            button.setMessage(speedText());
        })));

        //Full Bright Button
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 240, 200, 20, fullBrightText(), (button -> {
            Main.isfullBrightEnabled = !Main.isfullBrightEnabled;
            button.setMessage(fullBrightText());
        })));

        //Entity Outline Button
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 265, 200, 20, entityOutlineText(), (button -> {
            Main.isEntityOutlinetEnabled = !Main.isEntityOutlinetEnabled;
            button.setMessage(entityOutlineText());
        })));
    }
}
