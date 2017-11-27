package com.example.demo.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class WorkExperiences {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull

    @Size(min=4)
    private String orgName;
    @NotNull

    @Size(min=2)
    private String profName;
    @NotNull

    @Size(min=1)
    private String ProfLevel;
    @NotNull

    @Size(min=2)
    private String duty;
    @NotNull
   // @Temporal(TemporalType.Date)
    @DateTimeFormat(pattern = "MM/dd/YYYY")
    private Date startDate;
    @NotNull
   // @Temporal(TemporalType.Date)
    @DateTimeFormat(pattern = "MM/dd/YYYY")
    private Date endDate;

    @ManyToMany()
    private Set<Resume> candidate;

    public WorkExperiences() {

        this.candidate= new HashSet<> (  );
    }

    public void addExperience(Resume addexpereience)
    {
        candidate.add (addexpereience);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public String getProfLevel() {
        return ProfLevel;
    }

    public void setProfLevel(String profLevel) {
        ProfLevel = profLevel;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    /////////////////////////////////////////////////////////////

    public Set<Resume> getCandidate() {
        return candidate;
    }

    public void setCandidate(Set<Resume> candidate) {
        this.candidate = candidate;
    }

    ////////////////////////////////////////////////////////////
}
