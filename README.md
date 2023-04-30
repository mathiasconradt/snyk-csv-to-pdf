# Snyk CVS-to-PDF Report Converter

PoC to showcase how we envision a performant pdf report generation:
- fast performing (2600 issues report: 5 seconds; 100k issues report: 34 seconds)
- proper page breaks
- page numbers
- using a report/template engine (Jasper Reports)

It takes a CSV file in (manually downloaded from Snyk New Reporting UI), and generates a PDF file based on it.

### Disclaimer

This project is not an official Snyk offering and not officially supported by Snyk.
Use are your own risk.

## Build
```
mvn install
```

## Usage
```
java -jar snyk-csv-to-pdf-x.y-jar-with-dependencies.jar </path/to/csv/file.csv>
```

Make sure that either the report template snyk.jrxml or snyk.jasper (compiled report) exists in the current directory.

Example:
```
mvn install
cd design
java -jar ../target/snyk-csv-to-pdf-1.0-jar-with-dependencies.jar ../samples/small.csv
```

## Docker

### Build
```
mvn install
docker build -t snyk-csv-to-pdf-converter .
```

### Run
```
docker run -v $(PWD)/samples:/data/ snyk-csv-to-pdf-converter /data/medium.csv
```

## Contact

- Mathias Conradt (@mathiasconradt)
- Sebastian Roth (@ened)