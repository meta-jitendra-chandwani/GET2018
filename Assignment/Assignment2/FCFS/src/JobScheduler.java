import java.util.Scanner;

public class JobScheduler {

	/*
	 * sorting of processing according to their arrival time
	 * @param process Id
	 * @param arrival time of each process
	 * @param burst time of each process
	 */
    void sortArrivalTime(int pid[], int arrivaltime[], int bursttime[]) {		//
        int swapvariable;
        for (int i = 0; i < arrivaltime.length; i++) {
            for (int j = 0; j < arrivaltime.length - (i + 1); j++) {
                if (arrivaltime[j] > arrivaltime[j + 1]) {
                	swapvariable = arrivaltime[j];
                    arrivaltime[j] = arrivaltime[j + 1];
                    arrivaltime[j + 1] = swapvariable;
                    swapvariable = bursttime[j];
                    bursttime[j] = bursttime[j + 1];
                    bursttime[j + 1] = swapvariable;
                    swapvariable = pid[j];
                    pid[j] = pid[j + 1];
                    pid[j + 1] = swapvariable;
                }
            }
        }
    }

    /*
     * compute completion time of each process     *
     * @param arrival time of each process
	 * @param burst time of each process
	 * @return completion time of each process
     */
    int[] completionTime(int arrivaltime[], int bursttime[]) { //
    	int completiontime[]=new int[arrivaltime.length];
        for (int i = 0; i < arrivaltime.length; i++) {
            if (i == 0) {
                completiontime[i] = arrivaltime[i] + bursttime[i];
            } else {
                if (arrivaltime[i] > completiontime[i - 1]) {
                    completiontime[i] = arrivaltime[i] + bursttime[i];
                } else
                    completiontime[i] = completiontime[i - 1] + bursttime[i];
            }
        }
        return completiontime;
    }

    /*
     * compute Turn around time of each process
     * @param arrival time of each process
	 * @param completion time of each process
	 * @return turn around time of each process, turnaround time= completion time- arrival time
     */
    int[] turnAroundTime(int arrivaltime[], int completiontime[]) {
    	int turnaroundtime[]=new int[arrivaltime.length];
        for (int i = 0; i < arrivaltime.length; i++) {
            turnaroundtime[i] = completiontime[i] - arrivaltime[i];  
        }
        return turnaroundtime;
    }

    /*
     * compute Turnaround time of each process
     * @param burst time of each process
	 * @param completion time of each process
	 * @param turn around time of each process
	 * @return waiting time time of each process, waiting time= turnaround time- burst time* 
     */
    int[] waitingTime(int bursttime[], int completiontime[], int turnaroundtime[]) { //waiting time of each process
    	int waitingtime[]=new int[bursttime.length];
    	for (int i = 0; i < bursttime.length; i++) {
            waitingtime[i] = turnaroundtime[i] - bursttime[i]; // waiting time= turnaround time- burst time
        }
        return waitingtime;
    }

    /*
     * compute average waiting time of all processes
     * @param waiting time of each process
     * @return average waiting time
     */
    float averageWaitingTime(int waitingtime[]) { //average waiting time
        float averagewaitingtime = 0;        
        for (int i = 0; i < waitingtime.length; i++) {
            averagewaitingtime += waitingtime[i];
        }
        return averagewaitingtime /  waitingtime.length;
    }
    
    /*
     * compute maximum waiting time
     * @param waiting time of each process
     * @return maximum waiting time
     */
    int maximumWaitingTime(int waitingtime[]){
    	int maximumwaitingtime = waitingtime[0];
        for(int i = 0; i < waitingtime.length; i++)
        {
            if(maximumwaitingtime < waitingtime[i])
            {
            	maximumwaitingtime = waitingtime[i];
            }
        }
        return maximumwaitingtime;
        		
    	
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of process: ");
        int numberprocess = sc.nextInt();
        int pid[] = new int[numberprocess]; // process ids
        int arrivaltime[] = new int[numberprocess]; // arrival times
        int bursttime[] = new int[numberprocess]; // burst or execution times
        int completiontime[] = new int[numberprocess]; // completion times
        int turnaroundtime[] = new int[numberprocess]; // turn around times
        int waitingtime[] = new int[numberprocess]; // waiting times 
        float averagewaitingtime = 0;
        int maximumwaitingtime=0;

        for (int i = 0; i < numberprocess; i++) {
            System.out.print("Enter Process[" + (i + 1) + "] arrival time: ");
            arrivaltime[i] = sc.nextInt();
            System.out.print("Enter Process[" + (i + 1) + "] brust time: ");
            bursttime[i] = sc.nextInt();
            pid[i] = i + 1;
        }

        JobScheduler job = new JobScheduler();
        job.sortArrivalTime(pid, arrivaltime, bursttime);
        completiontime = job.completionTime(arrivaltime, bursttime);
        turnaroundtime = job.turnAroundTime(arrivaltime, completiontime);
        waitingtime = job.waitingTime(bursttime, completiontime, turnaroundtime);
        averagewaitingtime = job.averageWaitingTime(waitingtime);
        maximumwaitingtime=job.maximumWaitingTime(waitingtime);

        System.out.println("\nProcess Id\tArrival Time\tBrust Time\tCompletion Time\tTurnAround Time\tWaiting Time");
        for (int i = 0; i < numberprocess; i++) {
            System.out.println(pid[i] + "\t\t" + arrivaltime[i] + "\t\t" + bursttime[i] + "\t\t" + completiontime[i] + "\t\t" + turnaroundtime[i] + "\t\t" + waitingtime[i]);
        }
        sc.close();
        System.out.println("\nAverage waiting time : " + averagewaitingtime); // printing average waiting time.
        System.out.println("Maximum Waiting Time : "+maximumwaitingtime);
    }
}