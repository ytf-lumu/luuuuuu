package com.nico.nicoserver.mapper;

import com.nico.nicoserver.entity.YqDept;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Administrator
 * @version 1.0.0
 * @ClassName DeptRepository
 * @Description TODO
 * @Date 2019/1/7 0007 9:52
 */
public interface DeptRepository extends JpaRepository<YqDept, String> {

    List<YqDept> findByDeptId(Long s);
    void delete(YqDept yqDept);
}
