# snyk-csv-to-pdf-report-converter
Snyk CVS-to-PDF Report Converter

@Sebastian Roth and I worked on a PoC to showcase how we envision a performant pdf report generation:
- fast performing (2600 issues report: 5 seconds; 100k issues report: 34 seconds)
- proper page breaks
- page numbers
- using a report/template engine (Jasper Reports)

It takes a CSV file in (downloaded from Snyk New Reporting UI), and generates a PDF file.

Build:
mvn install

Usage:
java -jar SnykJasperReport-X.Y-jar-with-dependencies.jar </path/to/csv/file.csv>

Example:
mvn install
java -jar target/SnykJasperReport-1.0-SNAPSHOT-jar-with-dependencies.jar samples/small.csv
