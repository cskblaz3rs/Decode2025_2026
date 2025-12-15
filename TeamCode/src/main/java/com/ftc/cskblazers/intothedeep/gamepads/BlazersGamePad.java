package com.ftc.cskblazers.intothedeep.gamepads;

import com.ftc.cskblazers.intothedeep.BlazersRobot;
import com.qualcomm.robotcore.hardware.Gamepad;

public interface BlazersGamePad {
    public abstract void init(Gamepad gamepad);
    public abstract void stickOperation(BlazersRobot robot);
    public abstract void triggerOperation(BlazersRobot robot);
    public abstract void bumperOperation(BlazersRobot robot);
    public abstract void buttonAPress(BlazersRobot robot);
    public abstract void buttonBPress(BlazersRobot robot);
    public abstract void buttonXPress(BlazersRobot robot);
    public abstract void buttonYPress(BlazersRobot robot);

}
