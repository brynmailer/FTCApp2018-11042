package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Toggle Motor", group="Iterative Opmode")
@Disabled
public class ToggleMotor extends OpMode {

    public DcMotor Motor = null;
    public Servo Servo = null;
    public Boolean MotorIsOn = false;
    boolean servoOn = false;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {
        Motor = hardwareMap.dcMotor.get("Motor");
        Servo = hardwareMap.servo.get("Servo");
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {
        if(gamepad1.a && !MotorIsOn) {
            if(Motor.getPower() == 0) Motor.setPower(1);
            else Motor.setPower(0);
            MotorIsOn = true;
        } else if(!gamepad1.a) MotorIsOn = false;

        if (gamepad1.b && !servoOn) {
            double time = runtime.time();
            servoOn = true;
            if (runtime.time() != (time + 1)) Servo.setPosition(1);
        }

        if (gamepad1.x && !servoOn) {
            double time = runtime.time();
            servoOn = true;
            if (runtime.time() < (time + 1)) Servo.setPosition(0);
        }

        if (servoOn) {
            if (runtime.time() >= (time + 1)) Servo.setPosition(0.5);
            servoOn = false;
        }

        telemetry.addData("Runtime", runtime.time());
    }

    @Override
    public void stop() {
    }
}
