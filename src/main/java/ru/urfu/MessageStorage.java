package ru.urfu;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aarkaev
 * @since 08.08.2016
 */
@RestController
class MessageStorage {
    private final static List<Message> _messages = new ArrayList<>();

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    void addMessage(@RequestParam(required = true) String message){
        Message msg = new Message(message);
        _messages.add(msg);
    }

    static {
        _messages.add(new Message("Моё первое сообщение"));
        _messages.add(new Message("Здесь будет новое сообщение"));
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    String renderAllMessages() {
        String messages = _messages
                .stream()
                .map(msg -> "<li>" + msg.getMessage()+ "</li>")
                .collect(Collectors.joining());

        return
                "<html>" +
                        "   <link rel=\"stylesheet\" type=\"text/css\" href=\"/twitter.css\"/>" +
                        "   <body>" +
                        "       <h1>twitter</h1>" +
                        "       This is your twitter application" +
                        "       <ul class=\"messages\">" +
                        messages +
                        "       </ul>"+
                        "   </body>" +
                        "</html>";
    }
}
