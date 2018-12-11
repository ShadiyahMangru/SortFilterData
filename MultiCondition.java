import java.util.*;

class HockeyPlayer{

	//fields
	private String lastName;
	private String position;
	
	//constructor
	public HockeyPlayer(String lastName, String position){
		this.lastName = lastName;
		this.position = position;	
	}
	
	//setters
	public void setLastName(String lastName){
		this.lastName = lastName;	
	}
	
	public void setPosition(String position){
		this.position = position;
	}
	
	//getters
	public String getLastName(){
		return lastName;	
	}
	
	public String getPosition(){
		return position;	
	}
	
	@Override
	public String toString(){
		return lastName + ", " + position;	
	}
	
	//method that helps subcategorize roster by position
	public int basicPositions(String position){
		if(position.equals("Goalie")){
			return -1;		
		}
		else if(position.equals("Defense")){
			return 0;		
		}
		else{
			return 1;	//Forward
		}
	}
}

class Goalie extends HockeyPlayer{
	//fields
	private int wins;
	
	//constructor
	public Goalie(String lastName, String position, int wins){
		super(lastName, position);	
		this.wins = wins;
	}
	
	//setter
	public void setWins(int wins){
		this.wins = wins;	
	}
	
	//getter
	public int getWins(){
		return wins;	
	}
	
	@Override
	public String toString(){
		return getLastName() + " | " + getPosition() + " | " + wins + " wins";	
	}
}

class Skater extends HockeyPlayer{
	//fields
	private int points;
	
	//constructor
	public Skater(String lastName, String position, int points){
		super(lastName, position);	
		this.points = points;
	}
	
	//setter
	public void setPoints(int points){
		this.points = points;	
	}
	
	//getter
	public int getPoints(){
		return points;	
	}
	
	@Override
	public String toString(){
		return getLastName() + " | " + getPosition() + " | " + points + " points";	
	}
}

class Forward extends Skater{
	
	//constructor
	public Forward(String lastName, String position, int points){
		super(lastName, position, points);	
	}
	
	//method that helps subcategorize forwards by sub-position
	public int subPositions(Forward f){
		if(f.getPosition().contains("LW")){
			return -1;		
		}
		else if(f.getPosition().contains(", C")){
			return 0;		
		}
		else{				
			return 1;		//RW
		}
	}
}

class Defense extends Skater{
	
	//constructor
	public Defense(String lastName, String position, int points){
		super(lastName, position, points);	
	}
}

class TeamRoster{
	//field
	private ArrayList<Object> roster2018;
	
	//constructor
	public TeamRoster(){
		setRoster2018();	
	}
	
	//setter
	public void setRoster2018(){
		Goalie holtby = new Goalie("Holtby", "Goalie", 11);
		Goalie copley = new Goalie("Copley", "Goalie", 6);
		Skater orlov = new Defense("Orlov", "Defense", 11);
		Skater djoos = new Defense("Djoos", "Defense", 3);
		Skater kuznetsov = new Forward("Kuznetsov", "Forward, C", 27);
		Skater backstrom = new Forward("Backstrom", "Forward, C", 34);
		Skater wilson = new Forward("Wilson", "Forward, RW", 14);
		Skater oshie = new Forward("Oshie", "Forward, RW", 14);
		Skater burakovsky = new Forward("Burakovsky", "Forward, LW", 8);
		Skater ovechkin = new Forward("Ovechkin", "Forward, LW", 36);
		Skater carlson = new Defense("Carlson", "Defense", 30);
		Skater bowey = new Defense("Bowey", "Defense", 5);
		Skater boyd = new Forward("Boyd", "Forward, C", 8);
		Skater connolly = new Forward("Connolly", "Forward, RW", 18);
		Skater dowd = new Forward("Dowd", "Forward, C", 8);
		Skater eller = new Forward("Eller", "Forward, C", 14);
		Skater jaskin = new Forward("Jaskin", "Forward, RW", 6);
		Skater smithPelly = new Forward("Smith-Pelly", "Forward, RW", 6);
		Skater stephenson = new Forward("Stephenson", "Forward, C", 6);
		Skater vrana = new Forward("Vrana", "Forward, LW", 18);
		Skater kempny = new Defense("Kempny", "Defense", 9);
		Skater niskanen = new Defense("Niskanen", "Defense", 14);
		Skater orpik = new Defense("Orpik", "Defense", 2);
		Skater siegenthaler = new Defense("Siegenthaler", "Defense", 0);
		
		
		Object [] roster = {holtby, copley, kuznetsov, backstrom, wilson, oshie, burakovsky, ovechkin, carlson, bowey, orlov, djoos, boyd, connolly, dowd, eller, jaskin, smithPelly, stephenson, vrana, kempny, niskanen, orpik, siegenthaler};
		
		roster2018 = new ArrayList<Object>(Arrays.asList(roster));
	}
	
