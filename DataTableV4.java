import java.time.*;
import java.util.*;
import java.io.*;

class HockeyPlayer{
	//fields
	private String lastName;
	private String position;
	private String birthplace;
	
	//constructors
	public HockeyPlayer(String lastName, String position, String birthplace){
		this.lastName = lastName;
		this.position = position;	
		this.birthplace = birthplace;
	}
	
	public HockeyPlayer(HockeyPlayer hp){
		this(hp.lastName, hp.position, hp.birthplace);
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
	
	@Override
	public String toString(){
		return lastName + " is a " + position + ".";
	}
}

class Goalie extends HockeyPlayer{
	//fields
	private int gamesPlayed;
	private int wins;
	private int shotsAgainst;
	private int saves;
	private double saveP;
	private double avgWinsGP;
	private LocalDate date;
	
	//constructor
	public Goalie(HockeyPlayer hp, int gamesPlayed, int wins, int shotsAgainst, int saves){
		super(hp);
		this.gamesPlayed = gamesPlayed;
		this.wins = wins;
		this.shotsAgainst = shotsAgainst;
		this.saves = saves;
		setSaveP();
		this.saveP = getSaveP();
		setAvgWinsGP();
		this.avgWinsGP = getAvgWinsGP();
		this.date = LocalDate.now();
	}
	
	//setters
	public void setGamesPlayed(int gamesPlayed){
		this.gamesPlayed = gamesPlayed;	
	}
	
	public void setWins(int wins){
		this.wins = wins;	
	}
	
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
				avgWinsGP = (double)getWins()/(double)getGamesPlayed();	
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
	public int getGamesPlayed(){
		return gamesPlayed;	
	}
	
	public int getWins(){
		return wins;	
	}
	
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
	
	public LocalDate getDate(){
		return date;	
	}
	
	@Override
	public String toString(){
		return String.format("%-15s | %-15s | %-14d | %-10d | %-14f | %-16f | %-14tF %n", getLastName(), getPosition(), gamesPlayed, wins, saveP, avgWinsGP, date);	
	}
}

class Skater extends HockeyPlayer{
	//fields
	private int gamesPlayed;
	private int points;
	private int shots;
	private int goals;
	private double shotP;
	private double avgPtsGP;
	private LocalDate date;
	
	//constructor
	public Skater(HockeyPlayer hp, int gamesPlayed, int points, int shots, int goals){
		super(hp);
		this.gamesPlayed = gamesPlayed;
		this.points = points;
		this.shots = shots;
		this.goals = goals;
		setShotP();
		this.shotP = getShotP();
		setAvgPtsGP();
		this.avgPtsGP = getAvgPtsGP();
		this.date = LocalDate.now();
	}
	
	//setters
	public void setGamesPlayed(int gamesPlayed){
		this.gamesPlayed = gamesPlayed;	
	}
	
	public void setPoints(int points){
		this.points = points;	
	}
	
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
				avgPtsGP = (double)getPoints()/(double)getGamesPlayed();	
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
	public int getGamesPlayed(){
		return gamesPlayed;	
	}
	
	public int getPoints(){
		return points;	
	}
	
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
	
	public LocalDate getDate(){
		return date;	
	}
	
	@Override 
	public String toString(){
		return String.format("%-15s | %-15s | %-14d | %-10d | %-14f | %-16f | %-14tF %n", getLastName(), getPosition(), gamesPlayed, points, shotP, avgPtsGP, date);	
	}
}

class HPCompare implements Comparator<HockeyPlayer>{
	
	private int sortByThis;
	
	public HPCompare(int sortByThis){
		this.sortByThis = sortByThis;	
	}
	
