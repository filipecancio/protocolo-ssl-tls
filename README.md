# Seminario 01: Utilizando SSL em uma comunicacao server e client

## Pre requisitos
- Instalar o Git. [link](https://git-scm.com/)
- Instalar o JDK em sua maquina. [link](https://aws.amazon.com/pt/corretto/)
- Instalar o Wireshark na maquina. [linux](https://www.edivaldobrito.com.br/wireshark-2-0-no-ubuntu-15-10/) / [windows e mac](https://www.wireshark.org/download.html)
- Instalar o visual studio code na sua maquina. [link](https://code.visualstudio.com/)
- Instalar o pacotes de extensoes para Java. [link](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

## Executar o projeto
 A versao SEM a protecao SSL esta na branch `main` e a versao COM a procetecao esta na branch `fix-aula`

- Faca o clone do projeto
- Execute a classe Servidor.java
> Para usar o codigo na versao com ssl e necessario gerar uma keystore, e colocar uma senha semelhante ao ue esta no codigo do servidor use o seguinte comando:

```bash
#Linux
keytool -genkey -alias mydomain -keyalg RSA -keystore keystore.jks -keysize 2048

```

```bash
# Windows
# ainda nao temos o codigo para windows =(
```

- Execute a classe Cliente.java

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
