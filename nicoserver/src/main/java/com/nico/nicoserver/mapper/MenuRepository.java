package com.nico.nicoserver.mapper;

import com.nico.nicoserver.entity.YqMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<YqMenu,String>{
   // List<YqMenu> findByDeptId(Long s);
}
