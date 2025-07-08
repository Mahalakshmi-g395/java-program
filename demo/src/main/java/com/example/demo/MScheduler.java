package com.example.demo;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.Scanner;


public class MScheduler {
    private static ArrayList<LocalDateTime> meetingList = new ArrayList<>();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;


        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Schedule a Meeting");
            System.out.println("2. Show Upcoming Meetings");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    scheduleMeeting(scanner);
                    break;
                case "2":
                    showMeetings();
                    break;
                case "3":
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2 or 3.");
            }
        }

        scanner.close();
    }

    // Schedules a meeting if there is no conflict
    private static void scheduleMeeting(Scanner scanner) {
        System.out.print("Enter meeting date and time (yyyy-MM-dd HH:mm): ");
        String input = scanner.nextLine();

        try {
            LocalDateTime meetingTime = LocalDateTime.parse(input, formatter);

            if (meetingTime.isBefore(LocalDateTime.now())) {
                System.out.println("Cannot schedule a meeting in the past.");
                return;
            }

            if (meetingList.contains(meetingTime)) {
                System.out.println("Conflict! A meeting is already scheduled at that time.");
            } else {
                meetingList.add(meetingTime);
                System.out.println("Meeting successfully scheduled for " + meetingTime.format(formatter));
            }

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date/time format. Please use yyyy-MM-dd HH:mm");
        }
    }
    private static void showMeetings() {
        if (meetingList.isEmpty()) {
            System.out.println("No upcoming meetings.");
            return;
        }

        System.out.println("\nUpcoming Meetings:");
        Collections.sort(meetingList);
        for (LocalDateTime meeting : meetingList) {
            if (meeting.isAfter(LocalDateTime.now())) {
                System.out.println("- " + meeting.format(formatter));
            }
        }
    }
}

