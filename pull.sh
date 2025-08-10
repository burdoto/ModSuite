#!/usr/bin/bash

git pull
(cd japi && git pull)
(cd LibMod && git pull)
(cd BanMod && git pull)
(cd ChatMod && git pull)
(cd ChatMod/thirdparty/AurionChat && git pull)
(cd WorldMod && git pull)
