package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void FCFS_calculations(List<int[]> processes) {
        int waitingTime = 0;
        int turnaroundTime;
        int i = 0;
        int[] currentProcess;
        double sum = 0;
        double amountOfProcesses = processes.size();
        double average;
        System.out.println("-----------FCFS-----------");
        System.out.println("Process ID | Waiting Time | Turnaround Time");
        while (!processes.isEmpty()) {
            sum += waitingTime;
            currentProcess = processes.remove(0);
            turnaroundTime = waitingTime + currentProcess[1];
            System.out.printf("    %d      |      %d       |     %d\n", currentProcess[0], waitingTime, turnaroundTime);
            waitingTime +=  currentProcess[1];
        }
        average = sum / amountOfProcesses;
        System.out.printf("\nThe average time: %.2f\n", average);
    }

    //public static void

    public static void main(String[] args) {
        List<int[]> processes = new ArrayList<>();

        processes.add(new int[] {1, 2, 2});
        processes.add(new int[] {2, 1, 1});
        processes.add(new int[] {3, 8, 4});
        processes.add(new int[] {4, 4, 2});
        processes.add(new int[] {5, 5, 3});

        FCFS_calculations(processes);
    }
}