package com.alamine.studentmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long studentId;

    private String firstName;
    private String lastName;
    private StudyLevel studyLevel;
    private String email;
    private String address;
    private String phone;
    private String imageUrl;


    @Column(nullable = false, updatable = false)
    private String studentCode;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    // Generate the student code based on gender and a random string
    public void generateStudentCode() {
        String genderCode = gender == Gender.MALE ? "1" : "2";
        String randomString = generateRandomString(6);
        this.studentCode = "SN" + randomString + genderCode;
    }

    // Generate a random string of the specified length
    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            randomString.append(characters.charAt(randomIndex));
        }

        return randomString.toString();
    }
}
