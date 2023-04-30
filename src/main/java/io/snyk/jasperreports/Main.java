package io.snyk.jasperreports;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRCsvDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws JRException, FileNotFoundException {

        // disable warnings
        disableWarning();

        System.out.println("--------------------------------");
        System.out.println("Snyk CSV-to-PDF Report Converter");
        System.out.println("--------------------------------");

        // check params and required file
        if (args.length == 0) {
            System.out.println("Missing argument.");
            System.out.println("Usage:");
            System.out.println("java -jar snyk-csv-to-pdf-x.y-jar-with-dependencies.jar </path/to/csv/file.csv>");
            System.exit(1);
            System.out.println();
        } else if (!args[0].toLowerCase().endsWith(".csv")) {
            System.out.println("Only .csv format is supported.");
            System.exit(1);
            System.out.println();
        }
        File csvFile = new File(args[0]);
        if (!csvFile.exists()) {
            System.out.println("cvs file not found.");
            System.exit(1);
            System.out.println();
        }
        boolean jrxmlExists = new File("snyk.jrxml").exists();
        boolean jasperExists = new File("snyk.jasper").exists();
        if (!jrxmlExists && !jasperExists) {
            System.out.println("snyk.jasper or snyk.jrxml not found.");
            System.exit(1);
            System.out.println();
        }

        Date startTime = Calendar.getInstance().getTime();
        System.out.println("Start: " + startTime);

        // load csv file
        JRCsvDataSource jrDataSource = new JRCsvDataSource(csvFile);
        jrDataSource.setUseFirstRowAsHeader(true);

        // if .jasper exists, use the compiled report, otherwise fallback to .jrxml and compile it
        JasperReport report;
        if (jasperExists) {
            File initialFile = new File("snyk.jasper");
            InputStream targetStream = new FileInputStream(initialFile);
            report = (JasperReport) JRLoader.loadObject(targetStream);
        } else {
            report = JasperCompileManager.compileReport("snyk.jrxml");
        }

        JasperPrint print = JasperFillManager.fillReport(report, new HashMap<>(), jrDataSource);
        String outFilePath = csvFile.getAbsolutePath().toLowerCase().replace(".csv", ".pdf");
        JasperExportManager.exportReportToPdfFile(print, outFilePath);

        // show end time and duration
        Date endTime = Calendar.getInstance().getTime();
        System.out.println("Finish: " + endTime);
        System.out.println("Duration: " + ((endTime.getTime() - startTime.getTime()) / 1000) + " secs");
        System.out.println("PDF at: " + outFilePath);
        System.out.println();
    }

    /**
     * disable warnings
     */
    private static void disableWarning() {
        System.err.close();
        System.setErr(System.out);
    }
}