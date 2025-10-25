# Building Game <a href="https://discord.gg/5AJEGXG"><img align="right" src="https://img.shields.io/discord/389784128700153868?logo=Discord&logoColor=white&label=Discord" alt="Discord guild"></a>

*This plugin works for Minecraft version 1.19-1.21*

The Building Game is a plugin in which you compete against other users by making the best building. You first vote on a theme you will base your building on. After that you get a set amount of time to make your building. After this time is up, you go through everyone's plot and vote on how good you think each person's building is. The one with the highest amount of points at the end wins.

For documentation on how to setup and configure the plugin, please see the [wiki](https://github.com/stefvanschie/buildinggame/wiki).

## Building from source
If you want to build this project from source, run the following from Git Bash:

    git clone https://github.com/stefvanschie/buildinggame.git
    cd buildinggame

Depending on which part of the code you want to build, you have to navigate to a different folder. The main plugin is located in `/buildinggame`, the BungeeCord part in `/bungeecord` and the addon in `/addon`.

### BungeeCord / Addon
To build the BungeeCord or Addon module, after navigating to the right folder, you can run the following command to build the project.

```bash
mvn clean package
```

### Building Game
To build the Building Game module, you first need to initialize the NMS versions, for the NMS modules. To do this, you'll first have to run the following commands.

```bash
mvn paper-nms:init -pl buildinggame/nms/1_19_0
mvn paper-nms:init -pl buildinggame/nms/1_19_1
mvn paper-nms:init -pl buildinggame/nms/1_19_2
mvn paper-nms:init -pl buildinggame/nms/1_19_3
mvn paper-nms:init -pl buildinggame/nms/1_19_4
mvn paper-nms:init -pl buildinggame/nms/1_20_0-1
mvn paper-nms:init -pl buildinggame/nms/1_20_2
mvn paper-nms:init -pl buildinggame/nms/1_20_3
mvn paper-nms:init -pl buildinggame/nms/1_20_4
```

Then you need to build versions 1.20.5 to 1.21 via BuildTools.

```bash
wget https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar -O BuildTools.jar

git clone https://hub.spigotmc.org/stash/scm/spigot/bukkit.git Bukkit
cd Bukkit
git checkout 304e83eb384c338546aa96eea51388e0e8407e26
cd ..

git clone https://hub.spigotmc.org/stash/scm/spigot/craftbukkit.git CraftBukkit
cd CraftBukkit
git checkout 91b1fc3f1cf89e2591367dca1fa7362fe376f289
cd ..

git clone https://hub.spigotmc.org/stash/scm/spigot/spigot.git Spigot
cd Spigot
git checkout b698b49caf14f97a717afd67e13fd7ac59f51089
cd ..

git clone https://hub.spigotmc.org/stash/scm/spigot/builddata.git BuildData
cd BuildData
git checkout a7f7c2118b877fde4cf0f32f1f730ffcdee8e9ee
cd ..

java -jar BuildTools.jar --remapped --disable-java-check --dont-update

java -jar BuildTools.jar --rev 1.20.6 --remapped --disable-java-check
java -jar BuildTools.jar --rev 1.21.1 --remapped --disable-java-check
java -jar BuildTools.jar --rev 1.21.3 --remapped --disable-java-check
java -jar BuildTools.jar --rev 1.21.4 --remapped --disable-java-check
java -jar BuildTools.jar --rev 1.21.5 --remapped --disable-java-check
java -jar BuildTools.jar --rev 1.21.8 --remapped --disable-java-check
java -jar BuildTools.jar --rev 1.21.9 --remapped --disable-java-check
```

After doing this, you can build the project with Maven, similar to how the other modules are build.

```bash
mvn clean package
```

---

NOT AN OFFICIAL MINECRAFT PRODUCT. NOT APPROVED BY OR ASSOCIATED WITH MOJANG OR MICROSOFT.
