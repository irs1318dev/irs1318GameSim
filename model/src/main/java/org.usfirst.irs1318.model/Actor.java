package org.usfirst.irs1318.model;

import java.util.HashSet;
import java.util.Set;

public class Actor {
    private final String name;
    private final Set<ListensTo> listensTo;
    private final Alliance alliance;
    private final String type;

    private Actor(String name, Set<ListensTo> listensTo, Alliance alliance, String type){
        this.name = name;
        this.listensTo = listensTo; //Copy into immutable set
        this.alliance = alliance;
        this.type = type;
    }

    public String getName() {

        return name;
    }

    public Alliance getAlliance(){

        return alliance;
    }

    public static class Builder {
        private String name;
        private Set<ListensTo> listensTo;
        private Alliance alliance;
        private String type;

        public Builder(){
            listensTo = new HashSet<>();
        }
        public Builder setName(String name){
            this.name = name;
            return this;
        }
        public Builder addListensTo(ListensTo listensTo){
            this.listensTo.add(listensTo);
            return this;
        }
        public Builder setAlliance(Alliance alliance){
            this.alliance = alliance;
            return this;
        }
        public Builder setType(String type) {
            this.type = type;
            return this;
        }
        public Actor build(){
            return new Actor(name, listensTo, alliance, type);
        }
    }
}
