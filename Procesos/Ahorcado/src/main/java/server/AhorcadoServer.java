package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AhorcadoServer {
    private static final int PORT = 12345;
    private static final int MAX_CLIENTS = 3;
    private final List<ClientHandler> clients = new ArrayList<>();
    private String secretWord;
    private StringBuilder currentWordState;
    private int lives = 6;

    public static void main(String[] args) throws IOException {
        new AhorcadoServer().startServer();
    }

    public void startServer() throws IOException {
        // Selecciona una palabra aleatoria antes de iniciar el servidor
        secretWord = getRandomWord();
        currentWordState = new StringBuilder("_".repeat(secretWord.length()));

        System.out.println("Palabra secreta seleccionada: " + secretWord);

        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Servidor iniciado en el puerto " + PORT);

        ExecutorService pool = Executors.newFixedThreadPool(MAX_CLIENTS);

        while (clients.size() < MAX_CLIENTS) {
            Socket socket = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(socket);
            clients.add(clientHandler);
            pool.execute(clientHandler);
        }

        serverSocket.close();
    }

    private String getRandomWord() {
        // Lista de palabras posibles
    	String[] words = {
    		    "ABISMO", "ACENTO", "ACTOR", "AGUA", "ALMENDRA", "ALTURA", "AMOR", "ANCLA", "ANIMAL", "ANZUELO",
    		    "APAGAR", "ARBOL", "ARCO", "ARENA", "ARMARIO", "ARMONIA", "ASTRONAUTA", "AVENTURA", "AVION", "AZUCAR",
    		    "BALCON", "BALON", "BANDA", "BARCO", "BARRIL", "BASURA", "BATERIA", "BIBLIOTECA", "BICICLETA", "BOCINA",
    		    "BOSQUE", "BOTELLA", "BRAZO", "BURBUJA", "CABALLO", "CABEZA", "CACTUS", "CADENA", "CALABAZA", "CALENDARIO",
    		    "CALOR", "CAMARA", "CAMELLO", "CAMINO", "CANGREJO", "CANTAR", "CARACOL", "CARBON", "CARRO", "CASCO",
    		    "CASTILLO", "CEREZA", "CIELO", "CINCO", "CINTA", "CLIMA", "COBRA", "COLINA", "COMETA", "CONEJO",
    		    "CONVERSAR", "COPA", "CORAZON", "CORONA", "CORTAR", "COSTA", "CRAYON", "CRECER", "CUADERNO", "CUCHARA",
    		    "CUERDA", "CUERPO", "CUNA", "CURVA", "DADO", "DIBUJO", "DIENTE", "DINERO", "DOLOR", "DUCHA",
    		    "ECLIPSE", "ELEFANTE", "EMOCION", "ENANO", "ENERGIA", "ESCALERA", "ESCRITORIO", "ESCUELA", "ESPADA", "ESTRELLA",
    		    "ESTUDIO", "EXPLORAR", "FABRICA", "FARO", "FELIZ", "FIESTA", "FLAUTA", "FLOR", "FUEGO", "FUTURO"
    		};

        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    private class ClientHandler implements Runnable {
        private final Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                out.println("Conectado al juego del ahorcado");
                out.println("Palabra: " + currentWordState);

                String letter;
                while ((letter = in.readLine()) != null) {
                    synchronized (AhorcadoServer.this) {
                        if (secretWord.contains(letter)) {
                            updateWordState(letter);
                            broadcast("Correcto! Palabra: " + currentWordState);
                        } else {
                            lives--;
                            broadcast("Incorrecto. Vidas restantes: " + lives);
                        }

                        if (lives <= 0) {
                            broadcast("¡Juego terminado! La palabra era: " + secretWord);
                            break;
                        }

                        if (currentWordState.toString().equals(secretWord)) {
                            broadcast("¡Felicidades! Has ganado.");
                            break;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void updateWordState(String letter) {
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == letter.charAt(0)) {
                    currentWordState.setCharAt(i, letter.charAt(0));
                }
            }
        }

        private void broadcast(String message) {
            for (ClientHandler client : clients) {
                client.out.println(message);
            }
        }
    }
}
