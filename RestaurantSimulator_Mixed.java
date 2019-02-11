//smaller groups can sit at larger tables.less operating time, more average wait time

import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class RestaurantSimulator_Mixed {
	static PriorityQueue<DiningParty> queueFour=new PriorityQueue<DiningParty>();
	static PriorityQueue<DiningParty> queueSix=new PriorityQueue<DiningParty>();
	static PriorityQueue<DiningParty> queueEight=new PriorityQueue<DiningParty>();
	

	public static void main(String[] args) throws FileNotFoundException{
		File inp=new File("sorted_customers.txt");
		Scanner sc=new Scanner(inp);
		int totaltime=-1;
		int twt=0; //total wait time
		
		int countc=1;//count customer
		String name=sc.next();
		name=name.concat(" ");
		name=name.concat(sc.next());//customer name
		int at=Integer.parseInt(sc.next());//arrival time
		int dt=Integer.parseInt(sc.next());//dining time
		int ps=Integer.parseInt(sc.next());//party size
		int pr=Integer.parseInt(sc.next());//priority
		DiningParty ndp=new DiningParty(name,at,dt,ps,pr);
		//initial values at t=0;
		boolean tableEmpty4=true;
		boolean tableEmpty6=true;
		boolean tableEmpty8=true;
		DiningParty t4serving=null;
		DiningParty t6serving=null;
		DiningParty t8serving=null;
		for(int time=0;time<200;time++) {
			
			while(at==time&&sc.hasNext()) {
				if(ps<5) {
					queueFour.add(ndp);
					
				}if(ps>3&&ps<7){
					queueSix.add(ndp);
				}
				if(ps>4)
					{queueEight.add(ndp);}
				
				
				name=sc.next();
				name=name.concat(" ");
				name=name.concat(sc.next());
				at=Integer.parseInt(sc.next());
				dt=Integer.parseInt(sc.next());
				ps=Integer.parseInt(sc.next());
				pr=Integer.parseInt(sc.next());
				ndp=new DiningParty(name,at,dt,ps,pr);
				countc++;
			}	//add dining party with arrival time=current time into priority queues
			
			if(tableEmpty4!=true) {
				t4serving.lessDin();
				if(t4serving.dinFin()) {
				tableEmpty4=true;
				System.out.println(t4serving.getName());
				System.out.println(time);
				}
			}
			if (tableEmpty4){
				if (queueFour.size()>0) {
					t4serving=queueFour.poll();
					queueSix.remove(t4serving);
					queueEight.remove(t4serving);
					tableEmpty4=false;
					System.out.println(t4serving.getName());
					System.out.println(time);
				}	
			}
			if(tableEmpty6!=true) {
				t6serving.lessDin();
				if(t6serving.dinFin()) {
				tableEmpty6=true;
				System.out.println(t6serving.getName());
				System.out.println(time);
				}
			}
			if (tableEmpty6){
				if (queueSix.size()>0) {
					t6serving=queueSix.poll();
					queueFour.remove(t6serving);
					queueEight.remove(t6serving);
					System.out.println(t6serving.getName());
					System.out.println(time);
					tableEmpty6=false;
				}	
			}
			if(tableEmpty8!=true) {
				t8serving.lessDin();
				if(t8serving.dinFin()) {
				tableEmpty8=true;
				System.out.println(t8serving.getName());
				System.out.println(time);
				}
			}
			if (tableEmpty8){
				if (queueEight.size()>0) {
					t8serving=queueEight.poll();
					queueFour.remove(t8serving);
					queueSix.remove(t8serving);
					tableEmpty8=false;
					System.out.println(t8serving.getName());
					System.out.println(time);
				}	
			}
				twt+=queueFour.size();
				twt+=queueSix.size();
				twt+=queueEight.size();
			if(tableEmpty4 && tableEmpty6 
					&&tableEmpty8&&queueFour.size()==0&&queueSix.size()==0&&queueEight.size()==0)	
					{
				totaltime=time;
				time=200000;
				
				
			}
			
		}
		//System.out.println(totaltime);
		//System.out.println(twt/countc);
		
			
		
	}

}
