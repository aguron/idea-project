package cse110.crossfit.IDEAproject.ModelsData;

import java.sql.Date;
import java.text.DateFormat;

/*
 * weight constructor 
 */
public class weightC {
	
	int weight_id;
	Double[] weight;	
	String weight_date;

	
	// Empty constructor
    public weightC(){
 
    }
    // constructor
    public weightC(int weight_id, Double[] weight, String weight_date){
    	this.weight_id = weight_id;
    	this.weight = weight;
    	this.weight_date = weight_date;
    }
  
    
    // constructor
    public weightC(Double[] weight, String weight_date){
    	this.weight = weight;
    	this.weight_date = weight_date;
    	
    }
    
    // getting ID
    public int getWieghtID(){
        return this.weight_id;
    }
 
    // setting id
    public void setWieghtID(int id){
        this.weight_id = id;
    }
    //getting Weight
    public Double[] getWeight(){
    	return this.weight;
    }
    //setting Weight
    public void setWeight(Double[] _weight){
    	this.weight =_weight;
    }
    //get Date
    public String getWeightDate(){
    	return this.weight_date;
    }
    //setting Date
    public void setWeightDate(String weight_Date){
    	this.weight_date = weight_Date;
    }
    
    
	

}
