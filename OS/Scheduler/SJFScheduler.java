//package Scheduler;
//
//import Tasks.Task;
//import java.util.*;
//
//public class SJFScheduler implements Scheduler {
//    Map<Task, Thread> taskThreadMap = new HashMap<>();
//
//    @Override
//    public void execute(List<Task> taskList) throws InterruptedException {
//        int currentTime = 0;
//        int completed = 0;
//        int n = taskList.size();
//
//        for (Task t : taskList) {
//            Thread tthread = new Thread(t);
//            tthread.start();
//            taskThreadMap.put(t, tthread);
//        }
//
//        taskList.sort(Comparator.comparingInt(Task::getArrivalTime));
//        int idx = 0;
//
//        while (completed < n) {
//            List<Task> availableTasks = new ArrayList<>();
//            while (idx < n && taskList.get(idx).getArrivalTime() <= currentTime) {
//                idx++;
//            }
//
//            for (Task t : taskList) {
//                if (!t.isCompleted() && t.getArrivalTime() <= currentTime) {
//                    availableTasks.add(t);
//                }
//            }
//
//            if (availableTasks.isEmpty()) {
//                currentTime++;
//                Thread.sleep(100);
//                continue;
//            }
//
//            Task nextTask = Collections.min(availableTasks, Comparator.comparingInt(Task::getBurstTime));
//
//            while (!nextTask.isCompleted()) {
//                nextTask.resume();
//                Thread.sleep(100);
//                currentTime++;
//            }
//            nextTask.calculateTimes(currentTime);
//            completed++;
//        }
//
//        for (Thread thread : taskThreadMap.values()) {
//            thread.join();
//        }
//
//        printStatistics(taskList);
//    }
//
//    private void printStatistics(List<Task> taskList) {
//        System.out.println("\nTask | Completion | Turnaround | Waiting");
//        for (Task t : taskList) {
//            System.out.printf(" %2d  |     %2d     |     %2d     |    %2d\n",
//                    t.getTaskId(), t.getCompletionTime(),
//                    t.getTurnaroundTime(), t.getWaitingTime());
//        }
//    }
//}
