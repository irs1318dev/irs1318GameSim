package org.usfirst.irs1318.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {

    @Test
    public void builderTest(){

        Task task = new Task.Builder()
                .setName("shoot cube on scale plate")
                .setId("rscsp")
                .setActivity("shoot")
                .setObject("cube")
                .setActor("robot")
                .setTargetType("scalePlate")
                .build();

        assertEquals("shoot cube on scale plate", task.getName());
        assertEquals("rscsp", task.getId());
        assertEquals("shoot", task.getActivity());
        assertEquals("cube", task.getObject());
        assertEquals("robot", task.getActor());
        assertEquals("scalePlate", task.getTargetType());
    }
    @Test
    public void testBuilderWithJackson() throws Exception {

        Task task = new Task.Builder()
                .setName("shoot cube on scale plate")
                .setId("rscsp")
                .setActivity("shoot")
                .setObject("cube")
                .setActor("robot")
                .setTargetType("scalePlate")
                .build();

        assertEquals("shoot cube on scale plate", task.getName());
        assertEquals("rscsp", task.getId());
        assertEquals("shoot", task.getActivity());
        assertEquals("cube", task.getObject());
        assertEquals("robot", task.getActor());
        assertEquals("scalePlate", task.getTargetType());
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(task);
        System.out.println(value);
        Task taskValue = objectMapper.readValue(value, Task.class);
        System.out.println(taskValue.toString());
        assertEquals(task, taskValue);

        Task copyTask = new Task.Builder().copyOf(task).build();
        assertEquals(task, copyTask);

    }

}