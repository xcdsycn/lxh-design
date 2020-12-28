package com.lxh.utils.excel;

import cn.chenhuanming.octopus.Octopus;
import cn.chenhuanming.octopus.config.Config;
import cn.chenhuanming.octopus.config.XmlConfigFactory;
import cn.chenhuanming.octopus.config.annotation.AnnotationConfigFactory;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class ApplicantExample extends AbstractWriterTest {

	@Test
	public void export() throws IOException {
		String rootPath = this.getClass().getClassLoader().getResource("").getPath();
		FileOutputStream os = new FileOutputStream(rootPath + "/applicator.xlsx");

		Config config = new XmlConfigFactory(this.getClass().getClassLoader().getResourceAsStream("applicants.xml"))
				.getConfig();

		Octopus.writeOneSheet(os, config, "test", applicantsList);
	}

	@Test
	public void exportWithAnnotation() throws IOException {
		String rootPath = this.getClass().getClassLoader().getResource("").getPath();
		FileOutputStream os = new FileOutputStream(rootPath + "/applicator1.xlsx");

		Config config = new AnnotationConfigFactory(Applicants.class).getConfig();

		Octopus.writeOneSheet(os, config, "test", applicantsList);
	}

}
