/* Basic Commands
 *DifferentialPilot robo = new DifferentialPilot(2.1f,4.4f,Motor.A, Motor.C,true);
 *robo.setRotateSpeed(80);
 *robo.setTravelSpeed(5);
 *robo.travel(-5);
 *robo.stop();
 *Delay.msDelay(100);
 *Motor.B.setSpeed(22);
 *Motor.B.rotate(80);
 *robo.rotate(-215);
 *
 *Imports
import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.Sound;
import java.util.*;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.robotics.Color;
import static java.lang.System.*;
import lejos.util.Delay;
*/

import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.Sound;
import java.util.*;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.robotics.Color;
import static java.lang.System.*;
import lejos.util.Delay;

class basic
{
	public static void main(String args[])
	{
		DifferentialPilot robo = new DifferentialPilot(2.1f,4.4f,Motor.A, Motor.C,true);
		robo.setTravelSpeed(15);
		robo.setRotateSpeed(120);
		
		
		
		robo.travel(-20);
		robo.rotate(-170);
		robo.travel(-20);
		robo.rotate(-170);
	}
}