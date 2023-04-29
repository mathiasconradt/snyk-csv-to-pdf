# Second stage, add only our minimal "JRE" distr and our app
FROM amazoncorretto

#ENV JAVA_MINIMAL=/opt/jre
#ENV PATH="$PATH:$JAVA_MINIMAL/bin"

# RUN sudo yum update
# RUN yum install -y curl cabextract xorg-x11-font-utils fontconfig
RUN yum install -y wget
RUN wget http://www.itzgeek.com/msttcore-fonts-2.0-3.noarch.rpm
RUN rpm -Uvh msttcore-fonts-2.0-3.noarch.rpm
#RUN wget http://mirror.centos.org/centos/7/os/x86_64/Packages/liberation-narrow-fonts-1.07.2-16.el7.noarch.rpm
#RUN rpm -Uvh liberation-narrow-fonts-1.07.2-16.el7.noarch.rpm
# RUN rpm -Va --nofiles --nodigest https://downloads.sourceforge.net/project/mscorefonts2/rpms/msttcore-fonts-installer-2.6-1.noarch.rpm

#COPY --from=packager "$JAVA_MINIMAL" "$JAVA_MINIMAL"
COPY target/snyk-csv-to-pdf-1.0-jar-with-dependencies.jar snyk-csv-to-pdf.jar
COPY target/classes/snyk.jrxml snyk.jrxml

# VOLUME /data

ENTRYPOINT ["java","-jar","/snyk-csv-to-pdf.jar"]
# CMD [ ${INPUT} ]

#EXPOSE 8080
#CMD [ "-jar", "/app.jar" ]
#ENTRYPOINT [ "java" ]