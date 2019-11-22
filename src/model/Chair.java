package model;

public class Chair{
    public static final String OPERATIVE = "OPERATIVE";
    public static final String DEFECTIVE = "DEFECTIVE";
    private char row;
    private int numChairs;
    private String state;
    private String description;

    public Chair(char row, int numChairs){
        this.row = row;
        this.numChairs = numChairs;
        this.state = "OPERATIVE";
    }

    public void setDescription(String description){
        this.description = description;
    }
    
    public String getDescription(){
        return this.description;
    }
    


    public char getRow() {
        return this.row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getNumChairs() {
        return this.numChairs;
    }

    public void setNumChairs(int numChairs) {
        this.numChairs = numChairs;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Chair row(char row) {
        this.row = row;
        return this;
    }

    public Chair numChairs(int numChairs) {
        this.numChairs = numChairs;
        return this;
    }

    public Chair state(String state) {
        this.state = state;
        return this;
    }

   

    


}