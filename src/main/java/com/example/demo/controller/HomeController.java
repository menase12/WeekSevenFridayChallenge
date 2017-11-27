package com.example.demo.controller;

import com.example.demo.Entity.EducationalAchievements;
import com.example.demo.Entity.Resume;
import com.example.demo.Entity.Skills;
import com.example.demo.Entity.WorkExperiences;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HomeController {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ResumeRepository resumeRepository;
    @Autowired
    EduAchievementsRepostory eduAchievementsRepostory;
    @Autowired
    WorkExperiencesRepository workExperiencesRepository;
    @Autowired
    SkillsRepository skillsRepository;
    @GetMapping("/")
    public String showHomePages() {
        return "index";
    }
    @GetMapping("/homePage")
    public String showHomePage() {
        return "index";
    }

//User Info
    @GetMapping("/addUser")
    public String addUserInfo(Model model) {
        model.addAttribute("newUser", new Resume ());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUserInfo(@Valid @ModelAttribute("newUser") Resume resume, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "addUser";
        }

        resumeRepository.save(resume);
        return "displayUserInfo";
    }
    @RequestMapping("/updateUserInfo/{id}")
    public String updateUserInfo(@PathVariable("id") long id, Model model){
        model.addAttribute("newUser", resumeRepository.findOne(id));
        return "addUser";
    }

    @RequestMapping("/deleteUserInfo/{id}")
    public String delUserInfo(@PathVariable("id") long id){
        eduAchievementsRepostory.delete(id);
        return "redirect:/listUserInfo";
    }
    @RequestMapping("/listUserInfo")
    public String listUserInfo(Model model){
        model.addAttribute("searchUser", resumeRepository.findAll());
        return "listUserInfo";
    }
//Educational Information
    @GetMapping("/addEducationalInfo")
    public String addEducationInfo(Model model) {
        model.addAttribute("newEducationalInfo", new EducationalAchievements ());
        return "addEducationalInfo";
    }
    @PostMapping("/addEducatinalInfo")
    public String addEducationInfo(@Valid @ModelAttribute("newEduInfo") EducationalAchievements educationalAchievements, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addEducationalInfo";
        }

        eduAchievementsRepostory.save(educationalAchievements);
        return "dispEduInfo";
    }
    @RequestMapping("/updateEduInfo/{id}")
    public String updateEduInfo(@PathVariable("id") long id, Model model){
        model.addAttribute("newEduInfo", eduAchievementsRepostory.findOne(id));
        return "addEducationalInfo";
    }

    @RequestMapping("/deleteEduInfo/{id}")
    public String delEduInfo(@PathVariable("id") long id){
        eduAchievementsRepostory.delete(id);
        return "redirect:/listEducationalInfo";
    }
    @RequestMapping("/listEduInfo")
    public String listEduInfo(Model model){
        model.addAttribute("searchEdu", eduAchievementsRepostory.findAll());
        return "listEducationalInfo";
    }
    //Work Experiences
    @GetMapping("/addWorkExpInfo")
    public String addWorkExpiInfo(Model model) {
        model.addAttribute("newWork", new WorkExperiences ());
        return "addWorkExpInfo";
    }
    @PostMapping("/addWorkExpInfo")
    public String addWorkExpiInfo(@Valid @ModelAttribute("newWork") WorkExperiences workExperiences, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addWorkExperienceInfo";
        }

        workExperiencesRepository.save(workExperiences);
        return "displayWorkExperienceInfo";
    }
    @RequestMapping("/updateExpInfo/{id}")
    public String updateWorkExp(@PathVariable("id") long id, Model model){
        model.addAttribute("newWork", workExperiencesRepository.findOne(id));
        return "addWorkExperienceInfo";
    }

    @RequestMapping("/deleteExpInfo/{id}")
    public String delWorkExpInfo(@PathVariable("id") long id){
        workExperiencesRepository.delete(id);
        return "redirect:/listExperienceInfo";
    }
    @RequestMapping("/listExpInfo")
    public String listWorkExpInfo(Model model){
        model.addAttribute("searchExp", workExperiencesRepository.findAll());
        return "listExperienceInfo";
    }
    //Skills
    @GetMapping("/addSkillInfo")
    public String addSkillsInfo(Model model) {
        model.addAttribute("newSkill", new Skills ());
        return "addSkillInfo";
    }
    @PostMapping("/addSkillInfo")
    public String addSkilsInfo(@Valid @ModelAttribute("newSkill") Skills skills, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addSkillInfo";
        }

        skillsRepository.save(skills);
        return "displaySkillsInfo";
    }
    @RequestMapping("/updateSkillInfo/{id}")
    public String updateSkillInfo(@PathVariable("id") long id, Model model){
        model.addAttribute("newSkill", skillsRepository.findOne(id));
        return "addSkillInfo";
    }

    @RequestMapping("/deleteSkillInfo/{id}")
    public String delSkillInfo(@PathVariable("id") long id){
        skillsRepository.delete(id);
        return "redirect:/listSkillInfo";
    }
    @RequestMapping("/listSkillInfo")
    public String listSkillInfo(Model model){
        model.addAttribute("searchSkill", skillsRepository.findAll());
        return "listSkillInfo";
    }
    //Resume result
    @GetMapping("/ResultResumeInfo")
    public String listAllResumeInfo(Model model) {
        Resume resume= resumeRepository.findOne(new Long(1));

        ArrayList<EducationalAchievements> educationalAchievementsArrayList =(ArrayList<EducationalAchievements>)eduAchievementsRepostory.findAll();
        resume.setEduAchieve(educationalAchievementsArrayList);

        ArrayList<Skills>skillsArrayList=(ArrayList<Skills>) skillsRepository.findAll();
        resume.setSkils(skillsArrayList);

        ArrayList<WorkExperiences>workExperiencesArrayList=(ArrayList<WorkExperiences>) workExperiencesRepository.findAll();
        resume.setWorkExp(workExperiencesArrayList);

        model.addAttribute("searchUser", resume);
        model.addAttribute("searchEducation",  educationalAchievementsArrayList);
        model.addAttribute("searchSkill", skillsArrayList);
        model.addAttribute("searchWork", workExperiencesArrayList);
        return "ResultResumeInfo";

    }



}