	@Override
	public int compare(HockeyPlayer h1, HockeyPlayer h2) { 
		if(sortByThis == 1){	
			if (h1.getLastName().compareTo(h2.getLastName()) > 0) 
				return 1; 
			if (h1.getLastName().compareTo(h2.getLastName()) == 0) 
				return 0; 
		}
		else if(sortByThis == 2){	
			if (h1.getPosition().compareTo(h2.getPosition()) > 0) 
				return 1; 
			if (h1.getPosition().compareTo(h2.getPosition()) == 0) 
				return 0; 
		}
		return -1;	
	} 
	
}

class SkaterCompare implements Comparator<Skater>{
	
	private int sortByThis;
	
	public SkaterCompare(int sortByThis){
		this.sortByThis = sortByThis;	
	}
	
	@Override
	public int compare(Skater s1, Skater s2) { 
		if(sortByThis == 3){	
			if (s1.getGamesPlayed() < s2.getGamesPlayed()) 
				return 1; 
			if (s1.getGamesPlayed() == s2.getGamesPlayed()) 
				return 0; 
		}
		else if(sortByThis == 4){	
			if (s1.getPoints() < s2.getPoints()) 
				return 1; 
			if (s1.getPoints() == s2.getPoints()) 
				return 0; 
		}
		else if(sortByThis == 5){	
			if (s1.getShotP() < s2.getShotP()) 
				return 1; 
			if (s1.getShotP() == s2.getShotP()) 
				return 0; 
		}
		else if(sortByThis == 6){
			if (s1.getAvgPtsGP() < s2.getAvgPtsGP()) 
				return 1; 
			if (s1.getAvgPtsGP() == s2.getAvgPtsGP()) 
				return 0; 	
		}
			return -1;	
		} 	
}

class GoalieCompare implements Comparator<Goalie>{
	
	private int sortByThis;
	
	public GoalieCompare(int sortByThis){
		this.sortByThis = sortByThis;	
	}
	
	@Override
	public int compare(Goalie g1, Goalie g2) { 
		if(sortByThis == 3){	
			if (g1.getGamesPlayed() < g2.getGamesPlayed()) 
				return 1; 
			if (g1.getGamesPlayed() == g2.getGamesPlayed()) 
				return 0; 
		}
		if(sortByThis == 4){		
			if (g1.getWins() < g2.getWins()) 
				return 1; 
			if (g1.getWins() == g2.getWins()) 
				return 0; 
		}
		else if(sortByThis == 7){		
			if (g1.getSaveP() < g2.getSaveP()) 
				return 1; 
			if (g1.getSaveP() == g2.getSaveP()) 
				return 0; 
		}
		else if(sortByThis == 8){
			if (g1.getAvgWinsGP() < g2.getAvgWinsGP()) 
				return 1; 
			if (g1.getAvgWinsGP() == g2.getAvgWinsGP()) 
				return 0; 	
		}
        	return -1;	
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
		
		HockeyPlayer dor = new HockeyPlayer("Orlov", "Defense", "Russia");
		Skater dor2018 = new Skater(dor, 27, 9, 37, 2);
		
		HockeyPlayer jv = new HockeyPlayer("Vrana", "Left Wing", "Czech Republic");
		Skater jv2018 = new Skater(jv, 27, 16, 47, 8);
			
		HockeyPlayer[] rosterArray2018 = {ek2018, ab2018, tw2018, bh2018, jc2018, ao2018, pc2018, mb2018, nb2018, to2018, test2018, dor2018, jv2018};
		roster2018 = new ArrayList<HockeyPlayer>(Arrays.asList(rosterArray2018));	
	}
	
	//getter
	public ArrayList<HockeyPlayer> getRoster2018(){
		return roster2018;	
	}
}

public class DataTableV4{
	
	private static int ctr;
	
