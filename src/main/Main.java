package main;

public class Main {

    public static void main(String[] args) {

        // Simulation set-up
        int simulationClock = 0;

        Event event = new Event();
        event.push(EventType.TASK_SELECTION);


        int hyperperiod;
        Task selected = null;
        EventType actual;

        // Task Creation and TaskSet Filling
        Task ts1 = new Task(0,6, 2, 5);
        Task ts2 = new Task(1,8, 2, 4);
        Task ts3 = new Task(2,12, 4, 8);

        TaskSet taskSet = new TaskSet();
        taskSet.addTask(ts1);
        taskSet.addTask(ts2);
        taskSet.addTask(ts3);

        // HyperPeriod Computation
        hyperperiod = taskSet.getHyperPeriod();

        // First Release of tasks
        ts1.instanceInc();
        ts2.instanceInc();
        ts3.instanceInc();

        while (simulationClock <= hyperperiod && !event.isEmpty()) {

            actual = event.pop();

            if (actual == EventType.TASK_ARRIVAL) {
                if (taskSet.taskReleased(simulationClock))
                    event.push(EventType.TASK_SELECTION);
            }

            else if (actual == EventType.TASK_EXECUTION) {
                System.out.println(selected.toString() + " Executed at : "+simulationClock);

                if (selected.progres()){
                    event.push(EventType.TASK_SELECTION);
                } else {
                    event.push(EventType.TASK_EXECUTION);
                }
                simulationClock++;

            }

            else if (actual == EventType.TASK_SELECTION) {
                selected = taskSet.taskSelection();
                System.out.println(selected.toString() + " Selected at : "+simulationClock);

                event.push(EventType.TASK_EXECUTION);
                event.push(EventType.TASK_ARRIVAL);
            }
        }
    }
}
