package com.example.demo.Entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Resume {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull

    @Size(min=2)
    private String firstname;
    @NotNull

    @Size(min=2)
    private String lastname;
    @NotNull
    @NotEmpty
    @Email
    private String email;

    public ArrayList<EducationalAchievements> educationalAchievements;

    private  ArrayList<WorkExperiences>  workExperiences;

    private ArrayList<Skills> skills;

    @ManyToMany(mappedBy = "candidate")
    private Set<EducationalAchievements> theMany_educationalAchievements;
    @ManyToMany(mappedBy = "candidate")
    private Set<Skills>theMany_skills;
    @ManyToMany (mappedBy = "candidate")
    private Set<WorkExperiences>theMany_workExperiences;

    public Resume() {

         theMany_educationalAchievements= new HashSet<> (  );
         theMany_skills=new HashSet<> ( );
         theMany_workExperiences=new HashSet<> ( );
    }

    public void addEducation(EducationalAchievements addeducation)
    {
        educationalAchievements.add ( addeducation );
    }
    public void addSkill(Skills addskills){
        skills.add (addskills);
    }
    public void addWorkExperience (WorkExperiences addExpereince)
    {
        workExperiences.add (addExpereince);
    }

    // here we see that the main class Resume default constructor has another
    // different classes that to make and create a 'has-a' relationship that is Composition.
    //Also we can see that access the relationship class attribute.

   /* public Resume(){
        this.eduAchieve=new EducationalAchievements();
        this.workExp=new WorkExperiences();
        this.skils=new Skills();
    }*/
   /* public String getEduType() {

        return eduAchieve.getEduType();
    }
    public String getUniName() {
        return eduAchieve.getUniName();
    }
    public int getGrdYear() {
        return eduAchieve.getGrdYear();
    }
    public String getOrgName() {
        return workExp.getOrgName();
    }
    public String getProfName() {
        return workExp.getProfName();
    }
    public String getProfLevel() {
        return workExp.getProfLevel();
    }
    public String getDuty() {
        return workExp.getDuty();
    }

    public Date getStartDate() {
        return workExp.getStartDate();
    }
    public String getSkill() {
        return skils.getSkill();
    }
    public String getRate() {
        return skils.getRate();
    }
*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {return firstname; }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<EducationalAchievements> getEduAchieve() {
        return educationalAchievements;
    }
    public void setEduAchieve(ArrayList<EducationalAchievements> eduAchieve) {
        this.educationalAchievements = educationalAchievements;
    }

    public ArrayList<WorkExperiences> getWorkExp() {
        return workExperiences;
    }

    public void setWorkExp(ArrayList<WorkExperiences> workExp) {
        this.workExperiences = workExp;
    }

    public ArrayList<Skills> getSkils() {
        return skills;
    }

    public void setSkils(ArrayList<Skills> skils) {
        this.skills = skills;
    }

    //getter and setter  for many to many start

    public Set<EducationalAchievements> getTheMany_educationalAchievements() {
        return theMany_educationalAchievements;
    }

    public void setTheMany_educationalAchievements(Set<EducationalAchievements> theMany_educationalAchievements) {
        this.theMany_educationalAchievements = theMany_educationalAchievements;
    }

    public Set<Skills> getTheMany_skills() {
        return theMany_skills;
    }

    public void setTheMany_skills(Set<Skills> theMany_skills) {
        this.theMany_skills = theMany_skills;
    }

    public Set<WorkExperiences> getTheMany_workExperiences() {
        return theMany_workExperiences;
    }

    public void setTheMany_workExperiences(Set<WorkExperiences> theMany_workExperiences) {
        this.theMany_workExperiences = theMany_workExperiences;
    }

    //getter and setter for many to many ends
}
