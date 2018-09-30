#!/usr/bin/env bash

echo "Downloading dependencies with no maven repository available"

wget https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar -O BuildTools.jar && java -jar BuildTools.jar --rev 1.13.1

wget https://www.robindebaets.be/LeaderHeadsAPI.jar && mvn install:install-file -Dfile=LeaderHeadsAPI.jar -DgroupId=me.robin -DartifactId=leaderheads -Dversion=3.1.6 -Dpackaging=jar

git clone https://github.com/Gnat008/perworldinventory-kt.git && cd perworldinventory-kt && mvn clean install

cd ../

git clone https://github.com/I-Al-Istannen/MiniNBT.git && cd MiniNBT && mvn clean install