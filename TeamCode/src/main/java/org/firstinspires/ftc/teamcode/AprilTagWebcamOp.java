package org.firstinspires.ftc.teamcode;

import com.ftc.cskblazers.intothedeep.components.AprilTagsCam;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
@Autonomous
public class AprilTagWebcamOp extends OpMode {
    AprilTagsCam aprilTagsCam=new AprilTagsCam();

    @Override
    public void init() {
        aprilTagsCam.inti(hardwareMap,telemetry);
    }

    @Override
    public void loop() {
        aprilTagsCam.update();
        AprilTagDetection dectectID=aprilTagsCam.getTagByid(24);
        aprilTagsCam.displayDetectionTelemetry(dectectID);
    }
}
