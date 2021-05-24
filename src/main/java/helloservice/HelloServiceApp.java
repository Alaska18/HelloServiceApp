package helloservice;

import com.slack.api.bolt.App;
import com.slack.api.bolt.context.builtin.SlashCommandContext;
import com.slack.api.bolt.handler.builtin.SlashCommandHandler;
import com.slack.api.bolt.jetty.SlackAppServer;
import com.slack.api.bolt.request.builtin.SlashCommandRequest;
import com.slack.api.bolt.response.Response;
import com.slack.api.methods.SlackApiException;

import java.io.IOException;


public class HelloServiceApp
{
    public static void main(String[] args)
        {
            App app = new App();
          //  AppSlashCommandHandler appSlashCommandHandler = new AppSlashCommandHandler();
            app.command("/hi", new SlashCommandHandler() {
                @Override
                public Response apply(SlashCommandRequest slashCommandRequest, SlashCommandContext context) throws IOException, SlackApiException {
                    return context.ack("Hey!");
                }
            });
            SlackAppServer server = new SlackAppServer(app, System.getenv("PORT"));
            try {
                server.start();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



    }
