FROM marctv/minecraft-papermc-server:1.21.1
LABEL authors="burdo"
WORKDIR /data

# copy server configuration defaults
COPY eula.txt .
COPY .defaults/* .

# copy dev plugins
COPY plugins/*.jar plugins/

# copy dev configs
COPY plugins/LibMod/* plugins/LibMod/
COPY plugins/BanMod/* plugins/BanMod/
COPY plugins/ChatMod/* plugins/ChatMod/
COPY plugins/WorldMod/* plugins/WorldMod/

# replace localhost adresses with docker hostnames
RUN sed -i "s|localhost:3306|database:3306|g" plugins/*/config.yml
RUN sed -i "s|localhost:5672|rabbitmq:5672|g" plugins/*/config.yml
