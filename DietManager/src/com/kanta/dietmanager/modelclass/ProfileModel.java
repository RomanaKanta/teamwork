package com.kanta.dietmanager.modelclass;

public class ProfileModel {
	
	//private variables
	long id;
   
    String name = null;
    String fname = null;
    String mname = null;
    String bdate = null;
    String weight = null;
    String height = null;
    String bloodGroup = null;
    String location = null;
    String comment = null;
    
 public ProfileModel(){
    	
    }
    
    public ProfileModel(int id, String name){
    	
    	this.id = id;
    	this.name = name;
    }
    
    public ProfileModel( String mName,String mFname,String mMname,String bd,
    		String wt,String ht,String bGroup,String mLocation,String mInfo)
    {
    	  this. name = mName;
    	  this. fname = mFname;
    	  this. mname = mMname;
    	  this. bdate = bd;
    	  this.weight = wt;
    	  this. height = ht;
    	  this.bloodGroup = bGroup; 
    	  this.location = mLocation;
    	  this.comment = mInfo; 
    }
   
    public long getId() {
        return id;
      }

      public void setId(long id) {
        this.id = id;
      }
    
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public String getFName(){
        return this.fname;
    }

    public void setFName(String fname){
        this.fname = fname;
    }
    
    public String getMName(){
        return this.mname;
    }

    public void setMName(String mname){
        this.mname = mname;
    }
    
    public String getBd(){
        return this.bdate;
    }

    public void setBd(String bd){
        this.bdate = bd;
    }
    
    public String getWt(){
        return this.weight;
    }

    public void setWt(String wt){
        this.weight = wt;
    }
    
    public String getHt(){
        return this.height;
    }

    public void setHt(String ht){
        this.height = ht;
    }
    
    
    public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bGroup) {
		this.bloodGroup = bGroup;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String mlocation) {
		this.location = mlocation;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	
}
