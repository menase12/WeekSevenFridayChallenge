package com.example.demo.Entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Skills {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @NotEmpty
    @Size(min=1)
    private String skill;
    @NotNull

    @Size(min=2)
    private String rate;

    @ManyToMany()
    private Set<Resume> candidate;

    public Skills() {

        this.candidate= new HashSet<> (  );
    }

    public void addSkill(Resume addresume)
    {
        candidate.add ( addresume );
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getRate() {
        return rate;
    }
    public void setRate(String rate) {
        this.rate = rate;
    }
    ////////////////////////////////////////////////////////////////////////

    public Set<Resume> getCandidate() {
        return candidate;
    }

    public void setCandidate(Set<Resume> candidate) {
        this.candidate = candidate;
    }

    ////////////////////////////////////////////////////////////////////////
}
