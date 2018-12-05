import java.time.*;
import java.util.*;
import java.io.*;

class SortBy{
	//fields
	private static int sortByThis;
	
	//constructor
	public SortBy(){
		sortByThis = 1; //default setting (by last name)
	}
	
	//setter
	public void setSortByThis(int sortByThis){
		this.sortByThis = sortByThis;	
	}
	
	//getter
	public int getSortByThis(){
		return sortByThis;	
	}
}

class HockeyPlayer extends SortBy implements Comparable<HockeyPlayer>{
	//fields
	private String lastName;
	private String position;
	private String birthplace;
	private int gamesPlayed;
	private int winsPoints;
	private LocalDate date;
	
	//constructors
	public HockeyPlayer(String lastName, String position, String birthplace){
		this.lastName = lastName;
		this.position = position;	
		this.birthplace = birthplace;
		this.date = LocalDate.now();
	}
	
	public HockeyPlayer(HockeyPlayer hp, int gamesPlayed, int winsPoints){
		this(hp.lastName, hp.position, hp.birthplace);
		this.gamesPlayed = gamesPlayed;
		this.winsPoints = winsPoints;
	}
	
	//setters
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public void setPosition(String position){
		this.position = position;
	}
	
	public void setBirthplace(String birthplace){
		this.birthplace = birthplace;	
	}
	
	public void setGamesPlayed(int gamesPlayed){
		this.gamesPlayed = gamesPlayed;	
	}
	
	public void setWinsPoints(int winsPoints){
		this.winsPoints = winsPoints;	
	}
	
	//getters
	public String getLastName(){
		return lastName;	
	}
	
	public String getPosition(){
		return position;	
	}

	public String getBirthplace(){
		return birthplace;	
	}
	
	public int getGamesPlayed(){
		return gamesPlayed;	
	}
	
	public int getWinsPoints(){
		return winsPoints;	
	}
	
	public LocalDate getDate(){
		return date;	
	}
	
	@Override
	public String toString(){
		return lastName + " is a " + position + ".";
	}
	
	@Override
    	public int compareTo(HockeyPlayer other) {
    	if(getSortByThis() == 1){	
    		if (this.getLastName().charAt(0) < other.getLastName().charAt(0)) {
			return 1;
		}
		else if (this.getLastName().equals(other.getLastName())) { 
			return 0;
		}
		else{
			return -1;	
		}
    		
    	}
    	if(getSortByThis() == 2){	
    		if (this.getPosition().charAt(0) < other.getPosition().charAt(0)) {
			return 1;
		}
		else if (this.getPosition().equals(other.getPosition())) { 
			return 0;
		}
		else{
			return -1;	
		}
    		
    	}
    	else if(getSortByThis() == 3){
		if (this.getGamesPlayed() < other.getGamesPlayed()) {
			return 1;
		}
		else if (this.getGamesPlayed() == other.getGamesPlayed()) { 
			return 0;
		}
		else{
			return -1;	
		}
	}
	else if(getSortByThis() == 4){
		if (this.getWinsPoints() < other.getWinsPoints()) {
			return 1;
		}
		else if (this.getWinsPoints() == other.getWinsPoints()) { 
			return 0;
		}
		else{
			return -1;	
		}
	}
	else{
		return -1;	
	}
    	}

}

class Goalie extends HockeyPlayer{
	//fields
	private int shotsAgainst;
	private int saves;
	private double saveP;
	private double avgWinsGP;
	
	//constructor
	public Goalie(HockeyPlayer hp, int gamesPlayed, int wins, int shotsAgainst, int saves){
		super(hp, gamesPlayed, wins);
		this.shotsAgainst = shotsAgainst;
		this.saves = saves;
		setSaveP();
		this.saveP = getSaveP();
		setAvgWinsGP();
		this.avgWinsGP = getAvgWinsGP();
	}
	
	//setters
	public void setShotsAgainst(int shotsAgainst){
		this.shotsAgainst = shotsAgainst;	
	}
	
	public void setSaves(int saves){
		this.saves = saves;	
	}
	
	public void setSaveP(){
		try{
			if(shotsAgainst > 0){
				saveP = ((double)saves/(double)shotsAgainst)*100;	
			}
			else{
				saveP = 0;	
			}
		}
		catch(ArithmeticException ae){
			System.out.println("Exception: " + ae + ".");	
		}
		catch(Exception e){
			System.out.println("Exception: " + e + ".");	
		}	
	}
	
