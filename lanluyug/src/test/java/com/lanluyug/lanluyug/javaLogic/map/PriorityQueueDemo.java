package com.lanluyug.lanluyug.javaLogic.map;

import org.junit.jupiter.api.Test;

import java.util.*;

public class PriorityQueueDemo {

    @Test
    public void test(){

        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(10);
        pq.add(22);
        pq.addAll(Arrays.asList(new Integer[]{11,12,34,2,7,4,15,12,8,6,19,13}));

        while(pq.peek() != null){
            System.out.print(pq.poll() + " ");
        }

        System.out.println();
        // 倒序
        Queue<Integer> pq1 = new PriorityQueue<>(11, Collections.reverseOrder());
        pq1.offer(10);
        pq1.add(22);
        pq1.addAll(Arrays.asList(new Integer[]{11,12,34,2,7,4,15,12,8,6,19,13}));

        while(pq1.peek() != null){
            System.out.print(pq1.poll() + " ");
        }

    }

    static class Task{
        int priority;
        String name;

        public Task(int priority, String name){
            this.priority = priority;
            this.name = name;
        }
        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private static Comparator<Task> taskComparator = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.getPriority() > o2.getPriority()) return -1;
                else if(o1.getPriority()< o2.getPriority()) return 1;
                return 0;
            }
        };


        public static void testCustom(){
            Queue<Task> tasks = new PriorityQueue<>(11, taskComparator);
            tasks.offer(new Task(20, "写日记"));
            tasks.offer(new Task(10, "看电视"));
            tasks.offer(new Task(200, "写代码"));
            tasks.offer(new Task(30, "写书"));
            Task task = tasks.poll();
            while (task !=null){
                System.out.print("处理任务：" + task.getName() + ",优先级："
                    + task.getPriority() + "\n");
                task = tasks.poll();
            }
        }

        public static void main(String[] args){
            testCustom();
        }
    }
}
