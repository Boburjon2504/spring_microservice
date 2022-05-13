package com.example.departmnetsevice.service;

import com.example.departmnetsevice.dto.ApiResponse;
import com.example.departmnetsevice.entity.Department;
import com.example.departmnetsevice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public ApiResponse save(Department department) {
        departmentRepository.save(department);
        return ApiResponse.builder().message("Saved").success(true).build();
    }
}

