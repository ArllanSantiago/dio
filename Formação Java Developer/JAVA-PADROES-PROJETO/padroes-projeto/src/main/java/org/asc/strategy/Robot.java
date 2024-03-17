package org.asc.strategy;

public class Robot {
    private Behavior behavior;

    public Behavior getComportamento() {
        return behavior;
    }

    public Robot() {
    }

    public Robot(Behavior behavior) {
        this.behavior = behavior;
    }

    public void setComportamento(Behavior behavior) {
        this.behavior = behavior;
    }

    public void mover(){
        this.behavior.mover();
    }
}
