package org.usfirst.irs1318.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TaskDetailTest {
    @Test
    public void testBuilder() {
        Task task = new Task.Builder()
                .build();
        TaskDetail taskdetail = new TaskDetail.Builder()
                .setDuration(12)
                .setReactionTime(4)
                .setReliability(0.4)
                .setTask(task)
                .build();
        assertEquals(12, taskdetail.getDuration());
        assertEquals(0.4, taskdetail.getReliability());
        assertEquals(4, taskdetail.getReactionTime());
        assertEquals(task, taskdetail.getTask());
    }
    @Test
    public void testBuilderWithJackson() throws Exception{
        Task task = new Task.Builder()
                .build();
        TaskDetail taskDetail =  new TaskDetail.Builder()
                .setDuration(12)
                .setReactionTime(4)
                .setReliability(0.4)
                .setTask(task)
                .build();

        assertEquals(12, taskDetail.getDuration());
        assertEquals(0.4, taskDetail.getReliability());
        assertEquals(task, taskDetail.getTask());
        assertEquals(4, taskDetail.getReactionTime());
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(taskDetail);
        System.out.println(value);
        TaskDetail taskDetailValue = objectMapper.readValue(value, TaskDetail.class);
        System.out.println(taskDetailValue.toString());
        assertEquals(taskDetail, taskDetailValue);

        TaskDetail copyTaskDetail = new TaskDetail.Builder().copyOf(taskDetail).build();
        assertEquals(taskDetail, copyTaskDetail);

    }
}
