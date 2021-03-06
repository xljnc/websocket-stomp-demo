package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/holy")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
       return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @MessageMapping("/hello/{user}")
    public void greeting(@DestinationVariable("user") String user, HelloMessage message) throws Exception {
        simpMessagingTemplate.convertAndSend("/topic/greetings/"+user,new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!"));
    }



}
