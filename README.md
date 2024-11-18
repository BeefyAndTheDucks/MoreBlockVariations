# More Block Variations

A Minecraft mod adding Vertical Slabs, Vertical Stairs and Corners. 

### Get the mod

Get it on [Modrinth](https://modrinth.com/mod/more-block-variations)

# Building:

Clone or download the Source Code using either the Code dropdown - Download ZIP, Using GitHub Desktop (or other Git GUI), or using the command line: 
```
git clone https://github.com/BeefyAndTheDucks/MoreBlockVariations.git
```

Then open the project using IntelliJ (Eclipse is not officially supported by us) and let it import.

Make sure the Java version is set to Java 21 in both `File | Project Structure | Project` and `File | Settings | Build, Execution, Deployment | Build Tools | Gradle`

Afterward, run the `runDatagen` Gradle task.

You should now be ready! To start the Minecraft Client, run the `runClient` Gradle Task, or to build the jar, run the `build` Gradle Task and look in `build/libs/` for the .jar file (make sure to pick the one with no suffix).

Happy modding!
