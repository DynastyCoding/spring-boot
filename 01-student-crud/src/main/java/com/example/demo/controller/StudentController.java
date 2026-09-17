package com.example.demo.controller;

import com.example.demo.dto.request.CreateStudentRequest;
import com.example.demo.dto.response.StudentResponse;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<StudentResponse> getAll(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public StudentResponse getById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/students")
    public StudentResponse create(@RequestBody CreateStudentRequest req){
        return studentService.createStudent(req);
    }

    @PutMapping("/students/{id}")
    public StudentResponse update(@PathVariable Long id,
                          @RequestBody CreateStudentRequest req){
        return studentService.updateStudent(id,req);
    }

    @DeleteMapping("/students/{id}")
    public boolean delete(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

}
