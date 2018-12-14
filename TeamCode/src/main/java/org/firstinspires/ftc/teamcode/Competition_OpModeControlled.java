package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Competition_OpModeControlled", group="Iterative Opmode")
public class Competition_OpModeControlled extends OpMode {

    // creates a generic robot
    GSRobot Robot = new GSRobot();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {
        // calls robot initialize method
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
        controlLift();
        telemetry.update();
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

    public void controlArm() {
        Robot.ExtendPosition = Robot.ExtendArm.getCurrentPosition();
        telemetry.addData("Extend Position", Robot.ExtendPosition);

        if ((Robot.ExtendPosition >= Robot.EXTEND_MIN && gamepad2.left_stick_y < 0) ||
                (Robot.ExtendPosition <= Robot.EXTEND_MAX && gamepad2.left_stick_y > 0) ||
                (Robot.ExtendPosition > Robot.EXTEND_MAX && Robot.ExtendPosition < Robot.EXTEND_MIN))
        {
            Robot.ExtendArm.setPower(-gamepad2.left_stick_y);
        } else {
            Robot.ExtendArm.setPower(0);
        }

        Robot.PivotArm.setPower(-gamepad2.right_stick_y);
    }

    public void controlSweeper() {
        /*
        if(gamepad2.x && !Robot.Switch) {
            if (Robot.Select.getPosition() == 0) Robot.Select.setPosition(1);
            else Robot.Select.setPosition(0);
            Robot.Switch = true;
        } else if(!gamepad2.x) Robot.Switch = false;
        */

        if (gamepad2.a) {
            Robot.Sweeper.setPower(-1);
        } else if (gamepad2.y) {
            Robot.Sweeper.setPower(0.8);
        } else if (gamepad2.b) {
            Robot.Sweeper.setPower(0);
        }
    }

    public void controlLift() {
        Robot.LiftPosition = Robot.Lift.getCurrentPosition();
        telemetry.addData("Lift Position", Robot.LiftPosition);
        if (gamepad1.x) {
            if (Robot.LiftPosition >= Robot.LIFT_MIN) {
                Robot.Lift.setPower(-1);
            } else {
                Robot.Lift.setPower(0);
            }
        } else if (gamepad1.b) {
            if (Robot.LiftPosition <= Robot.LIFT_MAX) {
                Robot.Lift.setPower(1);
            } else {
                Robot.Lift.setPower(0);
            }
        } else {
            Robot.Lift.setPower(0);
        }
    }
}
