package frc.robot.DriveTrain;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Joystick {

    private XboxController controller;
    private int port;



    public Joystick(int port) {

        this.controller = new XboxController(port);
        this.port = port;

    }
    
    
    public double getSpeedAxisLeft() {
        return controller.getY(Hand.kLeft);
    }

    public double getDirectionAxisRight() {
        return controller.getX(Hand.kRight);
    }

    



    







}