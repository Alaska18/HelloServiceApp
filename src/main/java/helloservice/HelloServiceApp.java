package helloservice;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;

import java.io.IOException;

public class HelloServiceApp
{
    public static void main(String[] args) throws SlackApiException, IOException {
        Slack slack = Slack.getInstance();

        String token = "xoxb-2113917763184-2090639650883-9QWG6VKH1Dt8UW155AazAzgo";

        MethodsClient methods = slack.methods(token);
        ChatPostMessageRequest request = ChatPostMessageRequest.builder().channel("#random").text(":wave: Hi! there!").build();

        try
        {
            ChatPostMessageResponse response = methods.chatPostMessage(request);
            System.out.println(response);
        }
        catch (Exception e)
        {
            System.out.println("Ohoo there is an error!");
        }
    }
}
