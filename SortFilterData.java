import java.text.*;
import java.util.*;
class HockeyPlayer implements Comparable<HockeyPlayer>{
	//fields
	private String lastName;
	private String position;
	private String birthplace;
	private String season;
	private int gamesPlayed;
	
	//constructors
	public HockeyPlayer(String lastName, String position, String birthplace){
		this.lastName = lastName;
		this.position = position;
		this.birthplace = birthplace;
		this.season = "Default season";
	}
	
	public HockeyPlayer(HockeyPlayer hp){
		this.lastName = hp.lastName;
		this.position = hp.position;
		this.birthplace = hp.birthplace;
		this.season = "Default season";
	}
	
	public HockeyPlayer(HockeyPlayer hp, String season, int gamesPlayed){
		this(hp);
		this.season = season;
		this.gamesPlayed = gamesPlayed;
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
	
	public void setSeason(String season){
		this.season = season;	
	}
	
	public void setGamesPlayed(int gamesPlayed){
		this.gamesPlayed = gamesPlayed;	
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
	
	public String getSeason(){
		return season;	
	}
	
	public int getGamesPlayed(){
		return gamesPlayed;	
	}
	
	@Override
    	public int compareTo(HockeyPlayer other) {
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
	
	@Override
	public String toString(){
		return lastName + " | " + position + " | " + birthplace; 	
	}
	
	public String printInfo(){
		return lastName + " | " + position + " | " + birthplace; 	
	}
}

class Skater extends HockeyPlayer{
	//fields
	private int goals;
	private int assists;
	private int points;
	private int plusMinus;
	private int shots;
	private double shootingPercentage;
	private double avgPtsGP;
	
	//constructor
	public Skater(HockeyPlayer hp, String season, int gamesPlayed, int goals, int assists, int plusMinus, int shots){
		super(hp, season, gamesPlayed);
		this.goals = goals;
		this.assists = assists;
		this.plusMinus = plusMinus;
		this.shots = shots;
		setPoints();
		this.points = getPoints();
		setShootingPercentage();
		this.shootingPercentage = getShootingPercentage();
		setAvgPtsGP();
		this.avgPtsGP = getAvgPtsGP();
	}
	
	//setters	
	public void setGoals(int goals){
		this.goals = goals;	
	}
	
	public void setAssists(int assists){
		this.assists = assists;	
	}
	
	public void setPoints(){
		points = goals + assists;	
	}
	
	public void setPlusMinus(int plusMinus){
		this.plusMinus = plusMinus;	
	}
	
	public void setShots(int shots){
		this.shots = shots;	
	}
	
	public void setShootingPercentage(){
		try{
			if(shots > 0){
				shootingPercentage = ((double)goals/(double)shots)*100;	
			}
			else{
				shootingPercentage = 0;	
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
				avgPtsGP = (double)points/(double)getGamesPlayed();	
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
	public int getGoals(){
		return goals;	
	}
	
	public int getAssists(){
		return assists;	
	}
	
	public int getPoints(){
		return points;	
	}
	
	public int getPlusMinus(){
		return plusMinus;	
	}
	
	public int getShots(){
		return shots;	
	}
	
	public double getShootingPercentage(){
		return shootingPercentage;	
	}
	
	public double getAvgPtsGP(){
		return avgPtsGP;	
	}
	
	@Override
	public String toString(){
		DecimalFormat df = new DecimalFormat("0.0000");
		return "Season: " + getSeason() + " | Games Played: " + getGamesPlayed() 
		+ " | Goals: " + goals + " | Assists: " + assists + " | Points: " + points + " | +/-: " + plusMinus 
		+ " | Shots: " + shots + " | Shooting %: " + df.format(shootingPercentage) + " | Avg Points/GP: " + df.format(avgPtsGP); 	
	}
	
}

class Goalie extends HockeyPlayer{
	//fields
	private int wins;
	private int shotsAgainst;
	private int goalsAgainst;
	private int saves;
	private double savePercentage;
	private double avgWinsGP;
	
	//constructor
	public Goalie(HockeyPlayer hp, String season, int gamesPlayed, int wins, int goalsAgainst, int saves){
		super(hp, season, gamesPlayed);
		this.wins = wins;
		this.goalsAgainst = goalsAgainst;
		this.saves = saves;
		setShotsAgainst();
		this.shotsAgainst = getShotsAgainst();
		setSavePercentage();
		this.savePercentage = getSavePercentage();
		setAvgWinsGP();
		this.avgWinsGP = getAvgWinsGP();
	}
	
	//setters
	public void setWins(int wins){
		this.wins = wins;	
	}
	
	public void setShotsAgainst(){
		shotsAgainst = goalsAgainst + saves;
	}
	
	public void setGoalsAgainst(int goalsAgainst){
		this.goalsAgainst = goalsAgainst;	
	}
	
	public void setSaves(int saves){
		this.saves = saves;	
	}
	
	public void setSavePercentage(){
		try{
			if(shotsAgainst > 0){
				savePercentage = ((double)saves/(double)shotsAgainst)*100;	
			}
			else{
				savePercentage = 0;	
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
				avgWinsGP = (double)wins/(double)getGamesPlayed();	
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
	public int getWins(){
		return wins;	
	}
	
	public int getShotsAgainst(){
		return shotsAgainst;	
	}
	
	public int getGoalsAgainst(){
		return goalsAgainst;	
	}
	
	public int getSaves(){
		return saves;	
	}
	
	public double getSavePercentage(){
		return savePercentage;	
	}
	
	public double getAvgWinsGP(){
		return avgWinsGP;	
	}
	
	@Override
	public String toString(){
		DecimalFormat df = new DecimalFormat("0.0000");
		return "Season: " + getSeason() + " | Games Played: " + getGamesPlayed() 
		+ " | Wins: " + wins + " | Shots Against: " + shotsAgainst + " | Goals Against: " + goalsAgainst 
		+ " | Saves: " + saves + " | Save %: " + df.format(savePercentage) + " | Avg Wins/GP: " + df.format(avgWinsGP); 	
	}
}

public class SortFilterData{	
	
	String [] seasons = {"2013 - 2014", "2014 - 2015", "2015 - 2016", "2016 - 2017", "2017 - 2018", "2018 - 2019"};
	String [] positions = {"Goalie", "Defense", "Forward, LW", "Forward, C", "Forward, RW"};
	
	//games played, goals, assists, +/-, shots
	HockeyPlayer ovechkin = new HockeyPlayer("Ovechkin", positions[2], "Russia");
	Skater ovechkin2018 = new Skater(ovechkin, seasons[5], 26, 19, 13, 7, 100);
	Skater ovechkin2017 = new Skater(ovechkin, seasons[4], 82, 49, 38, 3, 355);
	Skater ovechkin2016 = new Skater(ovechkin, seasons[3], 82, 33, 36, 6, 313);
	Skater ovechkin2015 = new Skater(ovechkin, seasons[2], 79, 50, 21, 21, 398);
	Skater ovechkin2014 = new Skater(ovechkin, seasons[1], 81, 53, 28, 10, 395);
	Skater ovechkin2013 = new Skater(ovechkin, seasons[0], 78, 51, 28, -35, 386);
	
	Skater[] ovArray = {ovechkin2018, ovechkin2017, ovechkin2016, ovechkin2015, ovechkin2014, ovechkin2013};

	
	HockeyPlayer backstrom = new HockeyPlayer("Backstrom", positions[3], "Sweden");
	Skater backstrom2018 = new Skater(backstrom, seasons[5], 26, 10, 23, 11, 60);
	Skater backstrom2017 = new Skater(backstrom, seasons[4], 81, 21, 50, 5, 165);
	Skater backstrom2016 = new Skater(backstrom, seasons[3], 82, 23, 63, 17, 162);
	Skater backstrom2015 = new Skater(backstrom, seasons[2], 75, 20, 50, 17, 129);
	Skater backstrom2014 = new Skater(backstrom, seasons[1], 82, 18, 60, 5, 153);
	Skater backstrom2013 = new Skater(backstrom, seasons[0], 82, 18, 61, -20, 196);
	
	Skater[] backstromArray = {backstrom2018, backstrom2017, backstrom2016, backstrom2015, backstrom2014, backstrom2013};

	
	//gp, wins, goalsAg, saves
	HockeyPlayer holtby = new HockeyPlayer("Holtby", positions[0], "Canada");
	Goalie holtby2018 = new Goalie(holtby, seasons[5], 19, 10, 53, 536);
	Goalie holtby2017 = new Goalie(holtby, seasons[4], 54, 34, 153, 1495);
	Goalie holtby2016 = new Goalie(holtby, seasons[3], 63, 42, 127, 1563);
	Goalie holtby2015 = new Goalie(holtby, seasons[2], 66, 48, 141, 1661);
	Goalie holtby2014 = new Goalie(holtby, seasons[1], 73, 41, 157, 1887);
	Goalie holtby2013 = new Goalie(holtby, seasons[0], 48, 23, 126, 1349);
	
	Goalie[] holtbyArray = {holtby2018, holtby2017, holtby2016, holtby2015, holtby2014, holtby2013};

	
	HockeyPlayer carlson = new HockeyPlayer("Carlson", positions[1], "USA");
	Skater carlson2018 = new Skater(carlson, seasons[5], 25, 5, 24, 15, 59);
	Skater carlson2017 = new Skater(carlson, seasons[4], 82, 15, 53, 0, 237);
	Skater carlson2016 = new Skater(carlson, seasons[3], 72, 9, 28, 7, 180);
	Skater carlson2015 = new Skater(carlson, seasons[2], 56, 8, 31, 16, 124);
	Skater carlson2014 = new Skater(carlson, seasons[1], 82, 12, 43, 11, 193);
	Skater carlson2013 = new Skater(carlson, seasons[0], 82, 10, 27, -3, 208);
	
	Skater[] carlsonArray = {carlson2018, carlson2017, carlson2016, carlson2015, carlson2014, carlson2013};

	
	HockeyPlayer kuznetsov = new HockeyPlayer("Kuznetsov", positions[3], "Russia");
	Skater kuznetsov2018 = new Skater(kuznetsov, seasons[5], 20, 7, 17, -4, 54);
	Skater kuznetsov2017 = new Skater(kuznetsov, seasons[4], 79, 27, 56, 3, 187);
	Skater kuznetsov2016 = new Skater(kuznetsov, seasons[3], 82, 19, 40, 18, 170);
	Skater kuznetsov2015 = new Skater(kuznetsov, seasons[2], 82, 20, 57, 27, 193);
	Skater kuznetsov2014 = new Skater(kuznetsov, seasons[1], 80, 11, 26, 10, 127);
	Skater kuznetsov2013 = new Skater(kuznetsov, seasons[0], 17, 3, 6, -2, 22);
	
	Skater[] kuzyArray = {kuznetsov2018, kuznetsov2017, kuznetsov2016, kuznetsov2015, kuznetsov2014, kuznetsov2013};

	
	HockeyPlayer orlov = new HockeyPlayer("Orlov", positions[1], "Russia");
	Skater orlov2018 = new Skater(orlov, seasons[5], 26, 2, 7, -10, 36);
	Skater orlov2017 = new Skater(orlov, seasons[4], 82, 10, 21, 10, 125);
	Skater orlov2016 = new Skater(orlov, seasons[3], 82, 6, 27, 30, 125);
	Skater orlov2015 = new Skater(orlov, seasons[2], 82, 8, 21, 8, 90);
	Skater orlov2014 = new Skater(orlov, seasons[1], 54, 3, 8, -1, 59);
	Skater orlov2013 = new Skater(orlov, seasons[0], 5, 0, 1, 5, 1);
	
	Skater[] orlovArray = {orlov2018, orlov2017, orlov2016, orlov2015, orlov2014, orlov2013};

	
	HockeyPlayer burakovsky = new HockeyPlayer("Burakovsky", positions[2], "Austria");
	Skater burakovsky2018 = new Skater(burakovsky, seasons[5], 26, 4, 3, -6, 32);
	Skater burakovsky2017 = new Skater(burakovsky, seasons[4], 56, 12, 13, 3, 84);
	Skater burakovsky2016 = new Skater(burakovsky, seasons[3], 64, 12, 23, 13, 111);
	Skater burakovsky2015 = new Skater(burakovsky, seasons[2], 79, 17, 21, 4, 126);
	Skater burakovsky2014 = new Skater(burakovsky, seasons[1], 53, 9, 13, 12, 65);
	
	Skater[] burakovskyArray = {burakovsky2018, burakovsky2017, burakovsky2016, burakovsky2015, burakovsky2014};

	
	HockeyPlayer grubauer = new HockeyPlayer("Grubauer", positions[0], "Germany");
	Goalie grubauer2017 = new Goalie(grubauer, seasons[4], 35, 15, 73, 880);
	Goalie grubauer2016 = new Goalie(grubauer, seasons[3], 24, 13, 43, 542);
	Goalie grubauer2015 = new Goalie(grubauer, seasons[2], 22, 8, 43, 480);
	Goalie grubauer2014 = new Goalie(grubauer, seasons[1], 1, 1, 2, 23);
	Goalie grubauer2013 = new Goalie(grubauer, seasons[0], 17, 6, 35, 434);
	
	Goalie[] grubauerArray = {grubauer2017, grubauer2016, grubauer2015, grubauer2014, grubauer2013};

	
	HockeyPlayer oshie = new HockeyPlayer("Oshie", positions[4], "USA");
	Skater oshie2018 = new Skater(oshie, seasons[5], 18, 9, 5, 6, 40);
	Skater oshie2017 = new Skater(oshie, seasons[4], 74, 18, 29, 2, 127);
	Skater oshie2016 = new Skater(oshie, seasons[3], 68, 33, 23, 28, 143);
	Skater oshie2015 = new Skater(oshie, seasons[2], 80, 26, 25, 16, 185);
	
	Skater[] oshieArray = {oshie2018, oshie2017, oshie2016, oshie2015};
	
	
	Object [][] rosterInfoArray = {ovArray, backstromArray, holtbyArray, carlsonArray,kuzyArray, orlovArray, burakovskyArray, grubauerArray, oshieArray};
						
	public void printRoster(Object[][] rosterData){
		int ctr = 0;
		for(Object[] player1DArray : rosterData){
			ctr = 0;
			for(Object info : player1DArray){
				if(ctr < 1){
					HockeyPlayer h = (HockeyPlayer)info;
					System.out.println(h.printInfo());
					System.out.println(info.toString());
				}
				else{
					System.out.println(info.toString());
				}
				ctr++;
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void printSeasonRoster(Object[][] rosterData, String season){
		System.out.println("**** " + season + " Roster ****");
		for(Object[] player1DArray : rosterData){
			for(Object info : player1DArray){
				HockeyPlayer h = (HockeyPlayer)info;
				if(h.getSeason().equals(season)){
					System.out.println(h.printInfo());	
				}
			}
		}
	}
	
	public void printSeasonGP(Object[][] rosterData, String season){
		ArrayList<HockeyPlayer> hGamesPlayed = new ArrayList<HockeyPlayer>();
		System.out.println("**** " + season + " Roster sorted by Games Played ****");
		for(Object[] player1DArray : rosterData){
			for(Object info : player1DArray){
				HockeyPlayer h = (HockeyPlayer)info;
				if(h.getSeason().equals(season)){
					hGamesPlayed.add(h);
				}
			}
		}
		Collections.sort(hGamesPlayed);
		for(HockeyPlayer hpl : hGamesPlayed){
			System.out.println(hpl.getLastName() + ": " + hpl.getGamesPlayed());	
		}
	}
	
	public void printPosition(Object[][] rosterData, String season, String position){
		System.out.println("**** " + position + " during " + season + " ****");
		for(Object[] player1DArray : rosterData){
			for(Object info : player1DArray){
				HockeyPlayer h = (HockeyPlayer)info;
				if(h.getSeason().equals(season) & h.getPosition().equals(position)){
					System.out.println(h.printInfo());	
				}
			}
		}
	}

	public static void main(String... args){
		SortFilterData ds = new SortFilterData();
		System.out.println("******************** Print and Format all Available Data ********************");		
		ds.printRoster(ds.rosterInfoArray);
		
		System.out.println("******************** Print Roster of Season Y ********************");	
		ds.printSeasonRoster(ds.rosterInfoArray, ds.seasons[5]);
		System.out.println();
		ds.printSeasonRoster(ds.rosterInfoArray, ds.seasons[4]);
		System.out.println();
		ds.printSeasonRoster(ds.rosterInfoArray, ds.seasons[0]);
		System.out.println();
		
		System.out.println("******************** Print Position X Players for Season Y ********************");
		ds.printPosition(ds.rosterInfoArray, ds.seasons[4], ds.positions[3]);
		System.out.println();
		ds.printPosition(ds.rosterInfoArray, ds.seasons[4], ds.positions[1]);
		System.out.println();
		ds.printPosition(ds.rosterInfoArray, ds.seasons[4], ds.positions[0]);
		System.out.println();
		ds.printPosition(ds.rosterInfoArray, ds.seasons[5], ds.positions[0]);
		System.out.println();
		ds.printPosition(ds.rosterInfoArray, ds.seasons[0], ds.positions[2]);
		System.out.println();
		ds.printPosition(ds.rosterInfoArray, ds.seasons[1], ds.positions[2]);
		System.out.println();
		
		System.out.println("******************** Sort Season Y Numerically by Games Played ********************");
		ds.printSeasonGP(ds.rosterInfoArray, ds.seasons[5]);
		System.out.println();
		ds.printSeasonGP(ds.rosterInfoArray, ds.seasons[0]);
	}
}