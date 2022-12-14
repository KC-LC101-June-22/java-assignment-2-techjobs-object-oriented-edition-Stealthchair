package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job(){
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        String returnString = "\nID: " + this.getId();
        if(this.getName() == null || this.getName() == "" ){
            returnString += "\nName: Data not available";
        } else {
            returnString += "\nName: " + this.getName();
        }

        if(this.getEmployer() == null || this.getEmployer().getValue() == ""){
            returnString += "\nEmployer: Data not available";
        } else {
            returnString += "\nEmployer: " + this.getEmployer().getValue();
        }

        if(this.getLocation() == null || this.getLocation().getValue() == ""){
            returnString += "\nLocation: Data not available";
        } else {
            returnString += "\nLocation: " + this.getLocation().getValue();
        }

        if(this.getPositionType() == null || this.getPositionType().getValue() == ""){
            returnString += "\nPosition Type: Data not available";
        } else {
            returnString += "\nPosition Type: " + this.getPositionType().getValue();
        }

        if(this.getCoreCompetency() == null || this.getCoreCompetency().getValue() == ""){
            returnString += "\nCore Competency: Data not available";
        } else {
            returnString += "\nCore Competency: " + this.getCoreCompetency().getValue();
        }

//        if(this.getName() == null && this.getEmployer() == null && this.getLocation() == null && this.getPositionType() == null && this.getCoreCompetency() == null){
//            return "OOPS! This job does not seem to exist.";
//        }


        return  returnString+ "\n";
//        return "\nID: " + this.getId() +
//                "\nName: " + this.getName() +
//                "\nEmployer: " + this.getEmployer().getValue() +
//                "\nLocation: " + this.getLocation().getValue() +
//                "\nPosition Type: " + this.getPositionType().getValue() +
//                "\nCore Competency: " + this.getCoreCompetency().getValue() +
//                "\n";
    }
}
