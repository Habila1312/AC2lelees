package com.facens.gamificacao.service;

import com.facens.gamificacao.model.Student;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class RewardService {

    public void processMonthEnd(List<Student> students) {
        if (students == null || students.isEmpty()) {
            return;
        }


        students.stream()
                .max(Comparator.comparingInt(Student::getCommentsCount))
                .ifPresent(topStudent -> topStudent.setAvailableCourses(topStudent.getAvailableCourses() + 1));
    }
}

//        Optional<Student> topStudent = students.stream()
//                .max(Comparator.comparingInt(Student::getCommentsCount));
//
//        topStudent.ifPresent(student -> {
//            int currentCourses = student.getAvailableCourses();
//            student.setAvailableCourses(currentCourses + 1);
//        });
//    }
//}
