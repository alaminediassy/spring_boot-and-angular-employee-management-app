package com.alamine.studentmanagement.service;

import com.alamine.studentmanagement.model.Student;

import java.util.List;

public interface StudentService {

    // Create operation
    Student saveStudent(Student student);

    // Read operation all student
    List<Student> fetchStudentList();

    // Read operation student by id
    Student findStudentById(Long studentId);


    Student updateStudent(Student student, Long studentId);

    // Delete operation
    void deleteStudent(Long studentId);
}
