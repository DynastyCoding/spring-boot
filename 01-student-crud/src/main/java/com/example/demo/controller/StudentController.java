package com.example.demo.controller;

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
    public List<Student> getAll(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/students")
    public Student create(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @PutMapping("/students/{id}")
    public Student update(@PathVariable Long id,
                          @RequestBody Student student){
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("/students/{id}")
    public boolean delete(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

}
