# Chat Grupal en Java

Este proyecto es una implementación de un chat grupal básico utilizando sockets en Java. Permite a múltiples usuarios conectarse a un servidor centralizado y enviar mensajes entre sí en tiempo real.

## Estructura del Proyecto

El proyecto se divide en varias partes:

- `src/client`: Contiene `ClientApp.java` y `ListenerThread.java` que implementan la lógica del cliente.
- `src/server`: Contiene `ServerApp.java` y `ClientHandler.java` que implementan la lógica del servidor.
- `src/common`: Contiene clases comunes utilizadas tanto por el cliente como por el servidor, como `Constants.java` y `Utils.java`.
- `src/ui`: Contiene `ChatWindow.java`, que es una interfaz gráfica opcional para el cliente.

## Características

- Conexión de múltiples clientes al servidor de chat.
- Envío y recepción de mensajes en tiempo real.
- Interfaz de usuario basada en texto (con opción de interfaz gráfica).
- Manejo básico de errores y desconexiones.

## Cómo Ejecutar

### Servidor

1. Abre el archivo `ServerApp.java` en el paquete `server`.
2. Haz clic en el botón de ejecución en VS Code o ejecuta el servidor manualmente desde la terminal:

   ```bash
   javac -d . src/server/*.java src/common/*.java
   java server.ServerApp

### Cliente
1. Abre el archivo ClientApp.java en el paquete client.
2. Haz clic en el botón de ejecución en VS Code o ejecuta el cliente manualmente desde la terminal:

    - javac -d . src/client/*.java src/common/*.java
    - java client.ClientApp

Repite este paso para cada cliente que desees conectar.

## Funcionamiento

Inicio de la Conexión: Cuando un cliente se conecta, debe enviar su nombre de usuario al servidor y recibirá un mensaje de bienvenida.
Uso del Chat: Los clientes pueden enviar mensajes al chat, que serán retransmitidos por el servidor a todos los usuarios conectados.
Finalización de la Conexión: Escribir bye cerrará la conexión del cliente con el servidor y notificará a los otros usuarios.

