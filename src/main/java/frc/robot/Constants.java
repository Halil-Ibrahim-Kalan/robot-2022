// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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
    public static final class JoystickConstants {
        public static final int F310 = 0;
        public static final int Panel = 1;
        public static final int Panel2 = 2;
    }
    // Drive
    public static final class DriveConstants {
        public static final int LeftMotor = 3;
        public static final int RightMotor = 4;
        public static final boolean LeftMotorInverted = true;
        public static final boolean RightMotorInverted = true;
    }

    // Tunnel
    public static final class TunnelConstants {
        public static final int deviceID = 0;
    }

    // Intake
    public static final class IntakeConstants {
        public static final int deviceID = 7;
    }

    // Shoter
    public static final class ShooterConstants {
        public static final double kShootP = 0.025; // 0.04
        public static final double kShootI = 0.000;
        public static final double kShootD = 0.000;
        public static final double kS = 0.656;
        public static final double kV = 0.00202;
        public static final double kA = 0.000494;
        public static final int deviceID = 2;
    }

    // Climb
    public static final class ClimbConstants {
        // Window Motor
        public static final class Window {
            public static final class Left {
                public static final int deviceID = 6;
            }
            
            public static final class Right {
                public static final int deviceID = 5;
            }
        }

        // Climb Motor
        public static final class Climb {
            public static final int PWMLeft = 1;
            public static final int PWMRight = 0;
        }
    }

    public static final class TurretConstants {
        public static final int deviceID = 1;
        public static final int deviceIDy = 10;
        // Encoder
        public static final class Encoder {
            public static final byte channelA = 0; // DIO 0
            public static final byte channelB = 1; // DIO 1
            public static final boolean reverseDirection = false;
        }
    }

    // LED
    public static final class LEDConstants {
        public static final int PWMPort = 2;
    }

    // Motor Try
    public static final class MotorTryConstants {
        public static final int deviceID = 8;
    }

    // Trigger
    public static final class TriggerConstants {
        public static final int deviceID = 9;
    }
}
