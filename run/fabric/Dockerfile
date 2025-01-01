FROM eclipse-temurin:21-jdk
LABEL authors="Kaleidox"
WORKDIR /data

# copy server configuration defaults
COPY eula.txt .
COPY .defaults/* .

# copy dev mods
COPY server.jar .
COPY mods/*.jar mods/
RUN mkdir -p config/aurionchat
COPY config/aurionchat/aurionchat.conf config/aurionchat/

# copy dev configs
#COPY config/LibMod/* config/LibMod/
#COPY config/BanMod/* config/BanMod/
#COPY config/WorldMod/* config/WorldMod/

# include/exclude bot configs
#COPY mods/ChatMod/config.yml mods/ChatMod/config.exclude.yml
#COPY mods/ChatMod/config.yml mods/ChatMod/config.include.yml
#RUN sed -i s/#include-bot#//g mods/ChatMod/config.include.yml

# replace localhost adresses with docker hostnames
RUN sed -i --debug "s|localhost:3306|database:3306|g" config/*/*.*
RUN sed -i --debug "s|localhost:5672|rabbitmq:5672|g" config/*/*.*

# create world dirs for volume
#RUN mkdir world world_nether world_the_end

CMD "java" "-Xmx${MAX_MEMORY:-4G}" "-jar" "server.jar" "nogui"
