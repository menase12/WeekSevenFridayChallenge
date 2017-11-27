package com.example.demo.Repository;
import com.example.demo.Entity.Resume;
import com.example.demo.Entity.Skills;
import org.springframework.data.repository.CrudRepository;

public interface SkillsRepository extends CrudRepository<Skills,Long> {
    Iterable<Resume> findBySkill(String skill);
    Iterable<Resume> findByRate(String rate);
//    Iterable<Resume> findByEduType(String eduType);

}