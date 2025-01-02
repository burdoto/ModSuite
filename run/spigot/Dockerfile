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
COPY plugins/LibMod/* plugins/LibMod/
COPY plugins/BanMod/* plugins/BanMod/
COPY plugins/WorldMod/* plugins/WorldMod/
COPY plugins/LuckPerms/config.yml plugins/LuckPerms/config.yml

# include/exclude bot configs
COPY plugins/ChatMod/config.yml plugins/ChatMod/config.exclude.yml
COPY plugins/ChatMod/config.yml plugins/ChatMod/config.include.yml
RUN sed -i s/#include-bot#//g plugins/ChatMod/config.include.yml

# replace localhost adresses with docker hostnames
RUN sed -i "s|localhost:3306|database:3306|g" plugins/*/config*.yml
RUN sed -i "s|localhost:5672|rabbitmq:5672|g" plugins/*/config*.yml

CMD "java" "-Xmx${MAX_MEMORY:-2G}" "-jar" "paper.jar" "nogui"
