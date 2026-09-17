package com.example.demo.service;

import com.example.demo.dto.request.CreateStudentRequest;
import com.example.demo.dto.response.StudentResponse;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository ;
    }

    public List<StudentResponse> getAllStudents(){

        return studentRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public StudentResponse getStudentById(Long id){
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) return null;
        return toResponse(student);
    }

    public StudentResponse createStudent(CreateStudentRequest req){
        Student student = new Student();
        student.setName(req.getName());
        student.setEmail(req.getEmail());

        Student saved = studentRepository.save(student);
        return toResponse(saved);
    }

    public StudentResponse updateStudent(Long id, CreateStudentRequest req){
        Student existing = studentRepository.findById(id).orElse(null);
        if(existing == null) return null;

        existing.setName(req.getName());
        existing.setEmail(req.getEmail());

        Student saved = studentRepository.save(existing);
        return toResponse(saved);
    }

    public boolean deleteStudent(Long id){
        if(!studentRepository.existsById(id)){
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }

    private  StudentResponse toResponse(Student student){
        StudentResponse res = new StudentResponse();
        res.setId(student.getId());
        res.setName(student.getName());
        res.setEmail(student.getEmail());
        return res;
    }

}
