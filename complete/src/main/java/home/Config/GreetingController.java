package home.Config;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import home.Greeting;
import home.HelloMessage;

@Controller
public class GreetingController {


    @MessageMapping("/hellooo")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        System.out.print("Message sent");
        return new Greeting("Hello, " + message.getName() + "!");
    }

}
