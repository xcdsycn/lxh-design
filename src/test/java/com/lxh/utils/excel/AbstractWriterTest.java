package com.lxh.utils.excel;

import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class AbstractWriterTest {

    protected List<Applicants> applicantsList;

    protected Integer number = 5;

    @Before
    public void before() {
        applicantsList = new ArrayList<>();
        DataFactory df = new DataFactory();
        number = number();
        for (int i = 0; i < number; i++) {
            Applicants applicants = new Applicants();
            applicants.setId(df.getNumberBetween(0, 100));
            applicants.setName(df.getName());
            Address address = new Address(df.getCity(), df.getAddress());
            Company company = new Company(df.getBusinessName(), address);
            applicants.setJob(new Job(company, df.getRandomWord(), df.getRandomWord()));
            applicants.setEntryDate(df.getBirthDate());
            applicants.setWorking((i & 1) == 0);
            applicantsList.add(applicants);

        }
    }

    protected int number() {
        return 5;
    }
}
