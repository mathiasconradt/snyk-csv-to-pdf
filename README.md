# Snyk CVS-to-PDF Report Converter

PoC to showcase how we envision a performant pdf report generation:
- fast performing (2600 issues report: 5 seconds; 100k issues report: 34 seconds)
- proper page breaks
- page numbers
- using a report/template engine (Jasper Reports)

It takes a CSV file in (manually downloaded from Snyk New Reporting UI), and generates a PDF file based on it.

You can find two sample PDF reports under
- [/samples/small.pdf](/samples/small.pdf)
- [/samples/medium.pdf](/samples/medium.pdf)


![sample pdf](docs/small-pdf.png "Sample PDF")

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
docker build -t snyk-csv-to-pdf .
```

### Run
```
docker run -v $(PWD)/samples:/data/ snyk-csv-to-pdf /data/medium.csv
```

## Report Template Design

If you want to adjust the report template (snyk.jrxml), you can download the Jaspersoft Studio Community Edition from https://community.jaspersoft.com/project/jaspersoft-studio/releases

Open the snyk.jrxml and for testing with sample data, adjust the path to the CSV file in the data adapter (/design/DataAdapter.jrdax) to point to the right path on your local machine.
You can use /samples/small.csv as a sample CSV file.

When done editing the template, make sure to compile it to snyk.jasper

![compiling](docs/jasperstudio1.png "Compiling from .jrxml to .jasper")

## Contact

- Mathias Conradt ([@mathiasconradt](https://github.com/mathiasconradt))
- Sebastian Roth ([@ened](https://github.com/ened))