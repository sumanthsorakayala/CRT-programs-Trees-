public class FCFS{


    // Function to find the waiting time for all 
    // processes 
    static void findWaitingTime(int processes[], int n, int bt[], int wt[], int at[]) 
    { 
        int service_time[] = new int[n]; 
        service_time[0] = at[0]; 
        wt[0] = 0; 
    
        // calculating waiting time 
        for (int i = 1; i < n ; i++) 
        { 
            //representing wasted time in queue
            int wasted=0;
            // Add burst time of previous processes 
            service_time[i] = service_time[i-1] + bt[i-1]; 
    
            // Find waiting time for current process = 
            // sum - at[i] 
            wt[i] = service_time[i] - at[i]; 
    
            // If waiting time for a process is in negative 
            // that means it is already in the ready queue 
            // before CPU becomes idle so its waiting time is 0 
            // wasted time is basically time for process to wait after a process is over
            if (wt[i] < 0) {
                wasted = Math.abs(wt[i]);
                wt[i] = 0; 
            }
            //Add wasted time
            service_time[i] = service_time[i] + wasted;
        } 
    } 
    
    // Function to calculate turn around time 
    static void findTurnAroundTime(int processes[], int n, int bt[], 
                                        int wt[], int tat[]) 
    { 
        // Calculating turnaround time by adding bt[i] + wt[i] 
        for (int i = 0; i < n ; i++) 
            tat[i] = bt[i] + wt[i]; 
    } 
    
    // Function to calculate average waiting and turn-around 
    // times. 
    static void findavgTime(int processes[], int n, int bt[], int at[]) 
    { 
        int wt[] = new int[n], tat[] = new int[n]; 
    
        // Function to find waiting time of all processes 
        findWaitingTime(processes, n, bt, wt, at); 
    
        // Function to find turn around time for all processes 
        findTurnAroundTime(processes, n, bt, wt, tat); 
    
        // Display processes along with all details 
        System.out.print("Processes " + " Burst Time " + " Arrival Time "
            + " Waiting Time " + " Turn-Around Time "
            + " Completion Time \n"); 
        int total_wt = 0, total_tat = 0; 
        for (int i = 0 ; i < n ; i++) 
        { 
            total_wt = total_wt + wt[i]; 
            total_tat = total_tat + tat[i]; 
            int compl_time = tat[i] + at[i]; 
            System.out.println(i+1 + "\t\t" + bt[i] + "\t\t"
                + at[i] + "\t\t" + wt[i] + "\t\t "
                + tat[i] + "\t\t " + compl_time); 
        } 
    
        System.out.print("Average waiting time = "
            + (float)total_wt / (float)n); 
        System.out.print("\nAverage turn around time = "
            + (float)total_tat / (float)n); 
    } 
    
    // Driver code 
    
        public static void main(String args[]) { 
            // Process id's 
        int processes[] = {1, 2, 3}; 
        int n = processes.length; 
    
        // Burst time of all processes 
        int burst_time[] = {5, 9, 6}; 
    
        // Arrival time of all processes 
        int arrival_time[] = {0, 3, 6}; 
    
        findavgTime(processes, n, burst_time, arrival_time);
    
        } 
    } 
    
    /*This code is contributed by PrinciRaj1992*/