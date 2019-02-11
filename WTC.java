import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WTC {

	public static void main(String[] args) throws FileNotFoundException {
		File inp=new File("sorted_customers.txt");
		Scanner sc=new Scanner(inp);
		String name=null;
		int at;
		int dt;
		int ps;
		int pr;
		int tdt=0;
		while(sc.hasNext()) {
			name=sc.next();
			name=name.concat(" ");
			name=name.concat(sc.next());//customer name
			at=Integer.parseInt(sc.next());//arrival time
			dt=Integer.parseInt(sc.next());//dining time
		    ps=Integer.parseInt(sc.next());//party size
			pr=Integer.parseInt(sc.next());//priority
			if(ps<5) {
			tdt++;
			}
			else if(ps<7) {
				tdt++;
				}
			else {
				tdt++;
				}
		}
		System.out.println(tdt);
	}

}
