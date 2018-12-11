import java.util.*;

abstract class HockeyPlayer{

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
	
	//constructor
	public Goalie(String lastName, String position){
		super(lastName, position);	
	}
	
}

class Skater extends HockeyPlayer{
	
	//constructor
	public Skater(String lastName, String position){
		super(lastName, position);	
	}
}

class Forward extends Skater{
	
	//constructor
	public Forward(String lastName, String position){
		super(lastName, position);	
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
	public Defense(String lastName, String position){
		super(lastName, position);	
	}
}

public class TeamRoster{
	//field
	private ArrayList<Object> roster2018;
	
	//constructor
	public TeamRoster(){
		setRoster2018();	
	}
	
	//setter
	public void setRoster2018(){
		Goalie holtby = new Goalie("Holtby", "Goalie");
		Goalie copley = new Goalie("Copley", "Goalie");
		Skater orlov = new Defense("Orlov", "Defense");
		Skater djoos = new Defense("Djoos", "Defense");
		Skater kuznetsov = new Forward("Kuznetsov", "Forward, C");
		Skater backstrom = new Forward("Backstrom", "Forward, C");
		Skater wilson = new Forward("Wilson", "Forward, RW");
		Skater oshie = new Forward("Oshie", "Forward, RW");
		Skater burakovsky = new Forward("Burakovsky", "Forward, LW");
		Skater ovechkin = new Forward("Ovechkin", "Forward, LW");
		Skater carlson = new Defense("Carlson", "Defense");
		Skater bowey = new Defense("Bowey", "Defense");
		Skater boyd = new Forward("Boyd", "Forward, C");
		Skater connolly = new Forward("Connolly", "Forward, RW");
		Skater dowd = new Forward("Dowd", "Forward, C");
		Skater eller = new Forward("Eller", "Forward, C");
		Skater jaskin = new Forward("Jaskin", "Forward, RW");
		Skater smithPelly = new Forward("Smith-Pelly", "Forward, RW");
		Skater stephenson = new Forward("Stephenson", "Forward, C");
		Skater vrana = new Forward("Vrana", "Forward, LW");
		Skater kempny = new Defense("Kempny", "Defense");
		Skater niskanen = new Defense("Niskanen", "Defense");
		Skater orpik = new Defense("Orpik", "Defense");
		Skater siegenthaler = new Defense("Siegenthaler", "Defense");
		
		
		Object [] roster = {holtby, copley, kuznetsov, backstrom, wilson, oshie, burakovsky, ovechkin, carlson, bowey, orlov, djoos, boyd, connolly, dowd, eller, jaskin, smithPelly, stephenson, vrana, kempny, niskanen, orpik, siegenthaler};
		
		roster2018 = new ArrayList<Object>(Arrays.asList(roster));
	}
	
	//getter
	public ArrayList<Object> getRoster2018(){
		return roster2018;	
	}
	
	//*****************************************************************************
	//print methods
	public void printPlayers(ArrayList<Object> roster){
		printForwardSubType(roster, -1);
		printForwardSubType(roster, 0);
		printForwardSubType(roster, 1);
		printDefense(roster);
		printGoalies(roster);
	}
	
	public void printGoalies(ArrayList<Object> roster){
		for(Object o : roster){
			if(o instanceof Goalie){
				System.out.println((Goalie)o);	
			}
		}
	}
	
	public void printSkaters(ArrayList<Object> roster){
		for(Object o : roster){
			if(o instanceof Skater){
				System.out.println((Skater)o);	
			}
		}
	}
	
	public void printDefense(ArrayList<Object> roster){
		for(Object o : roster){
			if(o instanceof Defense){
				System.out.println((Defense)o);	
			}
		}
	}
	
	public void printForward(ArrayList<Object> roster){
		for(Object o : roster){
			if(o instanceof Forward){
				System.out.println((Forward)o);	
			}
		}
	}
	
	public void printForwardSubType(ArrayList<Object> roster, int type){
		for(Object o : roster){
			if(o instanceof Forward){
				Forward f = (Forward)o;
				if(f.subPositions(f) == type){
					System.out.println(f);
				}
			}
		}
	}
	//*****************************************************************************
	
	public static void main(String... args){
		TeamRoster t = new TeamRoster();
		System.out.println("2018 - 2019 Regular Season Roster (ALL DATA AVAILABLE)");
		t.printPlayers(t.getRoster2018());
		System.out.println();
		System.out.println("2018 - 2019 Regular Season Forwards (DATA SUBSORTED BY TRAIT X)");
		t.printForward(t.getRoster2018());
		System.out.println();
		System.out.println("2018 - 2019 Regular Season Left Wings (DATA SUBSORTED BY TRAIT X THEN BY TRAIT A)");
		t.printForwardSubType(t.getRoster2018(), -1);
		System.out.println();
		System.out.println("2018 - 2019 Regular Season Right Wings (DATA SUBSORTED BY TRAIT X THEN BY TRAIT B)");
		t.printForwardSubType(t.getRoster2018(), 1);
		System.out.println();
		System.out.println("2018 - 2019 Regular Season Centers (DATA SUBSORTED BY TRAIT X THEN BY TRAIT C)");
		t.printForwardSubType(t.getRoster2018(), 0);
		System.out.println();
		System.out.println("2018 - 2019 Regular Season Defense (DATA SUBSORTED BY TRAIT Y)");
		t.printDefense(t.getRoster2018());
		System.out.println();
		System.out.println("2018 - 2019 Regular Season Goalies (DATA SUBSORTED BY TRAIT Z)");
		t.printGoalies(t.getRoster2018());
		System.out.println();
	}
	
}