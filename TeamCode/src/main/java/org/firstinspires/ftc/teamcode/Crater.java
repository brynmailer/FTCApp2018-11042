package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Crater", group="Linear Opmode")
public class Crater extends LinearOpMode {

    final GSRobot Robot = new GSRobot();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        Robot.init(hardwareMap);
        Robot.Lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();

        controlLift(8400, 0.5, 7700);
        driveBackward(1, 250);
        driveLeft(1, 350);
        driveForward(1, 250);
        driveLeft(1, 4000);
        //controlDrop(1, 600);
        driveForward(1, 3000);
        //controlDrop(0, 600);
        controlLift(0, 0.5, 7700);
        stopMotors();
    }

    public void driveForward(double power, int time) throws InterruptedException {
        Robot.DriveMotor1.setPower(power);
        Robot.DriveMotor2.setPower(power);
        Robot.DriveMotor3.setPower(power);
        Robot.DriveMotor4.setPower(power);
        Thread.sleep(time);
        stopMotors();
    }

    public void driveBackward(double power, int time) throws InterruptedException {
        Robot.DriveMotor1.setPower(-power);
        Robot.DriveMotor2.setPower(-power);
        Robot.DriveMotor3.setPower(-power);
        Robot.DriveMotor4.setPower(-power);
        Thread.sleep(time);
        stopMotors();
    }

    public void driveLeft(double power, int time) throws InterruptedException {
        Robot.DriveMotor1.setPower(-power);
        Robot.DriveMotor2.setPower(power);
        Robot.DriveMotor3.setPower(power);
        Robot.DriveMotor4.setPower(-power);
        Thread.sleep(time);
        stopMotors();
    }

    public void driveRight(double power, int time) throws InterruptedException {
        Robot.DriveMotor1.setPower(power);
        Robot.DriveMotor2.setPower(-power);
        Robot.DriveMotor3.setPower(-power);
        Robot.DriveMotor4.setPower(power);
        Thread.sleep(time);
        stopMotors();
    }

    public void controlLift(int target,double power, int time) throws InterruptedException {
        Robot.Lift.setTargetPosition(target);
        Robot.Lift.setPower(power);
        Thread.sleep(time);
    }

    public void controlDrop(double power, int time) throws InterruptedException {
        //Robot.Dropper.setPosition(power);
        Thread.sleep(time);
        //Robot.Dropper.setPosition(Robot.STOP);
    }

    public void stopMotors() {
        Robot.DriveMotor1.setPower(0);
        Robot.DriveMotor2.setPower(0);
        Robot.DriveMotor3.setPower(0);
        Robot.DriveMotor4.setPower(0);
    }
}