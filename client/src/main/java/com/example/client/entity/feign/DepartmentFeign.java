package com.example.client.entity.feign;

import com.example.client.entity.entity.Department;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.Path;
import java.util.List;

@FeignClient(name = "department", url = "http://localhost:8083/")
public interface DepartmentFeign {

    //postman qiladigan ishni shu qilib beradi
    @GetMapping("department/{id}")
    Department getOneDepartment(@PathVariable Integer id);

    @GetMapping("department")
    List<Department> getAll();

}
