package com.nico.nicoserver.mapper;

import com.nico.nicoserver.entity.YqUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @ClassName UserRepository
 * @Description TODO
 * @Date 2019/1/2 0002 16:57
 */
public interface UserRepository extends JpaRepository<YqUser,String> {

    List<YqUser> findAllByUserId(Long id);
    /**
     * 1）update或delete时必须使用@Modifying对方法进行注解，才能使得ORM知道现在要执行的是写操作
     * 2）有时候不加@Param注解参数，可能会报如下异常
     */
    //@Modifying
   // @Query("update YqUser sc set sc.deleted = true where sc.userId in :ids")
   // void deleteByIds(@Param(value = "ids") List<String> ids);

}
