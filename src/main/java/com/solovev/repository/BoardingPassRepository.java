package com.solovev.repository;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.solovev.model.BoardingPass;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/*
Class to read boarding passes from csv file and store them
 */
public class BoardingPassRepository {
    private Set<BoardingPass> boardingPasses = new HashSet<>();

    {
        ObjectMapper ob = new ObjectMapper();
        ob.findAndRegisterModules();
    }
    /**
     * Constructor that reads boarding pass from cvs file
     * @param file - path to the file
     * @throws IOException in case smth wrong with the file
     */
    public BoardingPassRepository(File file, CsvSchema schema) throws IOException {
        ObjectReader objectReader = new CsvMapper().readerFor(BoardingPass.class).with(schema);
        MappingIterator<BoardingPass> userMappingIterator = objectReader.readValues(file);
        System.out.println(userMappingIterator.readAll());
    }
}
