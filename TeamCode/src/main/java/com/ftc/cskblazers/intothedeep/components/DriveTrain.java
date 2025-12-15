package com.ftc.cskblazers.intothedeep.components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveTrain {
    private Wheel frontLeftDrive = null;
    private Wheel frontRightDrive = null;
    private Wheel backLeftDrive = null;
    private Wheel backRightDrive = null;

    public DriveTrain(HardwareMap hardwareMap) {
        frontLeftDrive = new Wheel("left front wheel", hardwareMap);
        frontRightDrive = new Wheel("right front wheel", hardwareMap);
        backLeftDrive = new Wheel("left back wheel", hardwareMap);
        backRightDrive = new Wheel("right back wheel", hardwareMap);
    }


    public void setForward() {
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
    }

    public void setReverse() {
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backRightDrive.setDirection(DcMotor.Direction.REVERSE);
        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
    }

    public void oldRun(double verticalPosition, double horizontalPosition, double pivot) {
        frontRightDrive.setPower(((verticalPosition + horizontalPosition) + pivot) * 0.75);
        frontLeftDrive.setPower(((verticalPosition - horizontalPosition) - pivot) * 0.75);
        backRightDrive.setPower(((verticalPosition + horizontalPosition) + pivot) * 0.75);
        backLeftDrive.setPower(((verticalPosition - horizontalPosition) - pivot) * 0.75);
    }

    public void run(double verticalPosition, double horizontalPosition, double pivot) {

        double y = -verticalPosition; // Remember, Y stick value is reversed
        double x = horizontalPosition; // Counteract imperfect strafing
        double rx = pivot;
        double speed = 0.9;
        
       /* if(verticalPosition!=0||horizontalPosition!=0||pivot!=0) {
            System.out.println("Vertical Position:" + verticalPosition);
            System.out.println("Horizontal Position:" + horizontalPosition);
            System.out.println("Pivot:" + pivot);
        }*/

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);

        double frontLeftPower = -((y + x + rx) / denominator) * speed;
        double backLeftPower = -((y - x + rx) / denominator) * speed;
        double frontRightPower = ((y - x - rx) / denominator) * speed;
        double backRightPower = ((y + x - rx) / denominator) * speed;

        frontLeftDrive.setPower(frontLeftPower);
        backLeftDrive.setPower(backLeftPower);
        frontRightDrive.setPower(frontRightPower);
        backRightDrive.setPower(backRightPower);
    }

    public void run(double verticalPosition, double horizontalPosition, double pivot, double speed) {

        double y = -verticalPosition; // Remember, Y stick value is reversed
        double x = horizontalPosition; // Counteract imperfect strafing
        double rx = pivot;
        /*System.out.println("Vertical Position:" + verticalPosition);
        System.out.println("Horizontal Position:" + horizontalPosition);
        System.out.println("Pivot:" + pivot);*/

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);

        double frontLeftPower = -((y + x + rx) / denominator) * speed;
        double backLeftPower = -((y - x + rx) / denominator) * speed;
        double frontRightPower = ((y - x - rx) / denominator) * speed;
        double backRightPower = ((y + x - rx) / denominator) * speed;

        frontLeftDrive.setPower(frontLeftPower);
        backLeftDrive.setPower(backLeftPower);
        frontRightDrive.setPower(frontRightPower);
        backRightDrive.setPower(backRightPower);
    }

    public void move(double frontLeftSpeed, double frontRightSpeed, double backLeftSpeed, double backRightSpeed) {
        frontLeftDrive.setPower(frontLeftSpeed);
        backLeftDrive.setPower(backLeftSpeed);
        frontRightDrive.setPower(frontRightSpeed);
        backRightDrive.setPower(backRightSpeed);
    }

    public void stop() {
        frontLeftDrive.setPower(0);
        backLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backRightDrive.setPower(0);
    }
    public void printPositions(){
        System.out.println("Side:" + frontRightDrive.getPosition());
        System.out.println("Front:"+ backRightDrive.getPosition());
    }

    public float getForwardPosition(){
        return backRightDrive.getPosition();
    }
    public float getSidePosition(){
        return frontRightDrive.getPosition();
    }
    public void resetEncoders(){
        frontRightDrive.resetEncoders();
        backRightDrive.resetEncoders();
    }




}
