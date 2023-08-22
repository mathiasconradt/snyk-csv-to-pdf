mvn install
docker build -t snyk-csv-to-pdf .
docker tag  snyk-csv-to-pdf mathiasconradt/snyk-csv-to-pdf
docker push mathiasconradt/snyk-csv-to-pdf

