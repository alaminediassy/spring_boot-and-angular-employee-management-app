package com.alamine.studentmanagement.service;

import com.alamine.studentmanagement.exception.UseNotFoundException;
import com.alamine.studentmanagement.model.Student;
import com.alamine.studentmanagement.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        student.generateStudentCode();
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new UseNotFoundException(
                "User by id " + studentId + "was not found"
        ));
    }

    @Override
    public Student updateStudent(Student student, Long studentId) {
        Student stuDB = studentRepository.findById(studentId).get();
        if (Objects.nonNull(student.getFirstName()) && !"".equals(student.getFirstName())) {
            stuDB.setFirstName(student.getFirstName());
        }
        if (Objects.nonNull(student.getLastName()) && !"".equals(student.getLastName())) {
            stuDB.setLastName(student.getLastName());
        }
        if (Objects.nonNull(student.getStudyLevel())) {
            stuDB.setStudyLevel(student.getStudyLevel());
        }
        if (Objects.nonNull(student.getEmail()) && !"".equals(student.getEmail())) {
            stuDB.setEmail(student.getEmail());
        }
        if (Objects.nonNull(student.getAddress()) && !"".equals(student.getAddress())) {
            stuDB.setAddress(student.getAddress());
        }
        if (Objects.nonNull(student.getPhone()) && !"".equals(student.getPhone())) {
            stuDB.setPhone(student.getPhone());
        }
        if (Objects.nonNull(student.getImageUrl()) && !"".equals(student.getImageUrl())) {
            stuDB.setImageUrl(student.getImageUrl());
        }
        if (Objects.nonNull(student.getStudentCode()) && !"".equals(student.getStudentCode())) {
            stuDB.setStudentCode(student.getStudentCode());
        }
        if (Objects.nonNull(student.getGender())) {
            stuDB.setGender(student.getGender());
        }
        return studentRepository.save(stuDB);
    }

    @Override
    public void deleteStudent(Long studentId) {
         studentRepository.deleteById(studentId);

    }
}
