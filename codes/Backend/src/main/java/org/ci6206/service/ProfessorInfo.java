package org.ci6206.service;

import org.ci6206.model.Professor;

import java.util.ArrayList;

public class ProfessorInfo {
    public ArrayList<Professor> getInfo() {
        ArrayList<Professor> professors = new ArrayList<>();
        // todo: search for all the professors from database, add them to professors

        return professors;
    }

    public Professor getInfo(String professorName) {
        // todo: Professor professor = dao.search(professorName)
        Professor professor = new Professor();

        // if found, return professor; else return null
        return professor;
    }
}
