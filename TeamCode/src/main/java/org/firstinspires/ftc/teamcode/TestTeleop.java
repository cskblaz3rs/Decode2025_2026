
package org.firstinspires.ftc.teamcode;

import com.ftc.cskblazers.intothedeep.BlazersRobot;
import com.ftc.cskblazers.intothedeep.components.AprilTagsCam;
import com.ftc.cskblazers.intothedeep.gamepads.BlazersGamePad1;
import com.ftc.cskblazers.intothedeep.gamepads.BlazersGamePad2;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;


@TeleOp(name="Test:Teleop", group="Robot")

public class TestTeleop extends LinearOpMode {


    //BlazersGamePad1 blazersGamePad1;
    //BlazersGamePad2 blazersGamePad2;
    private DcMotorEx launch = null;


    public void initialize(){
        launch = hardwareMap.get(DcMotorEx.class, "launch");
        telemetry.addData(">", "Robot Ready.  Press Play.");    //
        telemetry.update();
        //blazersGamePad1 =new BlazersGamePad1(gamepad1);
        //blazersGamePad2 =new BlazersGamePad2(gamepad2);

    }

    @Override
    public void runOpMode() {
        initialize();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            //robot.getAprilTagsCam().update();
            launch.setDirection(DcMotorSimple.Direction.REVERSE);
            launch.setPower(0.85);


        }
    }
}

