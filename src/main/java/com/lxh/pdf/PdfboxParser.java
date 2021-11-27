package com.lxh.pdf;

import org.apache.commons.io.output.StringBuilderWriter;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;

import java.io.File;

/**
 * @Description PDF解析器
 * @Author lxh
 * @Date 2021/11/26 17:01
 **/
@Deprecated
public class PdfboxParser {


    public static void pdfToHtml() {
        String randomCode = "aaaa";
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        PDDocument document = new PDDocument();
       try( FDFDocument fdfDocument = Loader.loadFDF(new File(""))) {

       }catch (Exception e) {
           e.printStackTrace();
       }
    }
}
