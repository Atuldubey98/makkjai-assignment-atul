
## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## How to test the project

Default location of assets directory : "/assets"
It can be changed in App.java file. The variable name is DIRECTORY_PATH.
The project was built in vscode. Place indivisual txt files in the assets directory. Now run the project using vscode by pressing F5. The outputs with the tax and grand total will be generated in the output directory of the of the folder.