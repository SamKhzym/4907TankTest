package frc.robot.DriveTrain;

public class DriveTrain {
    
    private Talon frontLeft, frontRight, backLeft, backRight;
    private double speed, direction;
    
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
        
        if (this.direction == 0) {
                
            this.frontLeft.setSpeed(this.speed);
            this.frontRight.setSpeed(this.speed);
            this.backLeft.setSpeed(this.speed);
            this.backRight.setSpeed(this.speed);  
        }
        
        else {

            /*
            //ALEX IMPLEMENTATION
            this.frontLeft.setSpeed(this.speed + this.direction);
            this.backLeft.setSpeed(this.speed + this.direction);
            this.frontRight.setSpeed(this.speed - this.direction);
            this.backRight.setSpeed(this.speed - this.direction);
            
            if (Math.abs(this.frontLeft.getSpeed()) > 1 || Math.abs(this.backLeft.getSpeed()) > 1 || 
            Math.abs(this.frontRight.getSpeed()) > 1 || Math.abs(this.backRight.getSpeed()) > 1) {
                
                this.frontLeft.setSpeed((this.speed + this.direction) / 2);
                this.backLeft.setSpeed((this.speed + this.direction) / 2);
                this.frontRight.setSpeed((this.speed - this.direction) / 2);
                this.backRight.setSpeed((this.speed - this.direction) / 2);
            }*/

            //SAM IMPLEMENTATION

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
    
}