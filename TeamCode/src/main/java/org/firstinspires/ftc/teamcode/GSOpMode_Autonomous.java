package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Autonomous 1", group="Linear Opmode")
@Disabled
public class GSOpMode_Autonomous extends LinearOpMode {

    GSRobot robot = new GSRobot();
    ModernRoboticsI2cGyro gyro = null;

    double heading;

    @Override
    public void runOpMode () {
        robot.init(hardwareMap);

        gyro = (ModernRoboticsI2cGyro)hardwareMap.gyroSensor.get("gyro");

        telemetry.addData(">", "Calibrating Gyro");
        telemetry.update();
        gyro.calibrate();

        while (!isStopRequested() && gyro.isCalibrating())  {
            sleep(50);
            idle();
        }

        telemetry.addData(">", "Robot Ready.");
        telemetry.update();

        while (!isStarted()) {

    }

        while (opModeIsActive()) {
            // lower robot

            // turn 45 degrees to the right
            heading = gyro.getHeading();
            while (heading != 315) {
                if (heading != 315) {
                    robot.DriveMotor1.setPower(0.1);
                    robot.DriveMotor2.setPower(-0.1);
                    robot.DriveMotor3.setPower(0.1);
                    robot.DriveMotor4.setPower(-0.1);
                } else {
                    robot.DriveMotor1.setPower(0);
                    robot.DriveMotor2.setPower(0);
                    robot.DriveMotor3.setPower(0);
                    robot.DriveMotor4.setPower(0);
                }
                heading = gyro.getHeading();
            }

            //
        }
    }
}
