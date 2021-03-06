// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.



package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.*; 
import frc.robot.subsystems.*; 
import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

 //declared and initallizes talons and victors for drive train 
    public static WPI_TalonSRX leftFrontTalon = new WPI_TalonSRX(2);
    public static WPI_VictorSPX leftBackVictor = new WPI_VictorSPX(3);
    public static WPI_TalonSRX rightFrontTalon = new WPI_TalonSRX(4); 
    public static WPI_VictorSPX rightBackVictor = new WPI_VictorSPX(5);


  //Initialzes subsystems in RobotContainer
  public static DriveBase driveBase;
//Initializes commands in RobotContainer
  public static DriveWithJoystick driveWithJoystick; 


  public static Joystick rightJoystick; 
  public static Joystick leftJoystick; 

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

leftJoystick = new Joystick(0);
rightJoystick = new Joystick(1);

driveBase = new DriveBase();
driveWithJoystick = new DriveWithJoystick();
CommandScheduler.getInstance().setDefaultCommand(driveBase, driveWithJoystick);


    // Configure the button bindings
    configureButtonBindings();
  }





  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  public static Joystick getRightJoystick(){
    return rightJoystick;
  }

  public static Joystick getLeftJoystick(){
    return leftJoystick;
  }

 /* public static Joystick getLogitech(){
    return logitech;
  }*/
}
