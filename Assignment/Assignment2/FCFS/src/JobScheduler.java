import java.util.Scanner;

public class JobScheduler {

    void sortArrivalTime(int number_process, int pid[], int arrival_time[], int burst_time[]) {		//sorting according to arrival times
        int swap_variable;
        for (int i = 0; i < number_process; i++) {
            for (int j = 0; j < number_process - (i + 1); j++) {
                if (arrival_time[j] > arrival_time[j + 1]) {
                	swap_variable = arrival_time[j];
                    arrival_time[j] = arrival_time[j + 1];
                    arrival_time[j + 1] = swap_variable;
                    swap_variable = burst_time[j];
                    burst_time[j] = burst_time[j + 1];
                    burst_time[j + 1] = swap_variable;
                    swap_variable = pid[j];
                    pid[j] = pid[j + 1];
                    pid[j + 1] = swap_variable;
                }
            }
        }
    }

    int[] completionTime(int number_process, int arrival_time[], int burst_time[], int completion_time[]) { //completion time of each process
        for (int i = 0; i < number_process; i++) {
            if (i == 0) {
                completion_time[i] = arrival_time[i] + burst_time[i];
            } else {
                if (arrival_time[i] > completion_time[i - 1]) {
                    completion_time[i] = arrival_time[i] + burst_time[i];
                } else
                    completion_time[i] = completion_time[i - 1] + burst_time[i];
            }
        }
        return completion_time;
    }

    int[] turnAroundTime(int number_process, int arrival_time[], int burst_time[], int completion_time[], int turn_around_time[]) { //Turnaround time of each process
        completionTime(number_process, arrival_time, burst_time, completion_time);
        for (int i = 0; i < number_process; i++) {
            turn_around_time[i] = completion_time[i] - arrival_time[i]; // turnaround time= completion time- arrival time
        }
        return turn_around_time;
    }

    int[] waitingTime(int number_process, int arrival_time[], int burst_time[], int completion_time[], int turn_around_time[], int waiting_time[]) { //waiting time of each process
        turnAroundTime(number_process, arrival_time, burst_time, completion_time, turn_around_time);
        for (int i = 0; i < number_process; i++) {
            waiting_time[i] = turn_around_time[i] - burst_time[i]; // waiting time= turnaround time- burst time
        }
        return waiting_time;
    }

    float averageWaitingTime(int number_process, int arrival_time[], int burst_time[], int completion_time[], int turn_around_time[], int waiting_time[]) { //average waiting time
        float average_waiting_time = 0;
        int waiting_time_value[] = waitingTime(number_process, arrival_time, burst_time, completion_time, turn_around_time, waiting_time);
        for (int i = 0; i < number_process; i++) {
            average_waiting_time += waiting_time_value[i];
        }
        return average_waiting_time / number_process;

    }
    
    int maximumWaitingTime(int waiting_time[]){
    	int maximum_waiting_time = waiting_time[0];
        for(int i = 0; i < waiting_time.length; i++)
        {
            if(maximum_waiting_time < waiting_time[i])
            {
            	maximum_waiting_time = waiting_time[i];
            }
        }
        return maximum_waiting_time;
        		
    	
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of process: ");
        int number_process = sc.nextInt();
        int pid[] = new int[number_process]; // process ids
        int arrival_time[] = new int[number_process]; // arrival times
        int burst_time[] = new int[number_process]; // burst or execution times
        int completion_time[] = new int[number_process]; // completion times
        int turn_around_time[] = new int[number_process]; // turn around times
        int waiting_time[] = new int[number_process]; // waiting times 
        float average_waiting_time = 0;
        int maximum_waiting_time=0;

        for (int i = 0; i < number_process; i++) {
            System.out.print("Enter Process[" + (i + 1) + "] arrival time: ");
            arrival_time[i] = sc.nextInt();
            System.out.print("Enter Process[" + (i + 1) + "] brust time: ");
            burst_time[i] = sc.nextInt();
            pid[i] = i + 1;
        }

        JobScheduler job = new JobScheduler();
        job.sortArrivalTime(number_process, pid, arrival_time, burst_time);
        completion_time = job.completionTime(number_process, arrival_time, burst_time, completion_time);
        turn_around_time = job.turnAroundTime(number_process, arrival_time, burst_time, completion_time, turn_around_time);
        waiting_time = job.waitingTime(number_process, arrival_time, burst_time, completion_time, turn_around_time, waiting_time);
        average_waiting_time = job.averageWaitingTime(number_process, arrival_time, burst_time, completion_time, turn_around_time, waiting_time);
        maximum_waiting_time=job.maximumWaitingTime(waiting_time);

        System.out.println("\nProcess Id\tArrival Time\tBrust Time\tCompletion Time\tTurnAround Time\tWaiting Time");
        for (int i = 0; i < number_process; i++) {
            System.out.println(pid[i] + "\t\t" + arrival_time[i] + "\t\t" + burst_time[i] + "\t\t" + completion_time[i] + "\t\t" + turn_around_time[i] + "\t\t" + waiting_time[i]);
        }
        sc.close();
        System.out.println("\nAverage waiting time : " + average_waiting_time); // printing average waiting time.
        System.out.println("Maximum Waiting Time : "+maximum_waiting_time);
    }
}