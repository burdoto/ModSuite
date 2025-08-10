#!/usr/bin/bash

git pull origin main
(cd japi && git pull origin main)
(cd LibMod && git pull origin main)
(cd BanMod && git pull origin main)
(cd WorldMod && git pull origin main)
(cd ChatMod && git pull origin main)
(cd ChatMod/thirdparty/AurionChat && git pull origin patch-1)
