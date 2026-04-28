package frc.robot;

public class Constants {
    public class ShooterConstants {
        public static final int kShooterMotorID = 9;
        public static final double kShooterP = 0.1;
        public static final double kShooterI = 0.02;
        public static final double kShooterD = 0.00;
        public static final double kShooterS = 0.10;
        public static final double kShooterV = 0.10;
        public static final int kShooterSupplyCurrentLimit = 40;
        public static final int kShooterStatorCurrentLimit = 30;
    }

    public class IntakeConstants {
        public static final int kIntakeMotorID = 10;
        public static final double kIntakeP = 0.1;
        public static final double kIntakeI = 0;
        public static final double kIntakeD = 0;
        public static final double kIntakeS = 0.2;
        public static final double kIntakeV = 0.12;
        public static final int kIntakeSupplyCurrentLimit = 30;
        public static final int kIntakeStatorCurrentLimit = 40;
    }

}
