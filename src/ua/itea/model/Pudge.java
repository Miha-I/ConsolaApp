package ua.itea.model;

import java.util.List;

public class Pudge {

    private static final int MAX_LEVEL = 30;

    private String name;

    private int level;

    private List<String> phrases;

    public Pudge(){
        this.name = "pudge";
        this.level = (int) (Math.random() * MAX_LEVEL);
    }

    public Pudge(String name, int level){
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public List<String> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<String> phrases) {
        this.phrases = phrases;
    }

    @Override
    public String toString() {
        return "Pudge{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", phrases=" + phrases +
                '}';
    }
}