	public void setAvgWinsGP(){
		try{
			if(getGamesPlayed() > 0){
				avgWinsGP = (double)getWinsPoints()/(double)getGamesPlayed();	
			}
			else{
				avgWinsGP = 0;	
			}
		}
		catch(ArithmeticException ae){
			System.out.println("Exception: " + ae + ".");	
		}
		catch(Exception e){
			System.out.println("Exception: " + e + ".");	
		}
	}
	
	//getters
	public int getShotsAgainst(){
		return shotsAgainst;
	}
	
	public int getSaves(){
		return saves;	
	}
	
	public double getSaveP(){
		return saveP;	
	}
	
	public double getAvgWinsGP(){
		return avgWinsGP;	
	}
	
	@Override
	public String toString(){
		return String.format("%-15s | %-15s | %-14d | %-10d | %-14f | %-16f | %-14tF %n", getLastName(), getPosition(), getGamesPlayed(), getWinsPoints(), saveP, avgWinsGP, getDate());	
	}
	
}

class Skater extends HockeyPlayer{
	//fields
	private int shots;
	private int goals;
	private double shotP;
	private double avgPtsGP;
	
	//constructor
	public Skater(HockeyPlayer hp, int gamesPlayed, int points, int shots, int goals){
		super(hp, gamesPlayed, points);
		this.shots = shots;
		this.goals = goals;
		setShotP();
		this.shotP = getShotP();
		setAvgPtsGP();
		this.avgPtsGP = getAvgPtsGP();
	}
	
	//setters
	public void setShots(int shots){
		this.shots = shots;	
	}
	
	public void setGoals(int goals){
		this.goals = goals;	
	}
	
	public void setShotP(){
		try{
			if(shots > 0){
				shotP = ((double)goals/(double)shots)*100;	
			}
			else{
				shotP = 0;	
			}
		}
		catch(ArithmeticException ae){
			System.out.println("Exception: " + ae + ".");	
		}
		catch(Exception e){
			System.out.println("Exception: " + e + ".");	
		}	
	}
	
	public void setAvgPtsGP(){
		try{
			if(getGamesPlayed() > 0.0){
				avgPtsGP = (double)getWinsPoints()/(double)getGamesPlayed();	
			}
			else{
				avgPtsGP = 0.0;	
			}
			
		}
		catch(ArithmeticException ae){
			System.out.println("Exception: " + ae + ".");	
		}
		catch(Exception e){
			System.out.println("Exception: " + e + ".");	
		}
	}
	
	//getters
	public int getShots(){
		return shots;
	}
	
	public int getGoals(){
		return goals;	
	}
	
	public double getShotP(){
		return shotP;	
	}
	
	public double getAvgPtsGP(){
		return avgPtsGP;	
	}
	
	@Override 
	public String toString(){
		return String.format("%-15s | %-15s | %-14d | %-10d | %-14f | %-16f | %-14tF %n", getLastName(), getPosition(), getGamesPlayed(), getWinsPoints(), shotP, avgPtsGP, getDate());	
	}
	
}

class Roster{
	//field
	private ArrayList<HockeyPlayer> roster2018;
	
	//constructor
	public Roster(){
		setRoster2018();	
	}
	
