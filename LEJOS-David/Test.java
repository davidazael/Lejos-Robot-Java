import java.lang.Thread.*;
import lejos.nxt.*;
import static lejos.nxt.Sound.*;
import lejos.nxt.Motor.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.Button;
import static java.lang.System.*;



public class Test
{
	public static void main(String args[])
	{
		new Model(); 
		
	}            
}

class Model
{
	DifferentialPilot robo = new DifferentialPilot(2.1f, 4.4f, Motor.A, Motor.C, true);
	LightSensor sensor = new LightSensor( SensorPort.S4, true);
	public Model()
	{
		
		boolean pressed = false;
		Music jurassic = new Music();
		
		DifferentialPilot robo = new DifferentialPilot(2.1f, 4.4f, Motor.A, Motor.C, true);
		LightSensor sensor = new LightSensor( SensorPort.S4, true);
		
		
		//raceTrack();
		//cansOut();
		//posCan();
		//lastMission();
		theMovements();
	}
	
	public void theMovements()
	{	
		robo.setTravelSpeed(12);
		robo.setRotateSpeed(120);
		Motor.A.setSpeed(720);
		Motor.C.setSpeed(720);
		
		try 
    	{
    		int x=0;
    		boolean pressed = false;
	    	while(!Button.ESCAPE.isDown() && x < 7)
		   	{
		   		if(Button.LEFT.isDown())
		   		{
		   			sensor.calibrateHigh();
		   			System.out.println("High: " + sensor.getNormalizedLightValue());
		   		}
		   		if(Button.RIGHT.isDown())
		   		{
		    		sensor.calibrateLow();
		   			System.out.println("Low: " + sensor.getNormalizedLightValue());
		   		}
		   		if(Button.ENTER.isDown())
		   		{
		   			pressed=true;
		   		}
		   		
		   		while(pressed==true && x < 7)
		   		{
		   			if(Button.ESCAPE.isDown())
		   			{
		   				pressed=false; 
		   			}
		   			robo.backward();
		   			out.println(""+sensor.getNormalizedLightValue());
		   			if(sensor.getNormalizedLightValue() <= 400)
		   			{
		   				x++;
		   				robo.stop();
		   				robo.rotate(83.5);
		   			}
					System.out.println("SENSOR: " + sensor.getNormalizedLightValue());
		   			System.out.println("ENTER");
	    		}
    		}
    		robo.travel(-1000);
    		out.println("Done");
    	}
    	catch(Exception e){}
	}

	public void raceTrack()
	{
		boolean pressed = false;
    	
    	Music jurassic = new Music();
    	
    	DifferentialPilot pilot = new DifferentialPilot(2.1f, 4.4f, Motor.A, Motor.C, true);  
    	LightSensor sensor = new LightSensor( SensorPort.S1, true);	
    	LightSensor sensor2 = new LightSensor( SensorPort.S4, true);	
    	
    	Motor.A.setSpeed(2180);	
    	Motor.C.setSpeed(2180);   	
    	try 
    	{
	    	while(!Button.ESCAPE.isDown())
		   	{
				Thread.sleep(500);
		   		if(Button.LEFT.isDown())
		   		{
		   			sensor.calibrateHigh();
		   			sensor2.calibrateLow();
		   			System.out.println("LEFT high: " + sensor.getLightValue());
		   			System.out.println("RIGHT low: " + sensor2.getLightValue());
		   		}
		   		if(Button.RIGHT.isDown())
		   		{
		    		sensor.calibrateLow();
		   			sensor2.calibrateHigh();
		   			System.out.println("RIGHT high: " + sensor2.getLightValue());
		   			System.out.println("LEFT low: " + sensor.getLightValue());
		   		}
		   		if(Button.ENTER.isDown())
		   		{
		   			pressed=true;
		   		}
		   		while(pressed==true)
		   		{
		   			if(Button.ESCAPE.isDown())
		   			{
		   				pressed=false;
		   			}
		   			jurassic.start();
		   			Motor.A.forward();	
		   			Motor.C.forward();
	   				if( sensor.getLightValue() > 20)
	   				{
	   					Motor.A.setSpeed( 260);
	   					Motor.C.setSpeed( 720);
		   			}
		   			if(sensor2.getLightValue() > 20)
	   				{
	   					Motor.A.setSpeed( 720);
	   					Motor.C.setSpeed( 260);
	   				}
		   			if( sensor.getLightValue() <= 20 && sensor2.getLightValue() <= 20)
		   			{
	   					Motor.A.setSpeed( 720);
	   					Motor.C.setSpeed( 720);
	   				}
	   				if( sensor.getLightValue() > 20 && sensor2.getLightValue() > 20)
	   				{
	   					Motor.A.setSpeed(0);
	   					Motor.C.setSpeed(0);
	   				}
					System.out.println("LEFT: " + sensor.getLightValue());
					System.out.println("RIGHT : " + sensor2.getLightValue());
		   			System.out.println("ENTER");
	    		}
    		}
    	}
    	catch(Exception e){}
	}
	
