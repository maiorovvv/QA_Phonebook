package com.ait.phonebook.utils;

import com.ait.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"Peter","Kan","1234567890","Peteran@gm.com","Berlin","goalkeeper"});
        list.add(new Object[]{"Peter1","Kan","1234567891","Peterkan1@gm.com","Berlin","goalkeeper"});
        list.add(new Object[]{"Peter2","Kan","1234567892","Peterkan2@gm.com","Berlin","goalkeeper"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/contacts.csv")));

        String line = reader.readLine();
        while (line!=null) {
            String[] split = line.split(",");

            list.add(new Object[]{new Contact().setName(split[0]).setLastname(split[1]).setPhone(split[2])
                    .setEmail(split[3]).setAddress(split[4]).setDescription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
