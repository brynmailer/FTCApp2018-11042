package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Competition Opmode", group="Iterative Opmode")
public class Competition_OpMode extends OpMode {

    GSRobot Robot = new GSRobot();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {
        Robot.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void init_loop () {
    }

    @Override
    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {
        controlDrive();
        // controlArm();
        // controlSweeper();
        // controlLift();

        /*
        telemetry.addData("Red  ", Robot.ColorSensor.red());
        telemetry.addData("Green", Robot.ColorSensor.green());
        telemetry.addData("Blue ", Robot.ColorSensor.blue());
        */
    }

    @Override
    public void stop() {
    }

    public void controlDrive() {
        double r = Math.hypot(-gamepad1.left_stick_x, gamepad1.left_stick_y);
        double robotAngle = Math.atan2(gamepad1.left_stick_y, -gamepad1.left_stick_x) - Math.PI / 4;
        double rightX = -gamepad1.right_stick_x;
        final double v1 = r * Math.cos(robotAngle) + rightX;
        final double v2 = r * Math.sin(robotAngle) - rightX;
        final double v3 = r * Math.sin(robotAngle) + rightX;
        final double v4 = r * Math.cos(robotAngle) - rightX;

        Robot.DriveMotor1.setPower(v1);
        Robot.DriveMotor2.setPower(v2);
        Robot.DriveMotor3.setPower(v3);
        Robot.DriveMotor4.setPower(v4);
    }

    /*
    public void controlArm() {
        if (gamepad1.dpad_up) {
            Robot.PivotArm.setPower(0.3);
        } else if (gamepad1.dpad_down) {
            Robot.PivotArm.setPower(-0.3);
        } else {
            Robot.PivotArm.setPower(0);
        }

        if (gamepad1.right_bumper) {
            Robot.ExtendArm.setPower(0.3);
        } else if (gamepad1.left_bumper) {
            Robot.ExtendArm.setPower(-0.3);
        } else {
            Robot.ExtendArm.setPower(0);
        }
    }

    public void controlSweeper() {
        if(gamepad1.a && !Robot.SweeperIsOn) {
            if(Robot.Sweeper.getPower() == 0) Robot.Sweeper.setPower(1);
            else Robot.Sweeper.setPower(0);
            Robot.SweeperIsOn = true;
        } else if(!gamepad1.a) Robot.SweeperIsOn = false;
    }
    */
    /*
    public void controlLift() {
        if (gamepad1.x) {
            Robot.Lift.setPower(1);
        } else if (gamepad1.b) {
            Robot.Lift.setPower(-1);
        } else {
            Robot.Lift.setPower(0);
        }
    }
    */
}
