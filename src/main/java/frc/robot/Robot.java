// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.PS4Controller.Button;//
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

//import java.io.Console;
//import java.util.logging.LogManager;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Robot extends TimedRobot {

  private VictorSPX leftMotor1 = new VictorSPX(2);
  private VictorSPX leftMotor2 = new VictorSPX(3);
  private VictorSPX rightMotor1 = new VictorSPX(1);
  private VictorSPX rightMotor2 = new VictorSPX(4);
  private VictorSPX updownL = new VictorSPX(0);
  private VictorSPX updownR = new VictorSPX(0);

  private Joystick joy1 = new Joystick(0);

  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
    leftMotor1.configFactoryDefault();
    leftMotor2.configFactoryDefault();
    rightMotor1.configFactoryDefault();
    rightMotor2.configFactoryDefault();
    updownL.configFactoryDefault();
    updownR.configFactoryDefault();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {    
    leftMotor1.set(ControlMode.PercentOutput,.2);
    leftMotor2.set(ControlMode.PercentOutput,.2);
    rightMotor1.set(ControlMode.PercentOutput,-0.2);
    rightMotor2.set(ControlMode.PercentOutput,-0.2);
  }

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {}

  public Robot() {
    addPeriodic(() -> {
        Functions.speed_limit();
      }, 0.01, 0.005);

    addPeriodic(() -> {
          trololo();
        }, 10.0, 0.005);
  }

  void trololo(){
    DriverStation.reportError("Error test", false);
  }

  @Override
  public void teleopPeriodic() {
    //Functions.speed_limit();

    double speed = -joy1.getRawAxis(1);
    double turn = joy1.getRawAxis(3);
    turn -= joy1.getRawAxis(2);

    double left = speed + turn;
    double right = speed - turn;
    left *= Functions.speedmult;
    right *= Functions.speedmult;

    leftMotor1.set(ControlMode.PercentOutput,left);
    leftMotor2.set(ControlMode.PercentOutput,left);
    rightMotor1.set(ControlMode.PercentOutput,-right);
    rightMotor2.set(ControlMode.PercentOutput,-right);

    Updown.up_down();
    
  }
  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}
}
