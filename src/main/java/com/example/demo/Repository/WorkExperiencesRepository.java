package com.example.demo.Repository;

import com.example.demo.Entity.Resume;
import com.example.demo.Entity.WorkExperiences;
import org.springframework.data.repository.CrudRepository;

public interface WorkExperiencesRepository extends CrudRepository<WorkExperiences,Long> {
    Iterable<Resume> findByOrgName(String orgName);
    Iterable<Resume> findByProfName(String profName);
    Iterable<Resume> findByProfLevel(String profLevel);
    Iterable<Resume> findByDuty(String duty);

}
