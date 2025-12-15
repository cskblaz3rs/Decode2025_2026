package com.ftc.cskblazers.intothedeep.components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Wheel {
    private  DcMotor wheelMotor   = null;
    private String name;


    public Wheel(String name, HardwareMap hardwareMap){
        wheelMotor=hardwareMap.get(DcMotor.class, name);
    }
    public void setPower(double power){
        wheelMotor.setPower(power);
    }

    public String getName() {
        return name;
    }
    public void setDirection(DcMotor.Direction direction){
        wheelMotor.setDirection(direction);
    }
    public float getPosition(){
        return wheelMotor.getCurrentPosition();

    }
    public void resetEncoders(){
        wheelMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

}

