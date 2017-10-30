
##################################################
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
## Big Data Lab
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
##################################################

FROM ubuntu:trusty

#-------------------------------------
#-- Tools + Java 
#-------------------------------------
ENV JAVA_HOME=/usr/lib/jvm/java-1.7.0-openjdk-amd64

RUN apt-get update && apt-get install -y --no-install-recommends \
    openjdk-7-jdk   \
    wget  \
 && apt-get clean \
 && rm -rf /var/lib/apt/lists/*    


#-------------------------------------
#-- Apache Pig Latin 
#-------------------------------------
ENV PIG_HOME=/usr/local/apache/pig
ENV PATH=$PATH:$PIG_HOME/bin

RUN wget -q http://apache.rediris.es/pig/latest/pig-0.17.0.tar.gz \
 && tar -xf pig-*  \
 && rm pig-*.tar*   \
 && mkdir -p /usr/local/apache/  \
 && mv pig-* /usr/local/apache/pig \
 && rm -r /usr/local/apache/pig/docs

WORKDIR /root

