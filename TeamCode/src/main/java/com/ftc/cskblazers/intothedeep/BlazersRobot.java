package com.ftc.cskblazers.intothedeep;



import static java.lang.Thread.sleep;

import com.ftc.cskblazers.intothedeep.components.AprilTagsCam;
import com.ftc.cskblazers.intothedeep.components.DriveTrain;
import com.ftc.cskblazers.intothedeep.components.Intake;
import com.ftc.cskblazers.intothedeep.components.Launch;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

public class BlazersRobot {

    private DriveTrain driveTrain=null;
    private Intake intake=null;
    private Launch launch=null;

    Telemetry telemetry;
    AprilTagsCam aprilTagsCam=new AprilTagsCam();
    AprilTagDetection dectectID;


    public BlazersRobot(HardwareMap hardwareMap){

        driveTrain = new DriveTrain(hardwareMap);
        intake = new Intake(hardwareMap);
        launch = new Launch(hardwareMap);
       // aprilTagsCam.inti(hardwareMap,telemetry);

    }

    public AprilTagsCam getAprilTagsCam() {
        return aprilTagsCam;
    }

    public void setAprilTagsCam(AprilTagsCam aprilTagsCam) {
        this.aprilTagsCam = aprilTagsCam;
    }

    public void stop(){

       driveTrain.stop();
    }
    public void move(double frontLeftSpeed, double frontRightSpeed, double backLeftSpeed, double backRightSpeed){

        driveTrain.move(frontLeftSpeed,frontRightSpeed,backLeftSpeed,backRightSpeed);

    }
    public void drive(double verticalPosition, double horizontalPosition, double pivot){

        driveTrain.run(verticalPosition,horizontalPosition,pivot);
        /*dectectID=aprilTagsCam.getTagByid(24);
        double positionx=dectectID.ftcPose.x;
        double positiony=dectectID.ftcPose.y;
        double positionz=dectectID.ftcPose.z;
        aprilTagsCam.displayDetectionTelemetry(dectectID);*/

   }
   public void setShootPosition(){

   }

    public void drive(double verticalPosition, double horizontalPosition, double pivot, double speed){

        driveTrain.run(verticalPosition,horizontalPosition,pivot,speed);

    }
   public void setReverse(){
        driveTrain.setReverse();
   }

    public Telemetry getTelemetry() {
        return telemetry;
    }

    public void setTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public void intakeForward(){
        intake.intakeIn();
    }
    public void intakeBackward(){
        intake.intakeOut();
    }
    public void shoot(int velocity){

        launch.shootForward(velocity);
    }
    public void stopShoot(){
        launch.shootStop();
    }
    public void stopIntake(){
        intake.stopIntake();
    }
    public void shootBackward(){
        launch.shootBackward();
    }
    public void releaseArtifact(){
        intake.releaseArtifact();
    }
    public void dropArtifact(){
        intake.dropArtifact();
    }
    public void holdArtifact(){
        intake.holdArtifact();
    }
    public void doubleShoot() throws InterruptedException {
        telemetry.addLine("Shoot Velocity=" + Double.toString(launch.getVelocity()));
        intake.dropArtifact();
        sleep(50);
        intake.releaseArtifact();
        intake.dropArtifact();
        sleep(50);
        intake.releaseArtifact();
        intake.dropArtifact();
        sleep(50);
        intake.releaseArtifact();
        telemetry.addLine("Shoot Velocity=" + Double.toString(launch.getVelocity()));
        intake.holdArtifact();

    }
    public void shootAll() throws InterruptedException {
        //launch.shootForward(1100);
        intake.releaseArtifact();
        sleep(200);
        //launch.shootForward(1230);
        intake.dropArtifact();
        sleep(10);
        intake.releaseArtifact();
        sleep(500);
        intake.dropArtifact();
        sleep(1000);
        intake.releaseArtifact();
        sleep(500);
        intake.dropArtifact();
        sleep(1000);
        intake.releaseArtifact();
        sleep(1100);
        intake.stopIntake();
    }
    public void shootAllFar() throws InterruptedException {
        launch.shootForward(1800);
        intake.releaseArtifact();
        sleep(200);
        launch.shootForward(1900);
        intake.dropArtifact();
        sleep(10);
        intake.releaseArtifact();
        sleep(500);
        intake.dropArtifact();
        sleep(1000);
        intake.releaseArtifact();
        sleep(500);
        intake.dropArtifact();
        sleep(1000);
        intake.releaseArtifact();
        sleep(1100);
        intake.stopIntake();
    }


    public void maintainShootVelocity(){
        //launch.shootAdjust();
    }








    public void printPositions(){
        driveTrain.printPositions();
    }


    public float getRobotForwardPosition(){
        return driveTrain.getForwardPosition();
    }
    public float getRobotSidePosition(){
       return driveTrain.getSidePosition();
    }
    public void resetDriveTrainEncoders(){
        driveTrain.resetEncoders();
    }




}
