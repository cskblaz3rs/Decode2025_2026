package com.ftc.cskblazers.intothedeep.components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Launch {
    private DcMotorEx launch = null;
    public static final double NO_POWER = 0.0;

    private static String LAUNCH_MOTOR_NAME = "launcher";


    public Launch(HardwareMap hardwareMap) {
        launch = hardwareMap.get(DcMotorEx.class, LAUNCH_MOTOR_NAME);
    }

    public void shootForward (int velocity){
        shootAdjust(velocity);

    }
    public void shootStop(){
        launch.setPower(0.0);


    }
    public void shootBackward(){
        launch.setDirection(DcMotorSimple.Direction.FORWARD);
        launch.setPower(1.0);
    }
    public void shootAdjust(int velocity){
        //launch.setVelocity(1500);
        launch.setDirection(DcMotorSimple.Direction.REVERSE);
        launch.setVelocity(velocity);
    //spinToTargetVelocity(launch, 1700, 50, 50);
}

    public double getVelocity(){
        return launch.getVelocity();
    }
    private boolean spinToTargetVelocity(DcMotorEx motor, double targetRPM, double toleranceRPM, long timeoutMs) {
        // Convert RPM -> ticks/sec
        double ticksPerRev = motor.getMotorType().getTicksPerRev();
        double targetTicksPerSec = (targetRPM / 60.0) * ticksPerRev;
        double toleranceTicksPerSec = (toleranceRPM / 60.0) * ticksPerRev;

        // Start commanding velocity (DcMotorEx.setVelocity takes ticks/sec)
        motor.setVelocity(targetTicksPerSec);
        System.out.println("Velocity ="+ticksPerRev);

        final int requiredStableSamples = 5; // need this many consecutive good readings
        int stableCount = 0;
        long startTime = System.currentTimeMillis();

        while ((System.currentTimeMillis() - startTime) < timeoutMs) {
            double measured = motor.getVelocity(); // ticks/sec
            double error = Math.abs(measured - targetTicksPerSec);

            if (error <= toleranceTicksPerSec) {
                stableCount++;
                if (stableCount >= requiredStableSamples) {
                    return true; // stable at target
                }
            } else {
                stableCount = 0;
            }

            // short sleep to avoid busy loop
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        return false;
    }

}
