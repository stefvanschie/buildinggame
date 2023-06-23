# Building Game <a href="https://discord.gg/5AJEGXG"><img align="right" src="https://img.shields.io/discord/389784128700153868" alt="Discord guild"></a>

*This plugin works for Minecraft version 1.19-1.20*

The Building Game is a plugin in which you compete against other users by making the best building. You first vote on a theme you will base your building on. After that you get a set amount of time to make your building. After this time is up, you go through everyone's plot and vote on how good you think each person's building is. The one with the highest amount of points at the end wins.

For documentation on how to setup and configure the plugin, please see the [wiki](https://github.com/stefvanschie/buildinggame/wiki).

## Building from source
If you want to build this project from source, run the following from Git Bash:

    git clone https://github.com/stefvanschie/buildinggame.git
    cd buildinggame

Depending on which part of the code you want to build, you have to navigate to a different folder. The main plugin is located in `/buildinggame`, the BungeeCord part in `/bungeecord` and the addon in `/addon`. After navigating to there, you can make the plugin with Maven.

    mvn clean package

