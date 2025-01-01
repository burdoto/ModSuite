FROM itzg/minecraft-server
LABEL authors="Kaleidox"
WORKDIR /data

# copy server configuration defaults
COPY eula.txt .
COPY .defaults/* .

# copy dev mods
COPY mods/*.jar mods/

# copy dev configs
COPY config/LibMod/* config/LibMod/
COPY config/BanMod/* config/BanMod/
COPY config/WorldMod/* config/WorldMod/

# include/exclude bot configs
#COPY mods/ChatMod/config.yml mods/ChatMod/config.exclude.yml
#COPY mods/ChatMod/config.yml mods/ChatMod/config.include.yml
#RUN sed -i s/#include-bot#//g mods/ChatMod/config.include.yml

# replace localhost adresses with docker hostnames
RUN sed -i "s|localhost:3306|database:3306|g" mods/*/*config*.yml
RUN sed -i "s|localhost:5672|rabbitmq:5672|g" mods/*/*config*.yml

# create world dirs for volume
#RUN mkdir world world_nether world_the_end
