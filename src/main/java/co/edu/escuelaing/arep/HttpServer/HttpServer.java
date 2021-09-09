package co.edu.escuelaing.arep.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import co.edu.escuelaing.arep.Calculadora.Calculadora;


/**
 * Se realizo en clase
 */
public class HttpServer {
    private static HttpServer instance = new HttpServer();

    private HttpServer() {
    }

    private static HttpServer getInstance() {
        return instance;
    }

    public static void main(String[] args) throws IOException {
        HttpServer.getInstance().startServer(args);
    }

    public void startServer(String[] args) throws IOException {
        int port = getPort();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + port);
            System.exit(1);
        }
        Socket clientSocket = null;
        boolean running = true;
        while (running) {
            try {
                System.out.println("Listo para recibir en puerto " + port);
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            processRequest(clientSocket);
        }
        serverSocket.close();
    }
    public String makeResponse(String path, String n){
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: "+"application/json"+"\r\n"
                + "\r\n"+Calculadora.getRespuesta(path,n);
    }

    public void processRequest(Socket clientSocket) throws IOException {
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        String method = "";
        String path = "";
        String version = "";
        String parametro="";
        List<String> headers = new ArrayList<String>();
        while ((inputLine = in.readLine()) != null) {

            if (method.isEmpty()) {
                try {
                    String[] requestStrings = inputLine.split(" ");
                    String[] rta = requestStrings[1].split("//");
                    method = requestStrings[0];
                    path = rta[0];
                    version = requestStrings[2];
                    parametro = rta[1].split("=")[1];
                }catch (Exception no){
                    String[] requestString = inputLine.split(" ");
                    method= requestString[0];
                    path = requestString[1];
                    version = requestString[2];
                    System.out.println("Request: "+ method + " "+path+" "+version);
                }
            } else {
                parametro="none";
                path="none";
                System.out.println("header: " + inputLine);
                headers.add(inputLine);
            }
            System.out.println("Received: " + inputLine);
            if (!in.ready()) {
                break;
            }
        }

        String responseMessage = createResponse(path,parametro);
        out.println(responseMessage);
        out.close();
        in.close();
        clientSocket.close();
    }

    public String createResponse(String path,String n){
        Path file = Paths.get("./www" + path);
        Charset charset = Charset.forName("UTF-8");
        String outmsg = "";
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                outmsg += "\r\n" + line;
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: "+"application/json"+"\r\n"
                + "\r\n"+Calculadora.getRespuesta(path,n);
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35002;
    }
}
