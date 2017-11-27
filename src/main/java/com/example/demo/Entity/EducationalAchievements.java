package com.example.demo.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class EducationalAchievements {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull

    @Size(min=4)
    private String eduType;
    @NotNull

    @Size(min=4)
    private String uniName;
    @NotNull
    private int grdYear;

    @ManyToMany()
    private Set<Resume> candidate;

    public EducationalAchievements() {

        this.candidate= new HashSet<> (  );
    }

    public void addResume(Resume addresume)
    {
        candidate.add ( addresume );
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEduType() {return eduType;   }

    public void setEduType(String eduType) {
        this.eduType = eduType;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public int getGrdYear() {
        return grdYear;
    }

    public void setGrdYear(int grdYear) {
        this.grdYear = grdYear;
    }
    /////////////////////////////////////////////////////////////////////////

    public Set<Resume> getCandidate() {
        return candidate;
    }

    public void setCandidate(Set<Resume> candidate) {
        this.candidate = candidate;
    }

    /////////////////////////////////////////////////////////////////////////
}
