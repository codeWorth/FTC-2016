package org.firstinspire.ftc.team7316;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by andrew on 9/15/16.
 */
public class Scheduler {

    public static Scheduler instance = new Scheduler();

    private ArrayList<Loopable> tasks = new ArrayList<Loopable>();

    public Scheduler () {}

    public void addTask(Loopable task) {
        tasks.add(task);
    }

    public void loop() {
        int i = 0;
        while (i < tasks.size()) {
            Loopable thisTask = tasks.get(i);
            if (thisTask.shouldRemove()) {
                tasks.remove(i);
            } else {
                thisTask.loop();
                i++;
            }
        }
    }

}
