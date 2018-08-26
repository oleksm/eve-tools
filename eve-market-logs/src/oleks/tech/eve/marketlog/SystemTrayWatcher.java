package oleks.tech.eve.marketlog;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.util.Properties;
import javax.swing.JOptionPane;

public class SystemTrayWatcher {

    //start of main method
    public static void main(String[] args) {

        Properties properties = new Properties();
        try {
            properties.load(new FileReader("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        File marketLogsDir = new File(properties.getProperty("marketlogsdir"));
        if (!marketLogsDir.isDirectory()) {
            throw new RuntimeException(properties.getProperty("marketlogsdir") + " is not an eve market logs directory");
        }
        String endpointUrl = properties.getProperty("endpoint");
        if (endpointUrl == null) {
            throw new RuntimeException(properties.getProperty("endpoint") + " is not a valid service endpoint");
        }

        //checking for support
        if (!SystemTray.isSupported()) {
            System.out.println("System tray is not supported !!! ");
            return;
        }
        SystemTray systemTray = SystemTray.getSystemTray();

        Image image = Toolkit.getDefaultToolkit().getImage("7_64_2.png");

        //popupmenu
        PopupMenu trayPopupMenu = new PopupMenu();

        MenuItem action = new MenuItem("Action");
        MenuItem close = new MenuItem("Close");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        trayPopupMenu.add(close);

        TrayIcon trayIcon = new TrayIcon(image, "Start by exporting market logs in EVE client", trayPopupMenu);
        //adjust to default size as per system recommendation
        trayIcon.setImageAutoSize(true);

        try {
            systemTray.add(trayIcon);
        } catch (AWTException awtException) {
            awtException.printStackTrace();
        }

        int total = 0;

        while (true) {
            String lastUpdated = null;
            File[] logs = marketLogsDir.listFiles();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (File log : logs) {
                try {
                    String text = new String(Files.readAllBytes(log.toPath()));
                    sendLogData(text, endpointUrl);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                lastUpdated = log.getName();
                log.delete();
                ++total;
            }
            if (lastUpdated != null) {
                trayIcon.setToolTip("Last updated log: " + lastUpdated + "\nTotal logs updated: " + total);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }//end of main


    public static void sendLogData(String data, String endpoint) throws IOException {
        String encodedData = "market_log_content=" + URLEncoder.encode(data, "UTF-8");
        URL u = new URL(endpoint);
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Length", String.valueOf(encodedData.length()));
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setConnectTimeout(2000);
        conn.setReadTimeout(10000);
        conn.setDoOutput(true);
        conn.setUseCaches(false);
        conn.setAllowUserInteraction(false);
        OutputStream os = conn.getOutputStream();
        try {
            os.write(encodedData.getBytes());
        } finally {
            os.close();
        }
        int status = conn.getResponseCode();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        try {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
                String response = sb.toString();
                if (status != 200) {
                    throw new RuntimeException("Response status was not successful: " + status + ",\nResponse: " + response);
                }
                System.out.println(response);
            }
        } finally {
            br.close();
        }

    }

}