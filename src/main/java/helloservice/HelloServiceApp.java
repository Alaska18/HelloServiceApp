package helloservice;

import com.slack.api.Slack;
import com.slack.api.bolt.App;
import com.slack.api.bolt.context.builtin.SlashCommandContext;
import com.slack.api.bolt.handler.builtin.SlashCommandHandler;
import com.slack.api.bolt.jetty.SlackAppServer;
import com.slack.api.bolt.request.builtin.SlashCommandRequest;
import com.slack.api.bolt.response.Response;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;

import java.io.IOException;

public class HelloServiceApp
{
    public static void main(String[] args) throws SlackApiException, IOException {
        String token = "xoxb-2113917763184-2090639650883-IuS55wnEr7pBO1x50zrnXyei";
        Slack slack = Slack.getInstance();
        MethodsClient methods = slack.methods(token);
        ChatPostMessageRequest request = ChatPostMessageRequest.builder().channel("#random").text(":wave: Hi there!").build();
        try
        {
            ChatPostMessageResponse response = methods.chatPostMessage(request);
            System.out.println(response);
        }
        catch (Exception e)
        {
            System.out.println("there is an error!");
        }
        App app = new App();
        AppSlashCommandHandler appSlashCommandHandler = new AppSlashCommandHandler();
        app.command("/hi", appSlashCommandHandler);
        SlackAppServer slackAppServer = new SlackAppServer(app, "/slack/events", 8080);
        try {
            slackAppServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
