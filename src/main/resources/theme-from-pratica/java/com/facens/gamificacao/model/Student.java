package com.facens.gamificacao.model;

public class Student {
    private Integer id;
    private String name;
    private int commentsCount;      
    private int availableCourses;   

    public Student(Integer id, String name, int commentsCount, int availableCourses) {
        this.id = id;
        this.name = name;
        this.commentsCount = commentsCount;
        this.availableCourses = availableCourses;
    }

    // getters e setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCommentsCount() { return commentsCount; }
    public void setCommentsCount(int commentsCount) { this.commentsCount = commentsCount; }

    public int getAvailableCourses() { return availableCourses; }
    public void setAvailableCourses(int availableCourses) { this.availableCourses = availableCourses; }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' +
               ", commentsCount=" + commentsCount +
               ", availableCourses=" + availableCourses + '}';
    }
}