	//getter
	public ArrayList<Object> getRoster2018(){
		return roster2018;	
	}
	
	
	//print method
	public void printRoster(ArrayList<Object> roster){
		for(Object o : roster){
			System.out.println(o);	
		}
	}
	
	//*****************************************************************************
	//filter methods
	public ArrayList<Goalie> goaliesRoster(ArrayList<Object> roster){
		ArrayList<Goalie> goalieRoster = new ArrayList<Goalie>();
		for(Object o : roster){
			if(o instanceof Goalie){
				goalieRoster.add((Goalie)o);	
			}
		}
		return goalieRoster;
	}
	
	public ArrayList<Skater> skaterRoster(ArrayList<Object> roster){
		ArrayList<Skater> skaterRoster = new ArrayList<Skater>();
		for(Object o : roster){
			if(o instanceof Skater){
				skaterRoster.add((Skater)o);	
			}
		}
		return skaterRoster;
	}
	
	public ArrayList<Defense> defenseRoster(ArrayList<Object> roster){
		ArrayList<Defense> defenseRoster = new ArrayList<Defense>();
		for(Object o : roster){
			if(o instanceof Defense){
				defenseRoster.add((Defense)o);	
			}
		}
		return defenseRoster;
	}
	
	public ArrayList<Forward> forwardRoster(ArrayList<Object> roster){
		ArrayList<Forward> forwardRoster = new ArrayList<Forward>();
		for(Object o : roster){
			if(o instanceof Forward){
				forwardRoster.add((Forward)o);	
			}
		}
		return forwardRoster;
	}
	
	public ArrayList<Forward> forwardSubTypeRoster(ArrayList<Object> roster, int type){
		ArrayList<Forward> fSubTypeRoster = new ArrayList<Forward>();
		for(Object o : roster){
			if(o instanceof Forward){
				Forward f = (Forward)o;
				if(f.subPositions(f) == type){
					fSubTypeRoster.add(f);
				}
			}
		}
		return fSubTypeRoster;
	}
	//*****************************************************************************
}

class HPCompare implements Comparator<Object>{
	
	private int sortByThis;
	
	public HPCompare(int sortByThis){
		this.sortByThis = sortByThis;	
	}
	
	@Override
	public int compare(Object o1, Object o2) { 
		if(sortByThis == 1){	
			HockeyPlayer h1 = (HockeyPlayer)o1;
			HockeyPlayer h2 = (HockeyPlayer)o2;
			if (h1.getLastName().compareTo(h2.getLastName()) > 0) 
				return 1; 
			if (h1.getLastName().compareTo(h2.getLastName()) == 0) 
				return 0; 
		}
		else if(sortByThis == 2){	
			HockeyPlayer h1 = (HockeyPlayer)o1;
			HockeyPlayer h2 = (HockeyPlayer)o2;
			if (h1.getPosition().compareTo(h2.getPosition()) > 0) 
				return 1; 
			if (h1.getPosition().compareTo(h2.getPosition()) == 0) 
				return 0; 
		}
		else if(sortByThis == 3){
			Skater s1 = (Skater)o1;
			Skater s2 = (Skater)o2;
			if(s1.getPoints() > s2.getPoints())
				return 1;
			if(s1.getPoints() == s2.getPoints())
				return 0;
		}
		return -1;	
	} 
	
}

class FCompare implements Comparator<Forward>{
	
	private int sortByThis;
	
	public FCompare(int sortByThis){
		this.sortByThis = sortByThis;	
	}
	
