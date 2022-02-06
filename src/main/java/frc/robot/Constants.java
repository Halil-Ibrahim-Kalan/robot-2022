// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Joystick
    public static final class JoystickConstants{
        public static final int F310  = 0; // Joystick
        public static final int Panel = 1; // Driver Station Button
    }

    // Drive
    public static final class DriveConstants{
        public static final int LeftMotor = 0;  // Sase Sol 
        public static final int RightMotor = 1; // Sase Sağ 
        public static final boolean LeftMotorInverted = true;
        public static final boolean RightMotorInverted = true;
    }

    // Climb
    public static final class ClimbConstants{
        public static final class Front {
            public static final int deviceID = 4;
            public static final MotorType motorType = MotorType.kBrushed;
            public static final boolean InvertedMode = true;
        }

        public static final class Back {
            public static final int deviceID = 4;
            public static final MotorType motorType = MotorType.kBrushed;
            public static final boolean InvertedMode = true;
        }
    }
    
    // Intake
    public static final class IntakeConstants{
        public static final int deviceID = 0;
        public static final boolean InvertedMode = true;
    }

    // Funnel
    public static final class FunnelConstants{
        public static final int deviceID = 7;
        public static final boolean InvertedMode = true;
    }

    // Shoter
    public static final class ShooterConstants{
        public static final int deviceID = 2;
        public static final boolean InvertedMode = true;
    }

    // Turret
    public static final class TurretConstants{
        public static final int deviceID = 3;
        public static final boolean InvertedMode = true;
        
        public static final class Encoder{
            public static final byte channelA = 0;
            public static final byte channelB = 1;
            public static final boolean reverseDirection = false;
            public static final double motorWheel = 3 / 2.54; //  (1 inch 2.54cm)
            public static final double turretWheel = 35 / 2.54;
            public static final double cpr = 5; //if am-3314a

        }
    }
}
