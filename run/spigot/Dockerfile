FROM marctv/minecraft-papermc-server:1.21.1
LABEL authors="Kaleidox"
WORKDIR /data

# copy server configuration defaults
COPY eula.txt .
COPY .defaults/* .

# copy dev plugins
COPY plugins/*.jar plugins/

# copy dev configs
COPY plugins/LibMod/* plugins/LibMod/
COPY plugins/BanMod/* plugins/BanMod/
COPY plugins/WorldMod/* plugins/WorldMod/

# include/exclude bot configs
COPY plugins/ChatMod/config.yml plugins/ChatMod/config.exclude.yml
COPY plugins/ChatMod/config.yml plugins/ChatMod/config.include.yml
RUN sed -i s/#include-bot#//g plugins/ChatMod/config.include.yml

# replace localhost adresses with docker hostnames
RUN sed -i "s|localhost:3306|database:3306|g" plugins/*/config*.yml
RUN sed -i "s|localhost:5672|rabbitmq:5672|g" plugins/*/config*.yml

# create world dirs for volume
#RUN mkdir world world_nether world_the_end