	//setter
	public void setRoster2018(){
		HockeyPlayer ek  = new HockeyPlayer("Kuznetsov", "Center", "Russia");
		//hp, gp, pts, shots, goals
		Skater ek2018 = new Skater(ek, 21, 25, 59, 7);
		
		HockeyPlayer ab = new HockeyPlayer("Burakovsky", "Left Wing", "Austria");
		Skater ab2018 = new Skater(ab, 27, 7, 32, 4);
			
		HockeyPlayer tw = new HockeyPlayer("Wilson", "Right Wing", "Canada");
		Skater tw2018 = new Skater(tw, 11, 14, 26, 8);
		
		HockeyPlayer bh = new HockeyPlayer("Holtby", "Goalie", "Canada");
		//hp, gp, wins, shotsAg, saves
		Goalie bh2018 = new Goalie(bh, 20, 10, 616, 559);
			
		HockeyPlayer jc = new HockeyPlayer("Carlson", "Defense", "USA");
		Skater jc2018 = new Skater(jc, 26, 29, 62, 5);
			
		HockeyPlayer ao = new HockeyPlayer("Ovechkin", "Left Wing", "Russia");
		Skater ao2018 = new Skater(ao, 27, 33, 103, 20);
			
		HockeyPlayer pc = new HockeyPlayer("Copley", "Goalie", "USA");
		Goalie pc2018 = new Goalie(pc, 9, 5, 247, 222);
			
		HockeyPlayer mb = new HockeyPlayer("Bowey", "Defense", "Canada");
		Skater mb2018 = new Skater(mb, 19, 5, 17, 0);
			
		HockeyPlayer nb = new HockeyPlayer("Backstrom", "Center", "Sweden");
		Skater nb2018 = new Skater(nb, 27, 33, 61, 10);
			
		HockeyPlayer to = new HockeyPlayer("Oshie", "Right Wing", "USA");
		Skater to2018 = new Skater(to, 18, 14, 40, 9);
		
		HockeyPlayer test = new HockeyPlayer("TEST", "Goalie", "Italy");
		Goalie test2018 = new Goalie(test, 5, 4, 79, 75);
			
		HockeyPlayer[] rosterArray2018 = {ek2018, ab2018, tw2018, bh2018, jc2018, ao2018, pc2018, mb2018, nb2018, to2018, test2018};
		roster2018 = new ArrayList<HockeyPlayer>(Arrays.asList(rosterArray2018));	
	}
	
	//getter
	public ArrayList<HockeyPlayer> getRoster2018(){
		return roster2018;	
	}
}

public class DataTableV2{
	
	private static int ctr;
	
	public static void createTable(int sortNum){
		System.out.println(String.format("%-15s | %-15s | %-5s | %-10s | %-14s | %-16s | %-14s", "NAME: ", "POSITION: ", "GAMES PLAYED: ",  "PTS: ", "SHOT %:  ", "AVG PTS/GP:", "LAST UPDATED: "));
		System.out.println("*******************************************************************************************************************");
		Roster r = new Roster();
		SortBy sb = new SortBy();
		sb.setSortByThis(sortNum);
		Collections.sort(r.getRoster2018());
			for(HockeyPlayer o : r.getRoster2018()){
				if(o.getPosition() != "Goalie"){
					System.out.print(o);
				}
			}
		
		System.out.println("\n");
		System.out.println(String.format("%-15s | %-15s | %-5s | %-10s | %-14s | %-16s | %-14s", "NAME: ", "POSITION: ", "GAMES PLAYED: ",  "WINS: ", "SAVE %:  ", "AVG WINS/GP:", "LAST UPDATED: "));
		System.out.println("*******************************************************************************************************************");
		for(HockeyPlayer o : r.getRoster2018()){
				if(o.getPosition().equals("Goalie")){
					System.out.print(o);
				}
			}
	}
	
	public static void userOptions(){
		ctr++;
		System.out.println();
		System.out.println("*******************************************************************************************************************");
		System.out.println("**** WASHINGTON CAPITALS:  2018-2019 Regular Season Stats ****");
		if(ctr == 1){
			System.out.println();
			createTable(4);	
		}
		System.out.println("\nSelect a sort by option:\n1.) Last Name \n2.) Position\n3.) Games Played \n4.) Wins / Points (Default)\n\n5.) Exit");
		System.out.println("\n*********************************************");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter selection: ");
			int userChoice = Integer.parseInt(reader.readLine());	
			System.out.println();
				switch(userChoice){
					case 1: System.out.println("You selected: Sort by LAST NAME\n");
						createTable(1);
						userOptions();
						break;
					case 2: System.out.println("You selected: Sort by POSITION\n");
						createTable(2);
						userOptions();
						break;
					case 3: System.out.println("You selected: Sort by GAMES PLAYED\n");
						createTable(3);
						userOptions();
						break;
					case 4: System.out.println("You selected: Sort by WINS / POINTS\n");
						createTable(4);
						userOptions();
						break;
					case 5: System.out.print("You selected: EXIT");
						System.exit(0);
						break;
					default: userOptions(); //reload menu bc invalid selection
						break;	
				}
		}
		catch(Exception e){
			System.out.println("Exception: " + e + " Try Again!");
			userOptions();
		}
	}
	
	public static void main(String... args){
		DataTableV2 dt = new DataTableV2();
		dt.userOptions();
	}
}