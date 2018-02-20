package org.usfirst.irs1318.model.powerup2018;

import org.junit.Test;
import org.usfirst.irs1318.model.Actor;
import org.usfirst.irs1318.model.ListensTo;

import java.util.HashSet;
import java.util.Set;

public class FoulTracker {
    @Test
    public void buildG23FoulTracker(){

        Set<ListensTo> listensTo = new HashSet<>();

            listensTo.add(
                new ListensTo.Builder()
                .setActorName("R1")
                .build());









        Actor g23FoulTracker =
                new Actor.Builder()
                .setName("G23FoulTracker")
                .setListensTo(listensTo)
                .build();

    }


}
