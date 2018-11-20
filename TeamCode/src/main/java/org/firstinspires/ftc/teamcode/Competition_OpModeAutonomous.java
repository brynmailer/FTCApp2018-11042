package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Competition_OpModeAutonomous", group="Linear Opmode")
public class Competition_OpModeAutonomous extends LinearOpMode {
    final GSRobot robot = new GSRobot();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        telemetry.addData("Status", "Resetting Encoders");
        telemetry.update();

        waitForStart();

        liftUp(1, 700);
        driveForward(0.5, 500);
        liftDown(0.5, 700);
        driveRight(0.5, 500);
        driveBackward(0.5, 1);
        driveRight(1, 2);
    }

    public void driveForward(double power, int time) throws InterruptedException {
        robot.DriveMotor1.setPower(power);
        robot.DriveMotor2.setPower(power);
        robot.DriveMotor3.setPower(power);
        robot.DriveMotor4.setPower(power);
        Thread.sleep(time);
    }

    public void driveBackward(double power, int time) throws InterruptedException {
        robot.DriveMotor1.setPower(-power);
        robot.DriveMotor2.setPower(-power);
        robot.DriveMotor3.setPower(-power);
        robot.DriveMotor4.setPower(-power);
        Thread.sleep(time);
    }

    public void driveLeft(double power, int time) throws InterruptedException {
        robot.DriveMotor1.setPower(-power);
        robot.DriveMotor2.setPower(power);
        robot.DriveMotor3.setPower(power);
        robot.DriveMotor4.setPower(-power);
        Thread.sleep(time);
    }

    public void driveRight(double power, int time) throws InterruptedException {
        robot.DriveMotor1.setPower(power);
        robot.DriveMotor2.setPower(-power);
        robot.DriveMotor3.setPower(-power);
        robot.DriveMotor4.setPower(power);
        Thread.sleep(time);
    }

    public void liftUp(double power, int time) throws InterruptedException {
        robot.Lift.setPower(-power);
        Thread.sleep(time);
    }

    public void liftDown(double power, int time) throws InterruptedException {
        robot.Lift.setPower(power);
        Thread.sleep(time);
    }
}