	public static void createTable(int sortNum){
		System.out.println(String.format("%-15s | %-15s | %-5s | %-10s | %-14s | %-16s | %-14s", "NAME: ", "POSITION: ", "GAMES PLAYED: ",  "PTS: ", "SHOT %:  ", "AVG PTS/GP:", "LAST UPDATED: "));
		System.out.println("*******************************************************************************************************************");
		Roster r = new Roster();
		HPCompare hpc = new HPCompare(sortNum);
		Collections.sort(r.getRoster2018(), hpc);
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
		System.out.println("*******************************************************************************************************************");
	}
	
	public static void createTableS(int sortNum){
		ArrayList<Skater> skaterRoster2018 = new ArrayList<Skater>();
		System.out.println(String.format("%-15s | %-15s | %-5s | %-10s | %-14s | %-16s | %-14s", "NAME: ", "POSITION: ", "GAMES PLAYED: ",  "PTS: ", "SHOT %:  ", "AVG PTS/GP:", "LAST UPDATED: "));
		System.out.println("*******************************************************************************************************************");
		Roster r = new Roster();
		for(HockeyPlayer h : r.getRoster2018()){
			if(h instanceof Skater)	
			skaterRoster2018.add((Skater)h);
		}
		SkaterCompare sc = new SkaterCompare(sortNum);
		Collections.sort(skaterRoster2018, sc);
		for(HockeyPlayer o : skaterRoster2018){
			if(o.getPosition() != "Goalie"){
				System.out.print(o);
			}
		}
		System.out.println("*******************************************************************************************************************");
	}
	
	public static void createTableG(int sortNum){
		ArrayList<Goalie> goalieRoster2018 = new ArrayList<Goalie>();
		Roster r = new Roster();
		for(HockeyPlayer h : r.getRoster2018()){
			if(h instanceof Goalie)	
			goalieRoster2018.add((Goalie)h);
		}
		GoalieCompare gc = new GoalieCompare(sortNum);
		Collections.sort(goalieRoster2018, gc);
		System.out.println(String.format("%-15s | %-15s | %-5s | %-10s | %-14s | %-16s | %-14s", "NAME: ", "POSITION: ", "GAMES PLAYED: ",  "WINS: ", "SAVE %:  ", "AVG WINS/GP:", "LAST UPDATED: "));
		System.out.println("*******************************************************************************************************************");
		for(HockeyPlayer o : goalieRoster2018){
			if(o.getPosition().equals("Goalie")){
				System.out.print(o);
			}
		}
		System.out.println("*******************************************************************************************************************");
	}
	
	public static void userOptions(){
		ctr++;
		System.out.println();
		System.out.println("*******************************************************************************************************************");
		System.out.println("\t*********************** WASHINGTON CAPITALS:  2018-2019 Regular Season Stats ***********************");
		if(ctr == 1){
			System.out.println();
			createTableS(4);
			System.out.println();
			createTableG(4);
		}
		System.out.println("\n******************************\nSelect a sort by option:\n1.) Last Name \n2.) Position\n3.) Games Played \n4.) Wins / Points (Default) \n5.) Shooting % \n6.) Avg Pts/GP \n7.) Save % \n8.) Avg Wins/GP \n\n9.) Exit \n******************************");
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
						createTableS(3);
						System.out.println();
						createTableG(3);
						userOptions();
						break;
					case 4: System.out.println("You selected: Sort by WINS / POINTS\n");
						createTableS(4);
						System.out.println();
						createTableG(4);
						userOptions();
						break;
					case 5: System.out.println("You selected: Sort by SHOOTING %\n");
						createTableS(5);
						userOptions();
						break;
					case 6: System.out.println("You selected: Sort by AVG PTS/GP\n");
						createTableS(6);
						userOptions();
						break;
					case 7: System.out.println("You selected: Sort by SAVE %\n");
						createTableG(7);
						userOptions();
						break;
					case 8: System.out.println("You selected: Sort by AVG WINS/GP\n");
						createTableG(8);
						userOptions();
						break;
					case 9: System.out.print("You selected: EXIT");
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
		DataTableV4 dt = new DataTableV4();
		dt.userOptions();
	}
}