package helloservice;

import com.slack.api.bolt.App;
import com.slack.api.bolt.jetty.SlackAppServer;


public class HelloServiceApp
{
    public static void main(String[] args)
        {
            App app = new App();
            AppSlashCommandHandler appSlashCommandHandler = new AppSlashCommandHandler();
            app.command("/hi", appSlashCommandHandler);
            /*SlackAppServer server = new SlackAppServer(app, 8080);
            try {
                server.start();
            } catch (Exception e) {
                e.printStackTrace();
            }*/

        }



    }
