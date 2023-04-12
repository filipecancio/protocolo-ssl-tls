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


**Linux**
```bash
keytool -genkey -alias mydomain -keyalg RSA -keystore keystore.jks -keysize 2048
```
**Windows**

```bash
# ainda nao temos o codigo para windows =(
```

- Execute a classe Cliente.java
