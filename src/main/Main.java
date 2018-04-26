package main;

public class Main {

    public static int simulationClock = 0;
    public static Event event;

    public static void main(String[] args) {


        // Simulation set-up
        event = new Event();
        event.push(EventType.TASK_SELECTION);


        int hyperperiod;
        Task selected = null;
        EventType actual;

        // Task Creation and TaskSet Filling
        Task ts1 = new Task(1, 6, 2, 5);
        Task ts2 = new Task(2, 8, 2, 4);
        Task ts3 = new Task(3, 12, 4, 8);

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

                if (selected != null && !selected.isTerminated()){

                    System.out.println("EXECUTION -- " + selected.toString() + " Executed at : " + simulationClock);

                    if (selected.progres()) {
                        event.push(EventType.TASK_SELECTION);
                    } else {
                        event.push(EventType.TASK_EXECUTION);
                    }

                }
                event.push(EventType.TASK_ARRIVAL);

            }

            else if (actual == EventType.TASK_SELECTION) {
                selected = taskSet.taskSelection();
                if (selected != null)
                    System.out.println("SELECTION -- " + selected.toString() + " Selected at : " + simulationClock);
                else
                    System.out.println("Anything selected at : "+simulationClock);

                event.push(EventType.TASK_EXECUTION);
                event.push(EventType.TASK_ARRIVAL);
            }
        }
    }
}
