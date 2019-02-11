
public class DiningParty implements Comparable<DiningParty>{
	private String name = null;
    private int arrival_time = 0;
    private int dining_time = 0;
    private int party_size = 0;
    private int priority = 0;
 

    public DiningParty(String _name, int _arrival_time,
                       int _dining_time, int _party_size,
                       int _priority) {
      name=_name;
      arrival_time=_arrival_time;
      dining_time=_dining_time;
      party_size=_party_size;
      priority=_priority;
      
    }
        
    public String getName() {
    	return name;
    }

 
    
    public int getPriority() {
    	return priority;
    }

    public int compareTo(DiningParty other) {
      int other_p=other.getPriority();
      if (priority>other_p) {
    	  return -1;
      }else if(priority<other_p){
    	  return 1;    	  
      }else {return 0;}
   
    }
    public void lessDin(){
    	dining_time--;
    }
    
    
    
    public boolean dinFin() {       //dining is finished
    	if(dining_time==0) {
    		return true;
    	}return false;
    }
}
