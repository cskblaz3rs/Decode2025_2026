
package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.InstantAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.ftc.cskblazers.intothedeep.BlazersRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Decode:Autonomous Blue", group="Robot")
public class BlueAuto extends LinearOpMode {
    BlazersRobot robot;


    public void initialize() {
        robot = new BlazersRobot(hardwareMap);
        robot.setTelemetry(telemetry);
        telemetry.addData(">", "Robot Ready.  Press Play.");    //
        telemetry.update();


    }

    @Override
    public void runOpMode() throws InterruptedException {
        initialize();
        Pose2d initialPose = new Pose2d(44, -48, Math.toRadians(-45));
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        // vision here that outputs position
        int visionOutputPosition = 1;
        TrajectoryActionBuilder tab1 = drive.actionBuilder(initialPose)
                //.stopAndAdd()
                .stopAndAdd(startLaunch(1000))
                .strafeTo(new Vector2d(20, -20))
                .stopAndAdd(shootAll())
                .turn(Math.toRadians(45))
                .stopAndAdd(intake())
                .strafeTo(new Vector2d(30, -10))
                .strafeTo(new Vector2d(38, -10))
                .waitSeconds(0.2)
                .strafeTo(new Vector2d(57,-10))
                .strafeTo(new Vector2d(25, -20))
                .turn(Math.toRadians(-55))
                .stopAndAdd(shootTwo())
                .stopAndAdd(intake())
                .strafeTo(new Vector2d(20, 10))
                .turn(Math.toRadians(50))
                .waitSeconds(0.2)
                .strafeTo(new Vector2d(37,10))
                .strafeTo(new Vector2d(53,10))
                .strafeTo(new Vector2d(25, 10))
                .strafeTo(new Vector2d(25, -25))
                .turn(Math.toRadians(-48))
                .stopAndAdd(shootTwo());





        //.strafeTo(new Vector2d(25, 25))

        //.turn(Math.toRadians(-45))
        //.waitSeconds(0.1);
        //.setTangent(Math.toRadians())
        //.lineToXSplineHeading(0, Math.toRadians(0))
        //.waitSeconds(0.1)
        //.setTangent(Math.toRadians(-90))
        //.lineToY(67)
        //.setTangent(Math.toRadians(0))
        //.lineToX(32)
        //.strafeTo(new Vector2d(44.5, 30))
        //.turn(Math.toRadians(180))
        //lineToX(47.5)
        //.waitSeconds(0.1);
        TrajectoryActionBuilder tab2 = drive.actionBuilder(initialPose)
                /*.lineToY(37)
                .setTangent(Math.toRadians(0))
                .lineToX(18)
                .waitSeconds(3)
                .setTangent(Math.toRadians(0))
                .lineToXSplineHeading(46, Math.toRadians(180))*/
                .waitSeconds(3);
        TrajectoryActionBuilder tab3 = drive.actionBuilder(initialPose)
                /*.lineToYSplineHeading(33, Math.toRadians(180))
                .waitSeconds(2)
                .strafeTo(new Vector2d(46, 30))*/
                .waitSeconds(3);
        Action trajectoryActionCloseOut = tab1.endTrajectory().fresh()
                //.strafeTo(new Vector2d(48, 12))
                .build();

        while (!isStopRequested() && !opModeIsActive()) {
            int position = visionOutputPosition;
            telemetry.addData("Position during Init", position);
            telemetry.update();
        }

        int startPosition = visionOutputPosition;
        telemetry.addData("Starting Position", startPosition);
        telemetry.update();
        waitForStart();

        if (isStopRequested()) return;

        Action trajectoryActionChosen;
        if (startPosition == 1) {
            trajectoryActionChosen = tab1.build();
        } else if (startPosition == 2) {
            trajectoryActionChosen = tab2.build();
        } else {
            trajectoryActionChosen = tab3.build();
        }

        Actions.runBlocking(
                new SequentialAction(
                        trajectoryActionChosen,
                        trajectoryActionCloseOut
                )
        );

    }

    public Action shootAll() {
        return new InstantAction(() -> {
            robot.releaseArtifact();
            sleep(200);
            robot.shoot(1190);
            robot.dropArtifact();
            sleep(100);
            robot.releaseArtifact();
            sleep(500);
            robot.dropArtifact();
            sleep(1000);
            robot.releaseArtifact();
            sleep(500);
            robot.dropArtifact();
            sleep(1000);
            robot.releaseArtifact();
            sleep(1200);
            robot.stopIntake();
        });
    }
    public Action shootTwo() {
        return new InstantAction(() -> {
            robot.releaseArtifact();
            sleep(200);
            robot.shoot(1190);
            robot.dropArtifact();
            sleep(500);
            robot.releaseArtifact();
            sleep(500);
            robot.dropArtifact();
            sleep(1000);
            robot.releaseArtifact();
            sleep(1200);
            robot.stopIntake();
        });
    }
    public Action intake() {
        return new InstantAction(() -> {
            robot.intakeForward();

        });
    }
    public Action stopIntake() {
        return new InstantAction(() -> {
            robot.stopIntake();

        });
    }

    public Action startLaunch(int velocity) {
        return new InstantAction(() -> {
            robot.shoot(velocity);

        });
    }

}

