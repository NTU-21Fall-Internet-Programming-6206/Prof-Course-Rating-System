package org.ci6206.service;

import org.ci6206.model.ProfessorCR;

import java.util.ArrayList;

public class ProfessorCRService {
    public static ProfessorCR create(String professorName, String username, int rating, String comment) {
        ProfessorCR professorCR = new ProfessorCR(professorName, username, rating, comment);
        // todo: dao.insert(professorCR)
        return professorCR;
    }

    public static ArrayList<ProfessorCR> getInfo() {
        ArrayList<ProfessorCR> professorCRs = new ArrayList<>();
        // todo: dao.search()
        return professorCRs;
    }

    public static ProfessorCR getInfo(String professorName) {
        ProfessorCR professorCR = new ProfessorCR();
        // todo: dao.search(professorName)
        return professorCR;
    }

    public static void remove(String professorName, String username) {
        // todo: dao.search(professorName, username), remove it.
    }
}
