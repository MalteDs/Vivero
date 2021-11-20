package model;
//StringTokenizer
public class Vivero{
    //Attributes
    private String name;
    private String direction; 
    //Relations
    private Plant[][] plants;
    public Vivero(String name,String direction){
        this.name=name;
        this.direction=direction;
        this.plants= new Plant[12][6];
    }

    public String addPlantFrutal(String name, double cost,String nameFruit){
        String message="The nursery is full :c ";
        boolean exists=plantVerify(name);
        if (exists==false) {
        	for(int i=0;i<6;i++){
        		for(int j=0;j<6;j++){
	                if(plants[i][j]==null){
	                    plants[i][j]= new Frutal(name,cost,nameFruit);
	                    message="Fruit plant succefull created";
	                }
        		}
        	}
        }
        if(exists==true)
        	message="The name plant isn't unique";
        return message;
    }
    
    public String addPlantOrnamental(String name, int cost, int height){
        String message="";
        boolean exists=plantVerify(name);
        if (exists==false) {
			for(int i=6;i<12;i++){
				for(int j=0;j<6;j++){
					if(plants[i][j]==null){
						plants[i][j]= new Ornamental(name,cost,height);
						message="Fruit plant succefull created";
					}
				}
			}
		}
        if(exists==true)
        	message="The name plant isn't unique";
        
        return message;
    }
    
    public boolean plantVerify(String name){
		boolean exists=false;
		for(int i=0;i<12;i++){
			for (int j = 0; j < 6; j++) {
				if(plants[i][j]!=null && name==plants[i][j].getName())
				exists=true;
			}
		}
		return exists;
	}
    
    public String showOrnamental() {
    	String message="";
    	 for(int i=6;i<12;i++){
    		 for(int j=0;j<6;j++){
    			 if (plants[i][j]!=null) {
    				 //((Ornamental)(plants[i][j])).toString();
					if (plants[i][j] instanceof Ornamental && ((Ornamental)(plants[i][j])).getHeight()>1) 
						message+=plants[i][j].getName()+" "+((Ornamental) (plants[i][j])).getHeight()+" meters \n";
				}
    		 }
    	 }
		return message;
    	
    }
    
    public String nextFlowering(String search, int monthSowing, int yearSowing) {
    	String message="The plant no exists";
    	for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if(plants[i][j]!=null && plants[i][j] instanceof Frutal) {
					if((plants[i][j].getName().equalsIgnoreCase(search)))
						message=""+((Frutal) (plants[i][j])).nextFlowering(monthSowing,yearSowing);
				}
						
			}
		}
    	return message;
    }
}
