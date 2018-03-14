package org.usfirst.irs1318.model;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataUpdateTest {
    @Test
    public void testBuilder(){
        DataUpdate dataupdate = new DataUpdate.Builder()
                .setEvent("addCubeEvent")
                .setOnReceive("OwnershipChange")
                .build();
        assertEquals("addCubeEvent", dataupdate.getEvent());
        assertEquals("OwnershipChange", dataupdate.getOnReceive());

    }
    @Test
    public void testBuilderWithJackson()throws Exception{

        DataUpdate dataUpdate = new DataUpdate.Builder()

                .setEvent("redPlateRedSwitch")
                .setOnReceive("OwnershipChange")
                .build();

        assertEquals("redPlateRedSwitch", dataUpdate.getEvent());
        assertEquals("OwnershipChange", dataUpdate.getOnReceive());
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataUpdate);
        System.out.println(value);
        DataUpdate dataUpdateValue = objectMapper.readValue(value, DataUpdate.class);
        System.out.println(dataUpdateValue.toString());
        assertEquals(dataUpdate, dataUpdateValue);
    }
}