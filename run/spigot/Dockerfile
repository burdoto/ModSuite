FROM eclipse-temurin:21-jdk
LABEL authors="Kaleidox"
WORKDIR /data
STOPSIGNAL SIGINT

# copy server configuration defaults
COPY paper.jar .
COPY eula.txt .
COPY .defaults/* .

# copy dev plugins
COPY plugins/*.jar plugins/

# copy dev configs
COPY plugins/LibMod/config.yml plugins/LibMod/
COPY plugins/BanMod/config.yml plugins/BanMod/
COPY plugins/WorldMod/config.yml plugins/WorldMod/
COPY plugins/WorldMod/worlds/world.wmq plugins/WorldMod/worlds/
COPY plugins/LuckPerms/config.yml plugins/LuckPerms/config.yml

# include/exclude bot configs
RUN mkdir plugins/ChatMod
COPY plugins/ChatMod/config.yml plugins/ChatMod/config.yml
RUN sed "s/#$INCLUDE_BOT-bot#//g"

# replace localhost adresses with docker hostnames
RUN sed -i "s|localhost:3306|database:3306|g" plugins/*/config*.yml
RUN sed -i "s|localhost:5672|rabbitmq:5672|g" plugins/*/config*.yml

VOLUME /data/plugins

CMD "java" "-Xmx${MAX_MEMORY:-2G}" "-jar" "paper.jar" "nogui"
