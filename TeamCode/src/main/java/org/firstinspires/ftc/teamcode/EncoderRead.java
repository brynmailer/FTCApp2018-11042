package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Encoder Read", group = "Calibration")
@Disabled
public class EncoderRead extends OpMode {
    public DcMotor Motor = null;
    public int MotorPosition;
    public final int MOTOR_MAX = -8200;
    public final int MOTOR_MIN = 0;

    @Override
    public void init() {
        Motor = hardwareMap.dcMotor.get("Motor");
        Motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {
        MotorPosition = Motor.getCurrentPosition();
        telemetry.addData("position", MotorPosition);
        telemetry.update();
        if (gamepad1.x) {
            if (MotorPosition >= MOTOR_MIN) {
                Motor.setPower(-1);
            } else {
                Motor.setPower(0);
            }
        } else if (gamepad1.b) {
            if (MotorPosition <= MOTOR_MAX) {
                Motor.setPower(1);
            } else {
                Motor.setPower(0);
            }
        } else {
            Motor.setPower(0);
        }
    }

    @Override
    public void stop() {

    }
}
