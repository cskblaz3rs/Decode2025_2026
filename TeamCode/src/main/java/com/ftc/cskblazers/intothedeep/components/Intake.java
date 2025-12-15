package com.ftc.cskblazers.intothedeep.components;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private CRServo intake1 = null;
    private CRServo intake2 = null;
    private CRServo intake3 = null;
    public static String INTAKE1_SERVO_NAME = "intake1";
    public static String INTAKE2_SERVO_NAME = "intake2";
    public static String INTAKE3_SERVO_NAME = "intake3";
    public Intake(HardwareMap hardwareMap) {
        intake1 = hardwareMap.get(CRServo.class, INTAKE1_SERVO_NAME);
        intake2 = hardwareMap.get(CRServo.class, INTAKE2_SERVO_NAME);
        intake3 = hardwareMap.get(CRServo.class, INTAKE3_SERVO_NAME);
    }
    public void intakeIn(){
        intake1.setDirection(CRServo.Direction.REVERSE);
        intake1.setPower(1.0);
        intake2.setDirection(CRServo.Direction.FORWARD);
        intake2.setPower(1.0);
        intake3.setDirection(CRServo.Direction.FORWARD);
        intake3.setPower(1.0);
    }
    public void intakeOut(){
        intake1.setDirection(CRServo.Direction.FORWARD);
        intake1.setPower(1.0);
        intake2.setDirection(CRServo.Direction.REVERSE);
        intake2.setPower(1.0);
    }
    public void stopIntake(){
        intake1.setPower(0.0);
        intake2.setPower(0.0);
        intake3.setPower(0.0);
    }

    public void dropArtifact() {
        intake2.setDirection(CRServo.Direction.REVERSE);
        intake2.setPower(1.0);
        intake3.setDirection(CRServo.Direction.REVERSE);
        intake3.setPower(1.0);
    }

    public void releaseArtifact(){
        intake2.setDirection(CRServo.Direction.FORWARD);
        intake2.setPower(1.0);
        intake3.setDirection(CRServo.Direction.REVERSE);
        intake3.setPower(1.0);

    }
    public void holdArtifact(){
        intake2.setPower(0.0);
        intake3.setPower(0.0);
    }


}
