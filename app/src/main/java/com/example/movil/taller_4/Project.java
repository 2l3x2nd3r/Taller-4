package com.example.movil.taller_4;

import java.io.Serializable;

/**
 * Created by movil on 3/6/17.
 */

public class Project implements Serializable {

    private double note1;
    private double note2;
    private double note3;
    private double note4;
    private double grade;
    private String name;

    public Project(double note1, double note2, double note3, double note4, String name, double grade) {
        this.note1 = note1;
        this.note2 = note2;
        this.note3 = note3;
        this.note4 = note4;
        this.grade = grade;
        this.name = name;
    }

    public double getNote2() {
        return note2;
    }

    public void setNote2(double note2) {
        this.note2 = note2;
    }

    public double getNote1() {
        return note1;
    }

    public void setNote1(double note1) {
        this.note1 = note1;
    }

    public double getNote4() {
        return note4;
    }

    public void setNote4(double note4) {
        this.note4 = note4;
    }

    public double getNote3() {
        return note3;
    }

    public void setNote3(double note3) {
        this.note3 = note3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}