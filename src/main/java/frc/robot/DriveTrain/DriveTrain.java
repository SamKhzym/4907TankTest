// Copyright Alex 2020 -- Software Piracy Punishable by Death

package frc.robot.DriveTrain;

public class DriveTrain {
    
    private Talon frontLeft, frontRight, backLeft, backRight;
    private double speed, direction;
    private Joystick joystick;
    
    public DriveTrain(Talon fl, Talon fr, Talon bl, Talon br) {
        this.frontLeft = fl;
        this.frontRight = fr;
        this.backLeft = bl;
        this.backRight = br;
    }
    
    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }
    
    public void setSpeedAndDirection(double speed, double direction) {
        this.speed = speed;
        this.direction = direction;
    }
    
    public void execute() {
        joystick.updateAxisValues();

        this.speed =  joystick.getSpeedAxisLeft();
        this.direction = joystick.getDirectionAxisRight();

        double leftSpeed, rightSpeed;

        if (this.speed > 0) {
            leftSpeed = (this.speed + this.direction >= 1) ? 1 : this.speed + this.direction;
            rightSpeed = (this.speed - this.direction <= -1) ? -1 : this.speed - this.direction;
        }
        else {

            rightSpeed = (this.speed + this.direction >= 1) ? 1 : this.speed + this.direction;
            leftSpeed = (this.speed - this.direction <= -1) ? -1 : this.speed - this.direction;

        }

        this.frontLeft.setSpeed(leftSpeed);
        this.backLeft.setSpeed(leftSpeed);
        this.frontRight.setSpeed(rightSpeed);
        this.backRight.setSpeed(rightSpeed);


    }
    
}