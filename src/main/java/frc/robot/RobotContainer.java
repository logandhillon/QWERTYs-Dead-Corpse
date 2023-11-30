// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.SpinMotor;
import frc.robot.subsystems.Motor;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
	// The robot's subsystems and commands are defined here...
	private final Motor sys_motor;

	private final SpinMotor cmd_spinMotor;

	private final CommandXboxController m_driverController = new CommandXboxController(
			OperatorConstants.kDriverControllerPort);

	/**
	 * The container for the robot. Contains subsystems, OI devices, and commands.
	 */
	public RobotContainer() {
		sys_motor = Motor.getInstance();
		cmd_spinMotor = new SpinMotor(m_driverController);

		sys_motor.setDefaultCommand(cmd_spinMotor);

		configureBindings();
	}

	private void configureBindings() {
	}

	public Command getAutonomousCommand() {
		return null;
	}
}
