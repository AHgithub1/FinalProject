package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.IntakeConstants;
import static frc.robot.Constants.IntakeConstants;


import java.lang.Object;

import com.ctre.phoenix.motorcontrol.IFollower;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class IntakeRollerSubsystem extends SubsystemBase{
    private final XboxController controller;
    private final JoystickButton Lbutton;
    private final JoystickButton Rbutton;
    private final CANSparkMax frontMotor;
    private final TalonSRX integrationMotor; // this runs the integration roller
    private final JoystickButton Bbutton;
    private final JoystickButton Abutton;
    private final JoystickButton Ybutton;
    
    public IntakeRollerSubsystem() {
        controller = new XboxController(0);
        Lbutton = new JoystickButton(controller, XboxController.Axis.kLeftTrigger.value);
        Rbutton = new JoystickButton(controller, XboxController.Axis.kRightTrigger.value);
        frontMotor = new CANSparkMax(17, MotorType.kBrushless);
        integrationMotor = new TalonSRX(19);
        Bbutton = new JoystickButton(controller, XboxController.Button.kB.value);
        Abutton = new JoystickButton(controller, XboxController.Button.kA.value);
        Ybutton = new JoystickButton(controller, XboxController.Button.kY.value);
    }
    public void SetSpeedFrontMotor(double speed){
        frontMotor.set(speed); //set up speed for the CANSpark Max front motor
    }
    public void SetSpeedTalonMotor(double speed){
        integrationMotor.set(ControlMode.PercentOutput, speed); // for the integrationMotor
    }
    public void stop(boolean pressed){
        if (pressed){ //this is the brake if b is pressed
            frontMotor.set(0.0);
            integrationMotor.set(ControlMode.PercentOutput, 0.0);
        }
    }
}

