// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.SwerveConstants;
import frc.robot.commands.ManualDrive;
import frc.robot.subsystems.Swerve;


public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    private final XboxController mController = new XboxController(Constants.kControllerPort);
    private final Swerve mSwerve = new Swerve();

    // Create new instance of ManualDrive, passing Swerve and Controller as parameters
    // 創造一個新的 ManualDrive instance, 給他 Swerve 跟 Controller 當 parameters
    private final ManualDrive mManualDriveCommand = new ManualDrive(mSwerve, mController);

    // PID controller for movement in the X direction
    // X 方向的 PID 控制器
    private PIDController mXController = new PIDController(
        SwerveConstants.kPathingX_kP, 
        SwerveConstants.kPathingX_kI, 
        SwerveConstants.kPathingX_kD
    );

    // PID controller for movement in the Y direction
    // Y 方向的 PID 控制器
    private PIDController mYController = new PIDController(
        SwerveConstants.kPathingY_kP, 
        SwerveConstants.kPathingY_kI, 
        SwerveConstants.kPathingY_kD
    );

    // PID controller for robot heading
    // 面對方向的 PID 控制器
    private PIDController mThetaController = new PIDController(
        SwerveConstants.kPathingTheta_kP, 
        SwerveConstants.kPathingTheta_kI, 
        SwerveConstants.kPathingTheta_kD
    );

    // Extract trajectory from PathPlanner
    // 從 PathPlanner 獲取 trajectory


    // private PathPlannerTrajectory mTrajectory = PathPlanner.loadPath(
    //     "New Path", 
    //     SwerveConstants.kMaxVelocityMetersPerSecond, 
    //     SwerveConstants.kMaxAccelerationMetersPerSecond
    // );

    public RobotContainer() {
        // Configure the button bindings
        configureButtonBindings();

        mSwerve.setDefaultCommand(mManualDriveCommand);




        
    }

    private void configureButtonBindings() {}

    // public Command getAutonomousCommand() {
    //     // Generate path following command from desired path
    //     PPSwerveControllerCommand command = new PPSwerveControllerCommand(
    //         mTrajectory, 
    //         mSwerve::getPose, 
    //         SwerveConstants.kSwerveKinematics, 
    //         mXController, 
    //         mYController, 
    //         mThetaController, 
    //         mSwerve::setModuleStates, 
    //         mSwerve
    //     );

    //     // `andThen...` is used to stop the robot after the path is finished
    //     // `andThen...` 用於在路徑完成後停止機器人
    //     return command.andThen(() -> mSwerve.drive(0, 0, 0, false));
    // }
}
