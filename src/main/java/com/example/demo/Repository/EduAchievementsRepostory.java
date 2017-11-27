package com.example.demo.Repository;



import com.example.demo.Entity.EducationalAchievements;
import com.example.demo.Entity.Resume;
import org.springframework.data.repository.CrudRepository;

public interface EduAchievementsRepostory extends CrudRepository<EducationalAchievements,Long> {
    Iterable<Resume> findBySkill(String grdYear);
    Iterable<Resume> findByUniName(String uniName);
    Iterable<Resume> findByEduType(String eduType);


    // EducationalAchievements findByEduType(String eduType);

//    EducationalAchievements findByUniName(String uniName);
//    EducationalAchievements findByGrdYear(String grdYear);
//    Long countByEduType(String eduType);
//    Long countByUniName(String uniName);
//    Long countByGrdYear(String grdYear);
}