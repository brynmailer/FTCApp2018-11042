package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class GSRobot {
    // public DeviceInterfaceModule cdim;

    public DcMotor DriveMotor1 = null;
    public DcMotor DriveMotor2 = null;
    public DcMotor DriveMotor3 = null;
    public DcMotor DriveMotor4 = null;

    // public DcMotor PivotArm = null;
    // public DcMotor ExtendArm = null;
    // public DcMotor Sweeper = null;

    public DcMotor Lift = null;

    // public ColorSensor ColorSensor;

    // public Boolean SweeperIsOn = false;

    HardwareMap hwMap;

    /* Constructor */
    public GSRobot(){
    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        // Initialize modules
        // cdim = hwMap.deviceInterfaceModule.get("cdim");

        // Initialize motors
        DriveMotor1 = hwMap.dcMotor.get("DriveMotor1");
        DriveMotor2 = hwMap.dcMotor.get("DriveMotor2");
        DriveMotor3 = hwMap.dcMotor.get("DriveMotor3");
        DriveMotor4 = hwMap.dcMotor.get("DriveMotor4");
        /*
        PivotArm = hwMap.dcMotor.get("PivotArm");
        ExtendArm = hwMap.dcMotor.get("ExtendArm");
        Sweeper = hwMap.dcMotor.get("Sweeper");
        */
        Lift = hwMap.dcMotor.get("Lift");

        // Initialize sensors
        // ColorSensor = hwMap.colorSensor.get("ColorSensor");

        // set direction of the motors
        DriveMotor1.setDirection(DcMotor.Direction.REVERSE);
        DriveMotor2.setDirection(DcMotor.Direction.FORWARD);
        DriveMotor3.setDirection(DcMotor.Direction.REVERSE);
        DriveMotor4.setDirection(DcMotor.Direction.FORWARD);

        // Set all motors to zero power
        DriveMotor1.setPower(0);
        DriveMotor2.setPower(0);
        DriveMotor3.setPower(0);
        DriveMotor4.setPower(0);
        /*
        PivotArm.setPower(0);
        ExtendArm.setPower(0);
        Sweeper.setPower(0);
        */
        Lift.setPower(0);
    }
}

