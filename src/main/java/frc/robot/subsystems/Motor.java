package frc.robot.subsystems;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.kMotor;

/**
 * Write a description of your subsystem here
 * 
 * @author Logan Dhillon
 */
public class Motor extends SubsystemBase {
    private static Motor instance = null;
    private static TalonFX motor;

    private static ShuffleboardTab sb_tab;
    private static GenericEntry sb_speed;

    public Motor() {
        motor = new TalonFX(kMotor.id);
        motor.setNeutralMode(NeutralModeValue.Brake);

        CurrentLimitsConfigs currentConfig = new CurrentLimitsConfigs();
        currentConfig.SupplyCurrentLimit = 30;

        TalonFXConfigurator configurator = motor.getConfigurator();
        configurator.apply(currentConfig, 0);

        sb_tab = Shuffleboard.getTab("the single motor that the programming team spent a few hours on");
        sb_speed = sb_tab.add("Speed", -999).getEntry();
    }

    public static Motor getInstance() { if (instance == null) instance = new Motor(); return instance; }

    public void rotate(double speed) {
        motor.setVoltage(speed);
        sb_speed.setDouble(speed);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
