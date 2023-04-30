FROM amazoncorretto

COPY design/msttcore-fonts-2.0-3.noarch.rpm /msttcore-fonts-2.0-3.noarch.rpm
RUN rpm -Uvh msttcore-fonts-2.0-3.noarch.rpm

COPY target/snyk-csv-to-pdf-1.0-jar-with-dependencies.jar snyk-csv-to-pdf.jar
COPY design/snyk.jrxml snyk.jrxml
COPY design/snyk.jasper snyk.jasper

ENTRYPOINT ["java","-jar","/snyk-csv-to-pdf.jar"]
