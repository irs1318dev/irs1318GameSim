package org.usfirst.irs1318.model.powerup2018;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.usfirst.irs1318.model.Actor;
import org.usfirst.irs1318.model.Alliance;
import org.usfirst.irs1318.model.ListensTo;

import java.util.HashSet;
import java.util.Set;

public class FoulTracker {
    @Test
    public void buildG2FoulTracker() throws Exception {

        Set<ListensTo> listensTo = new HashSet<>();

        listensTo.add(
                new ListensTo.Builder()
                        .setActorName("R1")
                        .build());
        listensTo.add(
                new ListensTo.Builder()
                        .setActorName("R2")
                        .build());
        listensTo.add(
                new ListensTo.Builder()
                        .setActorName("R3")
                        .build());
        listensTo.add(
                new ListensTo.Builder()
                        .setActorName("B1")
                        .build());

        listensTo.add(
                new ListensTo.Builder()
                        .setActorName("B2")
                        .build());

        listensTo.add(
                new ListensTo.Builder()
                        .setActorName("B3")
                        .build());




        Actor g23RedFoulTracker =
                new Actor.Builder()
                        .setName("G23RedFoulTracker")
                        .setType("FoulTracker")
                        .setAlliance(Alliance.RED)
                        .setListensTo(listensTo)
                        .build();
        Actor g23BlueFoulTracker =
                new Actor.Builder()
                        .setName("G23BlueFoulTracker")
                        .setType("FoulTracker")
                        .setAlliance(Alliance.BLUE)
                        .setListensTo(listensTo)
                        .build();


        ObjectMapper objectMapper = new ObjectMapper();

        String value = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(g23RedFoulTracker);
        System.out.println(value);

        value = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(g23BlueFoulTracker);
        System.out.println(value);
    }


}
