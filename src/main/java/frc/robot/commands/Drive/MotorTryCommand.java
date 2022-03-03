// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands.Drive;

// import java.util.function.DoubleSupplier;
// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.subsystems.MotorTrySubsystem;

// public class MotorTryCommand extends CommandBase {
//   /** Creates a new MotorTryCommand. */
//   MotorTrySubsystem motor;
//   DoubleSupplier speed;
//   public MotorTryCommand(MotorTrySubsystem motor, DoubleSupplier speed) {
//     // Use addRequirements() here to declare subsystem dependencies.
//     this.motor = motor;
//     this.speed = speed;
//     addRequirements(this.motor);
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {}

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     motor.runmotor(speed.getAsDouble());
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {}

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return false;
//   }
// }
