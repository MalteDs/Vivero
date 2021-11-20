package model;
public class Ornamental extends Plant{
    //Attributes
    private double height;

    //Relations

    public Ornamental(String name, double cost, double height) {
        super(name, cost);
        this.height=height;
    }

    public double getHeight(){
        return height;
    }

    public void setHeight(double height){
        this.height=height;
    }

    public String toString(){
        String message="";
        if(getHeight()>1)
            message+=super.getName()+" "+getHeight()+"\n";
        return message;
    }
}