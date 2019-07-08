package com.lxh.utils.excel;

import cn.chenhuanming.octopus.Octopus;
import cn.chenhuanming.octopus.config.Config;
import cn.chenhuanming.octopus.config.XmlConfigFactory;
import lombok.extern.slf4j.Slf4j;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcelExportExample {
    List<Address> addresses;

    /**
     * make testing data
     */
    @Before
    public void prepare() {
        addresses = new ArrayList<>();
        DataFactory df = new DataFactory();
        for (int i = 0; i < df.getNumberBetween(5, 10); i++) {
            addresses.add(new Address(df.getCity(), df.getAddress()));
        }
    }

    @Test
    public void export() throws FileNotFoundException {

        //where to export
        String rootPath = this.getClass().getClassLoader().getResource("").getPath();
        log.info("===> path:{}", rootPath + "address.xlsx");
        FileOutputStream os = new FileOutputStream(rootPath + "address.xlsx");

        //read config from address.xml
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("AddressExcel.xml");
        Config config = new XmlConfigFactory(is).getConfig();

        try {
            Octopus.writeOneSheet(os, config, "address", addresses);
        } catch (IOException e) {
            System.out.println("export failed");
        }
    }
}
