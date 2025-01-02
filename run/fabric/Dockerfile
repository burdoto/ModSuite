FROM eclipse-temurin:21-jdk
LABEL authors="Kaleidox"
WORKDIR /data
STOPSIGNAL SIGINT

# copy server configuration defaults
COPY server.jar .
COPY eula.txt .
COPY .defaults/* .

# copy dev mods
COPY mods/*.jar mods/

# copy dev configs
RUN mkdir -p config/aurionchat config/luckperms
COPY config/aurionchat/aurionchat.conf config/aurionchat/
COPY config/luckperms/luckperms.conf config/luckperms/luckperms.conf

# replace localhost adresses with docker hostnames
RUN sed -i --debug "s|localhost:3306|database:3306|g" config/*/*.*
RUN sed -i --debug "s|localhost:5672|rabbitmq:5672|g" config/*/*.*

# create world dirs for volume
#RUN mkdir world world_nether world_the_end

CMD "java" "-Xmx${MAX_MEMORY:-2G}" "-jar" "server.jar" "nogui"
