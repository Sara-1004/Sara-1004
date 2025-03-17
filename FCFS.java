import java.util.Scanner;

public class FCFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        
        int[] burstTime = new int[n];
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];

        // Input burst times
        for (int i = 0; i < n; i++) {
            System.out.print("Enter burst time for Process " + (i + 1) + ": ");
            burstTime[i] = sc.nextInt();
        }

        // Calculate waiting time
        waitingTime[0] = 0; // First process has no waiting time
        for (int i = 1; i < n; i++) {
            waitingTime[i] = waitingTime[i - 1] + burstTime[i - 1];
        }

        // Calculate turnaround time
        for (int i = 0; i < n; i++) {
            turnaroundTime[i] = waitingTime[i] + burstTime[i];
        }

        // Display results
        System.out.println("\nProcess\tBT\tWT\tTAT");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t" + burstTime[i] + "\t" + waitingTime[i] + "\t" + turnaroundTime[i]);
        }

        sc.close();
    }
}
