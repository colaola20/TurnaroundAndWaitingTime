package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> processes = new ArrayList<>();
        List<Integer> burstTime = new ArrayList<>();
        List<Integer> priorities = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            processes.add(i);
        }
        burstTime.add(2);
        burstTime.add(1);
        burstTime.add(8);
        burstTime.add(4);
        burstTime.add(5);

        priorities.add(2);
        priorities.add(1);
        priorities.add(4);
        priorities.add(2);
        priorities.add(3);

        System.out.println(processes);
        System.out.println(burstTime);
        System.out.println(priorities);
    }
}