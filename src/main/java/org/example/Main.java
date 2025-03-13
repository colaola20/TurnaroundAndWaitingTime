package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {


    /**
     * FCFS_calculations method calculates the waiting time and turnaround time for each process in the list of processes
     * @param processes - list of processes
     */
    public static void FCFS_calculations(List<int[]> processes) {
        int waitingTime = 0;
        int turnaroundTime;
        int[] currentProcess;
        double sum = 0;
        double amountOfProcesses = processes.size();
        double average;
        System.out.println("-----------FCFS-----------");
        System.out.println("Process ID | Waiting Time | Turnaround Time");
        // looping though process array until it's empty
        while (!processes.isEmpty()) {
            // calculating the sum of all processes' waiting time
            sum += waitingTime;
            // assignees currentProcess as a first element in process, following the principle First-Come-Fist-Serve, and removes this process from processes
            currentProcess = processes.removeFirst();
            // calculates turnaround time as a sum of waiting time and process's burst time
            turnaroundTime = waitingTime + currentProcess[1];
            System.out.printf("    %d      |      %d       |     %d\n", currentProcess[0], waitingTime, turnaroundTime);
            // calculates the wait time for the next process
            waitingTime +=  currentProcess[1];
        }
        // average calculations
        average = sum / amountOfProcesses;
        System.out.printf("\nThe average time: %.2f\n\n", average);
    }

    /**
     * SJF_calculation method calculates the waiting time and turnaround time for each process in the list of processes
     * @param processes - list of processes
     */
    public static void SJF_calculation(List<int[]> processes) {
        int waitingTime = 0;
        int turnaroundTime;
        int[] shortest_process;
        double sum = 0;
        double amountOfProcesses = processes.size();
        double average;
        System.out.println("-----------SJF-----------");
        System.out.println("Process ID | Waiting Time | Turnaround Time");
        // looping though process array until it's empty
        while (!processes.isEmpty()) {
            // get the process with the shortest burst time
            shortest_process = getMinBurst(processes);
            // calculating the sum of all processes' waiting time
            sum += waitingTime;
            // calculates turnaround time as a sum of waiting time and process's burst time
            turnaroundTime = waitingTime + shortest_process[1];
            System.out.printf("    %d      |      %d       |     %d\n", shortest_process[0], waitingTime, turnaroundTime);
            // calculates the wait time for the next process
            waitingTime +=  shortest_process[1];
        }
        // average calculations
        average = sum / amountOfProcesses;
        System.out.printf("\nThe average time: %.2f\n", average);
    }

    /**
     * getMinBurst method returns the process with the shortest burst time
     * @param processes - list of processes
     * @return the process with the shortest burst time
     */
    public static int[] getMinBurst(List<int[]> processes) {
        int i = 0;
        int sortest_process_index = 0;
        int[] shortest_process = processes.getFirst();
        // looping through the list of processes
        while (i < processes.size()) {
            // if the current process has a shorter burst time than the previous one, assign the current process as the shortest process
            if (shortest_process[1] > processes.get(i)[1]) {
                shortest_process = processes.get(i);
                sortest_process_index = i;
            }
            i++;
        }
        // remove the process with the shortest burst time from the list of processes
        processes.remove(sortest_process_index);
        return shortest_process;
    }

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        // creates a list of processes
        List<int[]> processes = new ArrayList<>();

        // adding processes to the list
        processes.add(new int[] {1, 2, 2});
        processes.add(new int[] {2, 1, 1});
        processes.add(new int[] {3, 8, 4});
        processes.add(new int[] {4, 4, 2});
        processes.add(new int[] {5, 5, 3});

        FCFS_calculations(processes);
        // adding processes to the list as it's empty after calling FCFS_calculations method
        processes.add(new int[] {1, 2, 2});
        processes.add(new int[] {2, 1, 1});
        processes.add(new int[] {3, 8, 4});
        processes.add(new int[] {4, 4, 2});
        processes.add(new int[] {5, 5, 3});

        SJF_calculation(processes);
    }
}