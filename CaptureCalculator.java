import java.util.Scanner;
import java.lang.Math;
public class CaptureCalculator {
	public static void main (String[] args){
		Scanner console = new Scanner(System.in);
	System.out.println("Hello and welcome to the Monster Capture Possibility Calculator. ");
	System.out.println("Please enter the latitude of the monster (1-10): ");
	int LatitudeMonster = console.nextInt();
	System.out.println("Please enter the longitude of the monster (1-10): ");
	int LongitudeMonster = console.nextInt();
	System.out.println("Please enter the time of the monster appear (1-1440): ");
	int TimeAppear = console.nextInt();
	System.out.println("Please enter the possible time of the monster will exist (10-59): ");
	int TimeExist = console.nextInt();
	System.out.println("Please enter the player’s ID (8 digits): ");
	int PlayerID = console.nextInt();
	System.out.println("Please enter the time of the player noticing monster (1-1440 and greater than the time the monster appears): ");
	int TimeNotice = console.nextInt();
	System.out.println("Please enter the latitude of the player (1-10): ");
	int LatitudePlayer = console.nextInt();
	System.out.println("Please enter the longitude of the player (1-10): ");
	int LongitudePlayer = console.nextInt();
	System.out.println("Please enter the player's walking speed (10-200): ");
	int WalkingSpeed = console.nextInt();
	//System.out.println("");
	
	//Determines lucky list or normal list
	int TensDigit = PlayerID / 10 % 10;
	
	if (TensDigit % 10 < 5) System.out.println("Player " + PlayerID + " who is on the lucky list,");
	else System.out.println("Player " + PlayerID + " who is on the normal list,");
	
	System.out.println("noticed the monster at time " + TimeNotice + ",");
	
	//Determines distance from player to monster (first calculation is in meters)
	double StraightDistance = (Math.sqrt((Math.pow(LatitudePlayer - LatitudeMonster, 2)) + Math.pow(LongitudePlayer - LongitudeMonster, 2)))*1000;
	double RoundedStraightDistance = Math.round(StraightDistance*10)/10.0;
	System.out.println("is " + RoundedStraightDistance + " m away from the monster,");
	
	//Determines time away of arrival
	double TravelTime = StraightDistance / WalkingSpeed;
	double RoundedAT = Math.round(TravelTime*10)/10.0;
	double ArrivalTime = RoundedAT + TimeNotice;
	System.out.println("and will arrive at time " + ArrivalTime + ".");
	
	//Determines monster disappear time
	int DisappearTime = TimeAppear + TimeExist;
	System.out.println("The monster's disappear time is about " + DisappearTime + ".");
	
	//Determines likelihood of capture. Disappear Probability= DP. First if statement is lucky list. Second if statement is normal list.
	if (ArrivalTime <= DisappearTime) System.out.println("So the player will capture this monster with definitely possibility.");
	
	double DP = (((ArrivalTime - DisappearTime)/TimeExist) * 100);
	//int RoundedDP = (int) Math.round(DP);
	if (TensDigit % 10 < 5){
		if (DP >= 0 && DP <= 10) System.out.println("So the player will capture this monster with highly likely possibility.");
		else if (DP > 10 && DP <= 30) System.out.println("So the player will capture this monster with likely possibility.");
		else if (DP > 30 && DP <= 40) System.out.println("So the player will capture this monster with unsure possibility.");
		else if (DP > 40 && DP <= 50) System.out.println("So the player will capture this monster with unlikely possibility.");
		else if (DP > 50) System.out.println("So the player will capture this monster with highly unlikely possibility.");
		}
	if (TensDigit % 10 > 4){
		if (DP >= 0 && DP <= 5) System.out.println("So the player will capture this monster with highly likely possibility.");
		else if(DP > 5 && DP <= 20) System.out.println("So the player will capture this monster with likely possibility.");
		else if (DP > 20 && DP <= 35) System.out.println("So the player will capture this monster with unsure possibility.");
		else if (DP > 35 && DP <= 40) System.out.println("So the player will capture this monster with unlikely possibility.");
		else if (DP > 40) System.out.println("So the player will capture this monster with highly unlikely possibility.");
	}
	}
}
