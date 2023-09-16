package org.example;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static List<Timeslot> timeSlotsInADay(LocalDateTime day, int interviewSize, int breakSize, int maxTimeInterviewsPerday) {
        List<Timeslot> timeslotsInADay = new ArrayList<>();
        int timeInterviewPerday = 0;
        while() {

        }

    }
    public static List<Timeslot> generator(LocalDateTime startTime, LocalDateTime endTime, int interviewSize, int breakSize, int maxTimeInterviewsPerday) {
        List<Timeslot> timeslots = new ArrayList<>();
        List<LocalDateTime> localDateTimes = startTime.datesUntil(endTime).collect(Collectors.toList);

        for(LocalDateTime localDateTime: localDateTimes) {
            timeslots.addAll(timeSlotsInADay(localDateTime, interviewSize, breakSize, maxTimeInterviewsPerday));

        }


        return timeslos;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}