	public void cansOut()
	{
    	DifferentialPilot pilot = new DifferentialPilot(2.1f, 4.4f, Motor.A, Motor.C, true);	
    	
    	try
    	{
    		Motor.A.forward();
	    	Motor.C.forward();
	    	
	    	double speed = pilot.getRotateSpeed() / 2;
	    	
	    	pilot.setRotateSpeed( speed );
	    	
	    	System.out.println( pilot.getRotateSpeed() );
	    	
	    	pilot.travel(-15);
	    	pilot.rotate(-90);
	    	pilot.travel(-25);
	    	pilot.rotate(90);
	    	pilot.travel(-10);
	    	pilot.rotate(90);
	    	pilot.travel(-25);
    	}
    	catch(Exception e){}
	}
	
	public void posCan()
	{
		DifferentialPilot pilot = new DifferentialPilot(2.1f, 4.4f, Motor.A, Motor.C, true);
		//pilot.steer(-50,180,true); // turn 180 degrees to the right

		try
		{
			Motor.A.forward();
			Motor.C.forward();
			
			System.out.println( pilot.getRotateSpeed() );
			System.out.println( pilot.getTravelSpeed() );
		
			pilot.rotate(-85);
			pilot.travel(-35);
			pilot.setRotateSpeed(pilot.getRotateSpeed()/4);
			pilot.rotate(-120);
			pilot.travel(-9);
			pilot.setRotateSpeed(pilot.getRotateSpeed()*4);
			pilot.travel(5);
			pilot.rotate(37);
			pilot.travel(-27);
			pilot.setRotateSpeed(pilot.getRotateSpeed()/4);
			pilot.rotate(-120);
			pilot.travel(-10);
			pilot.setRotateSpeed(pilot.getRotateSpeed()*4);
			pilot.travel(5);
			pilot.rotate(30);
			pilot.travel(-27);
			pilot.setRotateSpeed(pilot.getRotateSpeed()/4);
			pilot.rotate(-120);
			pilot.travel(-5);
		}
		catch(Exception e){}
		
	}
	
	public void lastMission()
	{
		DifferentialPilot pilot = new DifferentialPilot(2.1f, 4.4f, Motor.A, Motor.C, true);
		
		
		try 
		{
			//Motor.A.forward();
	    	//Motor.C.forward();
	    	Motor.B.forward();
	    	
	    	double speed = pilot.getRotateSpeed() / 2;
	    	
	    	pilot.setRotateSpeed( speed );
	    	
	    	Motor.B.setSpeed(300);
	    	Thread.sleep(575);
	    	Motor.B.backward();
	    	Motor.B.setSpeed(300);
	    	Thread.sleep(500);
	    	Motor.B.stop();
	    	
	    	pilot.travel(-8);
	    	pilot.rotate(90);
	    	pilot.travel(-30);
	    	
	    	Motor.B.backward();
	    	Motor.B.setSpeed(300);
	    	Thread.sleep(250);
	    	Motor.B.stop();
			
		}
		catch
			(Exception ex){}
	}
}               

class Music extends Thread
{
	public void run()
	{
			Sound.playNote(PIANO,440, 250); 
			playNote(PIANO,466, 1500);	
			playNote(PIANO,466, 250);	
			playNote(PIANO,440, 250);	
			playNote(PIANO,466, 1500);	
			playNote(PIANO,466, 250);	
			playNote(PIANO,440, 250);	
			playNote(PIANO,466, 750);	
			playNote(PIANO,523, 250);	
			playNote(PIANO,523, 750);	
			playNote(PIANO,622, 250);	
			playNote(PIANO,622, 1500);	
			playNote(PIANO,587, 250);	
			playNote(PIANO,466, 250);	
			playNote(PIANO,523, 750);	
			playNote(PIANO,440, 250);	
			playNote(PIANO,349, 500);	
			playNote(PIANO,587, 250);	
			playNote(PIANO,466, 250);	
			playNote(PIANO,523, 1500);	
			playNote(PIANO,698, 250);	
			playNote(PIANO,466, 250);	
			playNote(PIANO,622, 750);	
			playNote(PIANO,587, 250);	
			playNote(PIANO,587, 750);	
			playNote(PIANO,523, 250);	
			playNote(PIANO,523, 1500);	
			playNote(PIANO,466, 250);	
			playNote(PIANO,440, 250);	
			playNote(PIANO,466, 1500);	
			playNote(PIANO,466, 250);	
			playNote(PIANO,440, 250);	
			playNote(PIANO,466, 1500);	
			playNote(PIANO,466, 250);	
			playNote(PIANO,440, 250);	
			playNote(PIANO,466, 500);	
			playNote(PIANO,349, 500);	
			playNote(PIANO,698, 500);	
			playNote(PIANO,622, 250);	
			playNote(PIANO,587, 250);	
			playNote(PIANO,622, 1500);	
			playNote(PIANO,698, 250);	
			playNote(PIANO,523, 250);	
			playNote(PIANO,622, 750);	
			playNote(PIANO,587, 250);	
			playNote(PIANO,523, 500);
			playNote(PIANO,598, 250);
			playNote(PIANO,523, 250);
			playNote(PIANO,622, 1500);
			playNote(PIANO,698, 250);
			playNote(PIANO,523, 250);	
	}
}  