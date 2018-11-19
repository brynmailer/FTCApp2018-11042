package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Core Device Interface", group="Iterative Opmode")
@Disabled
public class GSOpMode_CoreDeviceInterface extends OpMode {

    private DeviceInterfaceModule coreDeviceInterfaceModule;
    private byte controlByte = 0;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {
        coreDeviceInterfaceModule = hardwareMap.deviceInterfaceModule.get("coreDeviceInterfaceModule");
        coreDeviceInterfaceModule.setDigitalIOControlByte(controlByte);
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
        telemetry.addData("Retrieved bit", "" + coreDeviceInterfaceModule.getDigitalInputStateByte());
        telemetry.addData("port 3", "" + (coreDeviceInterfaceModule.getDigitalInputStateByte() << 4));
    }

    @Override
    public void stop() {

    }
}