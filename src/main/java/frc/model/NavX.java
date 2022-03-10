package frc.model;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.math.geometry.Rotation2d;


public final class NavX {
    private final AHRS navX;
    private Rotation2d adjustmentAngle = new Rotation2d(0,0);
	private boolean inverted;


    public NavX(SPI.Port port) {
        this(port, (byte) 200);
    }

    public NavX(SPI.Port port, byte updateRate) {
        navX = new AHRS(port, updateRate);
    }


    public void reset() {
        navX.zeroYaw();
        navX.reset();
    }

    public final Rotation2d getAngle() {
        Rotation2d angle = getUnadjustedAngle().rotateBy(new Rotation2d(adjustmentAngle.getCos(), -adjustmentAngle.getSin()));
        
		return angle;
	}

	public final Rotation2d getAdjustmentAngle() {
		return adjustmentAngle;
	}

	public void setAdjustmentAngle(Rotation2d adjustmentAngle) {
		this.adjustmentAngle = adjustmentAngle;
	}

    public Rotation2d getUnadjustedAngle() {
        return new Rotation2d(getAxis(Axis.YAW));
    }

    public double getUnadjustedRate() {
        return Math.toRadians(navX.getRate());
    }

    public double getAxis(Axis axis) {
        switch (axis) {
            case PITCH:
                return Math.toRadians(navX.getPitch());
            case ROLL:
                return Math.toRadians(navX.getRoll());
            case YAW:
                return Math.toRadians(-navX.getYaw());
            default:
                return 0.0;
        }
    }

    public enum Axis {
        PITCH,
        ROLL,
        YAW
    }
}
