package com.solovev;

import com.solovev.repository.FrequentFlyerRepository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        String srcFileName = "FrequentFlyerForum-Profiles.json";
//        String directoryName = "src/main/java/";
//        Json2PojoGenerator generator = new Json2PojoGenerator(srcFileName,directoryName);
//        generator.generate("FrequentFlyer","com.solovev.model");

        try {
            FrequentFlyerRepository rep = new FrequentFlyerRepository(new File(srcFileName));
            System.out.println(rep.getFrequentFlyer().getForumProfiles().get(0));
            System.out.println("exp: List<ForumProfile> , got: " + rep.search("Malaga"));
            System.out.println("exp: [] , got: " + rep.search(""));
            LocalDate dateToFind = LocalDate.parse("2017-12-31", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            System.out.println("exp: List<ForumProfile> , got: " + rep.search(dateToFind));
            System.out.println("exp: [] , got: " + rep.search(LocalDate.now()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}