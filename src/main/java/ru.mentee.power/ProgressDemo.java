package ru.mentee.power;

public class ProgressDemo {
    static void main(String[] args) {
        var progress = new MenteeProgress("Михаил", 2, 10);

        System.out.println(progress.summary());
        if (progress.readyForSprint()) {
            System.out.println("Status: sprint ready");
        } else {
            System.out.println("Status: backlog first");
        }
    }
}