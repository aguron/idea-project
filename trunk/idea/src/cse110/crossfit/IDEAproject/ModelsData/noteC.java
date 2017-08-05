package cse110.crossfit.IDEAproject.ModelsData;

import java.sql.Date;

//note constructor 
public class noteC {
	int notes_id;
	String notes_title;
	String notes_text;
	String notes_date;
	//empty
	public noteC(){
		
	}
	public noteC(int notes_id, String notes_title, String notes_text, String notes_date ){
		this.notes_id = notes_id;
		this.notes_title = notes_title;
		this.notes_text = notes_text;
		this.notes_date = notes_date;
	}
	
	public noteC(String notes_title, String notes_text, String notes_date){
		this.notes_title = notes_title;
		this.notes_text = notes_text;
		this.notes_date = notes_date;
	}
	
	 
    // getting NotesID
    public int getNotesID(){
        return this.notes_id;
    }
 
    // setting NotesID
    public void setNotesID(int notes_id){
        this.notes_id = notes_id;
    } 
    //getting NotesTitle
    public String getNotesTitle(){
    	return this.notes_title;
    }
    //setting NotesTitle
    public void setNotesTitle(String notes_title){
    	this.notes_title = notes_title;
    }
  
  //getting NotesText
    public String getNotesText(){
    	return this.notes_text;
    }
    //setting NotesText
    public void setNotesText(String notes_text){
    	this.notes_text = notes_text;
    }
    //getting NotesDate
    public String getNotesDate(){
    	return this.notes_date;
    }
    //setting NotesDate
    public void setNotesDate(String notes_date){
    	this.notes_date = notes_date;
    }
  

}
