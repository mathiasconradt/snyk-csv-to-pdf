# snyk-csv-to-pdf-report-converter

## Project Name
Snyk CVS-to-PDF Report Converter

## Description
PoC to showcase how we envision a performant pdf report generation:
- fast performing (2600 issues report: 5 seconds; 100k issues report: 34 seconds)
- proper page breaks
- page numbers
- using a report/template engine (Jasper Reports)

It takes a CSV file in (manually downloaded from Snyk New Reporting UI), and generates a PDF file based on it.

## Build
```
mvn install
```

## Usage
```
java -jar snyk-to-csv-converter-x.y-jar-with-dependencies.jar </path/to/csv/file.csv>
```

Example:
```
mvn install
java -jar target/snyk-to-csv-converter-1.0-jar-with-dependencies.jar samples/small.csv
```
