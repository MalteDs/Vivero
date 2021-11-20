package model;
public class Frutal extends Plant implements Flowering{
    //Attributes
    private String nameFruit;

    //Relations

    public Frutal(String name, double cost, String nameFruit) {
		super(name, cost);
		this.nameFruit = nameFruit;
	}

	public String getNameFruit(){
        return nameFruit;
    }

	public String nextFlowering(int monthSowing, int yearSowing){
		String message="";
		int flowering=monthSowing+8;
		int yearFlowering=yearSowing;
		if (flowering>12) {
			flowering=flowering-12;
			yearFlowering++;
		}
		message="next flowering is: "+flowering+"/"+yearFlowering;
		return message;
	}

    
}