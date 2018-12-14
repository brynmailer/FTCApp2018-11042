package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="ControlLift", group="Iterative Opmode")
public class ControlLift extends OpMode {

    public DcMotor Lift = null;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {
        Lift = hardwareMap.dcMotor.get("Lift");
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
        controlLift();
    }

    @Override
    public void stop() {
    }

    public void controlLift() {
        if (gamepad1.x) {
            Lift.setPower(-1);
        } else if (gamepad1.b) {
            Lift.setPower(1);
        } else {
            Lift.setPower(0);
        }
    }
}
