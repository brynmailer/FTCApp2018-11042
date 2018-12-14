package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

// standard robot for 2018 ftc
public class GSRobot {
    public DcMotor DriveMotor1 = null;
    public DcMotor DriveMotor2 = null;
    public DcMotor DriveMotor3 = null;
    public DcMotor DriveMotor4 = null;
    public DcMotor PivotArm = null;
    public DcMotor ExtendArm = null;
    public DcMotor Sweeper = null;
    public DcMotor Lift = null;

    public boolean Switch = false;
    public int LiftPosition;
    public int ExtendPosition;
    public final int LIFT_MAX = 8400;
    public final int LIFT_MIN = 0;
    public final int EXTEND_MAX = -6600;
    public final int EXTEND_MIN = 0;
    public final double OPEN = 1.0;
    public final double CLOSE = 0.0;
    public final double STOP = 0.5;

    HardwareMap hwMap;

    /* Constructor */
    public GSRobot(){
    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        // Initialize motors
        DriveMotor1 = hwMap.dcMotor.get("DriveMotor1");
        DriveMotor2 = hwMap.dcMotor.get("DriveMotor2");
        DriveMotor3 = hwMap.dcMotor.get("DriveMotor3");
        DriveMotor4 = hwMap.dcMotor.get("DriveMotor4");
        PivotArm = hwMap.dcMotor.get("PivotArm");
        ExtendArm = hwMap.dcMotor.get("ExtendArm");
        Sweeper = hwMap.dcMotor.get("Sweeper");
        Lift = hwMap.dcMotor.get("Lift");

        // set direction of the motors
        DriveMotor1.setDirection(DcMotor.Direction.FORWARD);
        DriveMotor2.setDirection(DcMotor.Direction.REVERSE);
        DriveMotor3.setDirection(DcMotor.Direction.FORWARD);
        DriveMotor4.setDirection(DcMotor.Direction.REVERSE);

        // initialize encoders
        Lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LiftPosition = Lift.getCurrentPosition();
        ExtendArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        ExtendArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ExtendPosition = ExtendArm.getCurrentPosition();

        // Set all motors to zero power
        DriveMotor1.setPower(0);
        DriveMotor2.setPower(0);
        DriveMotor3.setPower(0);
        DriveMotor4.setPower(0);
        PivotArm.setPower(0);
        ExtendArm.setPower(0);
        Sweeper.setPower(0);
        Lift.setPower(0);
    }
}

