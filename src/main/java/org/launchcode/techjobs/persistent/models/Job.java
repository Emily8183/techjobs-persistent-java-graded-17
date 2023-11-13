package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity {

//    @Id
//    @GeneratedValue
//    private int id;

//    private String name;

    @ManyToOne
    private Employer employer;

    @ManyToMany
    private List<Skill> skills;

    public Job() {
    }

    public Job(Employer employer, List<Skill> skills) {
        this.employer = employer;
        this.skills = skills;
    }

    // Initialize the id and value fields.

    // Getters and setters.
    
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }



    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Employer getEmployer() {
        return employer;
    }


    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

}
