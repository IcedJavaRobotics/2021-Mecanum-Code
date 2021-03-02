/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;

public class DriveTrainSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveTrainSubsystem.
   */

  final CANSparkMax frontLeft;
  final CANSparkMax backLeft;
  final CANSparkMax frontRight;
  final CANSparkMax backRight;

  public DriveTrainSubsystem() {

    frontLeft = new CANSparkMax(Constants.FRONT_LEFT_SPARK, MotorType.kBrushed);
    backLeft = new CANSparkMax(Constants.BACK_LEFT_SPARK, MotorType.kBrushed);
    frontRight = new CANSparkMax(Constants.FRONT_RIGHT_SPARK, MotorType.kBrushed);
    backRight = new CANSparkMax(Constants.BACK_RIGHT_SPARK, MotorType.kBrushed);

    frontLeft.setInverted(false);
    backLeft.setInverted(false);
    frontRight.setInverted(true);
    backRight.setInverted(true);

  }

  public void moveMotor( double speed, CANSparkMax spark) {

    spark.set( speed );

  }

  public void mecanumDrive( double X, double Y, double R) {
    
    moveMotor( X + Y + R, frontLeft );
    moveMotor( X - Y + R, backLeft );
    moveMotor( X - Y - R, frontRight );
    moveMotor( X + Y - R, backRight );
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
