package demo11.demo4;

import java.io.*;
import java.net.Socket;

public class servicereader extends Thread {
    private Socket socket;

    public servicereader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();

            br = new BufferedReader(new InputStreamReader(is));
            pw = new PrintWriter(os);

            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                }
                System.out.println(line);
            }

            pw.println("HTTP/1.1 200 OK");
            pw.println("Content-Type:text/html;charset=utf-8");
            pw.println();
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<meta charset='utf-8'>");
            pw.println("<title>");
            pw.println("黑马 Java 磊哥的视频");
            pw.println("</title>");
            pw.println("</head>");
            pw.println("<body>");
            pw.println("<h1 style='color:red;font-size:20px'>听黑马 Java 磊哥的视频</h1>");
            pw.println("</body>");
            pw.println("</html>");
            pw.flush();

        } catch (IOException e) {
            System.out.println("连接断开");
        } finally {
            try {
                if (br != null) br.close();
                if (pw != null) pw.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
