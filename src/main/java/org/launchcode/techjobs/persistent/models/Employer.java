package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank
    @Size(min=3,max=50)
    private String location;

    @OneToMany()
    @JoinColumn(name="employer_id")
    private List<Job> jobs = new ArrayList<>();
    // it's optional to set it as "final"


    public List<Job> getJobs() {
        return jobs;
    }

    public Employer() {
    }
    //the no-arg constructor required for Hibernate to create an object

    public Employer(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }




}
