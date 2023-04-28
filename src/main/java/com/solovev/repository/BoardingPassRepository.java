package com.solovev.repository;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.solovev.model.BoardingPass;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
Class to read boarding passes from csv file and store them
 */
public class BoardingPassRepository {
    private List<BoardingPass> boardingPasses;
    /**
     * Schema used to parse this csv
     */
    private CsvSchema schema = CsvSchema.emptySchema()
            .withColumnSeparator(';')
            .withHeader()
            .withSkipFirstDataRow(true);
    /**
     * CSV mapper with this schema
     */
    private ObjectReader objectReader = new CsvMapper()
            .findAndRegisterModules()
            .readerFor(BoardingPass.class)
            .with(schema);

    /**
     * Constructor that reads boarding pass from cvs file
     *
     * @param file - path to the file
     * @throws IOException in case smth wrong with the file
     */
    public BoardingPassRepository(File file) throws IOException {
        MappingIterator<BoardingPass> userMappingIterator = objectReader.readValues(file);
        boardingPasses = userMappingIterator.readAll();
    }

    /**
     * Method to save data from the object to yhe given file in JSON format
     *
     * @param file - file to save data
     * @throws IOException in case problems with a file
     */
    public void saveData(File file) throws IOException {
        new ObjectMapper()
                .findAndRegisterModules()
                .writeValue(file, boardingPasses);

    }
}
