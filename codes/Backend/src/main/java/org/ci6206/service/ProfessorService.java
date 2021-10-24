package org.ci6206.service;

import org.ci6206.dbAPI.ProfessorDBAO;
import org.ci6206.model.Professor;

import java.util.List;

public class ProfessorService {
    public static List<Professor> getAllProfessor() throws Exception {
        ProfessorDBAO con = new ProfessorDBAO();
        return con.findAllProfessor();
    }

    public static Professor getProfessorWithProfessorName(String professorName) throws Exception {
        ProfessorDBAO con = new ProfessorDBAO();
        return con.findProfessorWithProfessorName(professorName);
    }
}
