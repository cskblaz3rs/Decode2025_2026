package org.firstinspires.ftc.teamcode;

import com.ftc.cskblazers.intothedeep.BlazersRobot;
import com.ftc.cskblazers.intothedeep.components.AprilTagsCam;
import com.ftc.cskblazers.intothedeep.gamepads.BlazersGamePad1;
import com.ftc.cskblazers.intothedeep.gamepads.BlazersGamePad2;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;


@TeleOp(name="Decode:Teleop", group="Robot")

public class DecodeTeleOp extends LinearOpMode {


        BlazersRobot robot;
        BlazersGamePad1 blazersGamePad1;
        BlazersGamePad2 blazersGamePad2;


        public void initialize(){
            robot=new BlazersRobot(hardwareMap);
            robot.setTelemetry(telemetry);
            telemetry.addData(">", "Robot Ready.  Press Play.");    //
            telemetry.update();
            blazersGamePad1 =new BlazersGamePad1(gamepad1);
            blazersGamePad2 =new BlazersGamePad2(gamepad2);

        }

        @Override
        public void runOpMode() {
            initialize();
            // Wait for the game to start (driver presses PLAY)
            waitForStart();
            // run until the end of the match (driver presses STOP)
            while (opModeIsActive()) {
                //robot.getAprilTagsCam().update();
                blazersGamePad1.stickOperation(robot);
                blazersGamePad1.triggerOperation(robot);
                blazersGamePad1.bumperOperation(robot);
                blazersGamePad1.buttonAPress(robot);
                blazersGamePad1.buttonYPress(robot);
                blazersGamePad1.buttonBPress(robot);
                blazersGamePad1.buttonXPress(robot);

                blazersGamePad2.stickOperation(robot);
                blazersGamePad2.triggerOperation(robot);
                blazersGamePad2.bumperOperation(robot);
                blazersGamePad2.buttonYPress(robot);
                blazersGamePad2.buttonAPress(robot);
                blazersGamePad2.buttonXPress(robot);
                blazersGamePad2.buttonBPress(robot);
                //robot.maintainShootVelocity();


            }
        }
    }

