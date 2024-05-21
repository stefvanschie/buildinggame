# Building Game <a href="https://discord.gg/5AJEGXG"><img align="right" src="https://img.shields.io/discord/389784128700153868" alt="Discord guild"></a>

*This plugin works for Minecraft version 1.19-1.20*

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
```

After doing this, you can build the project with Maven, similar to how the other modules are build.

```bash
mvn clean package
```