	@Override
	public int compare(Forward f1, Forward f2) { 
		if(sortByThis == 3){
			if(f1.getPoints() > f2.getPoints())
				return -1;
			if(f1.getPoints() == f2.getPoints())
				return 0;
		}
		return 1;	
	} 
	
}

class DCompare implements Comparator<Defense>{
	
	private int sortByThis;
	
	public DCompare(int sortByThis){
		this.sortByThis = sortByThis;	
	}
	
	@Override
	public int compare(Defense d1, Defense d2) { 
		if(sortByThis == 3){
			if(d1.getPoints() > d2.getPoints())
				return -1;
			if(d1.getPoints() == d2.getPoints())
				return 0;
		}
		return 1;	
	} 
	
}

class GCompare implements Comparator<Goalie>{
	
	private int sortByThis;
	
	public GCompare(int sortByThis){
		this.sortByThis = sortByThis;	
	}
	
	@Override
	public int compare(Goalie g1, Goalie g2) { 
		if(sortByThis == 3){
			if(g1.getWins() > g2.getWins())
				return -1;
			if(g1.getWins() == g2.getWins())
				return 0;
		}
		return 1;	
	} 
	
}

public class MultiCondition{
	public static void main(String... args){
		TeamRoster t = new TeamRoster();
		System.out.println("2018 - 2019 Regular Season Roster (ALL DATA AVAILABLE >>> SORT BY TRAIT Y/XC/XA/XB/Z )");
		HPCompare hpc = new HPCompare(2);
		Collections.sort(t.getRoster2018(), hpc);
		t.printRoster(t.getRoster2018());
		System.out.println();
		
		System.out.println("2018 - 2019 Regular Season Forwards (FILTER BY TRAIT X >>> SORT BY VALUE I)");
		FCompare fc = new FCompare(3);
		ArrayList<Forward> fPtsSorted = new ArrayList<Forward>();
		fPtsSorted = t.forwardRoster(t.getRoster2018());
		Collections.sort(fPtsSorted, fc);
		for(Forward forward : fPtsSorted)
			System.out.println(forward);
		System.out.println();
		
		System.out.println("2018 - 2019 Regular Season Left Wings (FILTER BY TRAIT X >>> FILTER BY TRAIT A >>> SORT BY VALUE I)");
		fPtsSorted = t.forwardSubTypeRoster(t.getRoster2018(), -1);
		Collections.sort(fPtsSorted, fc);
		for(Forward forward : fPtsSorted)
			System.out.println(forward);
		System.out.println();
		
		System.out.println("2018 - 2019 Regular Season Right Wings (FILTER BY TRAIT X >>> FILTER BY TRAIT B >>> SORT BY VALUE I)");
		fPtsSorted = t.forwardSubTypeRoster(t.getRoster2018(), 1);
		Collections.sort(fPtsSorted, fc);
		for(Forward forward : fPtsSorted)
			System.out.println(forward);
		System.out.println();
		
		System.out.println("2018 - 2019 Regular Season Centers (FILTER BY TRAIT X >>> FILTER BY TRAIT C >>> SORT BY VALUE I)");
		fPtsSorted = t.forwardSubTypeRoster(t.getRoster2018(), 0);
		Collections.sort(fPtsSorted, fc);
		for(Forward forward : fPtsSorted)
			System.out.println(forward);
		System.out.println();
		
		System.out.println("2018 - 2019 Regular Season Defense (FILTER BY TRAIT Y >>> SORT BY VALUE I)");
		DCompare dc = new DCompare(3);
		ArrayList<Defense> dPtsSorted = new ArrayList<Defense>();
		dPtsSorted = t.defenseRoster(t.getRoster2018());
		Collections.sort(dPtsSorted, dc);
		for(Defense defense : dPtsSorted)
			System.out.println(defense);
		System.out.println();
		
		System.out.println("2018 - 2019 Regular Season Goalies (FILTER BY TRAIT Z >>> SORT BY VALUE J)");
		GCompare gc = new GCompare(3);
		ArrayList<Goalie> gWinsSorted = new ArrayList<Goalie>();
		gWinsSorted = t.goaliesRoster(t.getRoster2018());
		Collections.sort(gWinsSorted, gc);
		for(Goalie goalie : gWinsSorted)
			System.out.println(goalie);
	}
}