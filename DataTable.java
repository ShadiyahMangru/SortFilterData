import java.time.*;

class HockeyPlayer{
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

	HockeyPlayer ek  = new HockeyPlayer("Kuznetsov", "Center", "Russia");
	//hp, gp, pts, shots, goals
	Skater ek2018 = new Skater(ek, 20, 24, 54, 7);
	
	HockeyPlayer ab = new HockeyPlayer("Burakovsky", "Left Wing", "Austria");
	Skater ab2018 = new Skater(ab, 26, 7, 32, 4);
		
	HockeyPlayer tw = new HockeyPlayer("Wilson", "Right Wing", "Canada");
	Skater tw2018 = new Skater(tw, 10, 14, 26, 8);
	
	HockeyPlayer bh = new HockeyPlayer("Holtby", "Goalie", "Canada");
	//hp, gp, wins, shotsAg, saves
	Goalie bh2018 = new Goalie(bh, 19, 10, 589, 536);
		
	HockeyPlayer jc = new HockeyPlayer("Carlson", "Defense", "USA");
	Skater jc2018 = new Skater(jc, 25, 29, 59, 5);
		
	HockeyPlayer ao = new HockeyPlayer("Ovechkin", "Left Wing", "Russia");
	Skater ao2018 = new Skater(ao, 26, 32, 100, 19);
		
	HockeyPlayer pc = new HockeyPlayer("Copley", "Goalie", "USA");
	Goalie pc2018 = new Goalie(pc, 9, 5, 247, 222);
		
	HockeyPlayer mb = new HockeyPlayer("Bowey", "Defense", "Canada");
	Skater mb2018 = new Skater(mb, 18, 4, 15, 0);
		
	HockeyPlayer nb = new HockeyPlayer("Backstrom", "Center", "Sweden");
	Skater nb2018 = new Skater(nb, 26, 33, 60, 10);
		
	HockeyPlayer to = new HockeyPlayer("Oshie", "Right Wing", "USA");
	Skater to2018 = new Skater(to, 18, 14, 40, 9);
		
	Object[] roster2018 = {ek2018, ab2018, tw2018, bh2018, jc2018, ao2018, pc2018, mb2018, nb2018, to2018};
			
}

public class DataTable{
	
	public static void main(String... args){
	Roster r = new Roster();
	System.out.println("\n**** WASHINGTON CAPITALS:  2018-2019 Regular Season Stats ****\n");	
	
	System.out.println(String.format("%-15s | %-15s | %-5s | %-5s | %-10s | %-10s | %-14s", "NAME: ", "POSITION: ", "GAMES PLAYED: ",  "PTS/WINS: ", "SHOT/SAVE %:  ", "AVG PTS/WINS GP:", "LAST UPDATED: "));
	System.out.println("*******************************************************************************************************************");
		for(Object o : r.roster2018){
			System.out.print(o);
		}
	}
}