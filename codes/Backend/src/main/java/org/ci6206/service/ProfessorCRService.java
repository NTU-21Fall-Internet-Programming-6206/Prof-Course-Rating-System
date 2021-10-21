package org.ci6206.service;

import org.ci6206.dbAPI.ProfessorCRDBAO;
import org.ci6206.model.ProfessorCR;

import java.util.List;

public class ProfessorCRService {
    public static ProfessorCR create(String professorName, String username, int rating, String comment) throws Exception {
        ProfessorCR professorCR = new ProfessorCR(professorName, username, rating, comment);
        ProfessorCRDBAO con = new ProfessorCRDBAO();
        con.addProfessorCR(professorCR);
        return professorCR;
    }

    public static List<ProfessorCR> getInfo(String professorName) throws Exception {
        ProfessorCRDBAO con = new ProfessorCRDBAO();
        return con.findProfessorCRWithProfessorName(professorName);
    }

    public static void remove(String professorName, String username) throws Exception {
        ProfessorCRDBAO con = new ProfessorCRDBAO();
        con.deleteProfessorCRWithProfessorNameAndUsername(professorName, username);
    }
}
