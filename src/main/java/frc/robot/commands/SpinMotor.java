package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Motor;

/**
 * Write a description of your command here
 * @author Logan Dhillon
 */
public class SpinMotor extends Command {
    private final Motor motor;
    private final CommandXboxController joystick;

    public SpinMotor(CommandXboxController joystick) {
        this.motor = Motor.getInstance();
        this.joystick = joystick;

        addRequirements(this.motor);
    }

    @Override
    public void initialize() {
        
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double accel = joystick.getRightTriggerAxis();
        double decel = joystick.getLeftTriggerAxis();
        double speed = accel - decel;
        motor.rotate(speed);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
