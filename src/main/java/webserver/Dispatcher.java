package webserver;

import controller.MainController;
import controller.UserController;
import dto.ResponseMessage;
import org.slf4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class Dispatcher {
    private static final Logger log = getLogger(Dispatcher.class);

    private static final String GET_METHOD = "GET";
    private static final String SUFFIX_HTML = "html";
    private static final String POST_METHOD = "POST";
    public static final String USER_CREATE = "/user/create";
    private static final String USER_LOGIN = "/user/login";

    public static ResponseMessage dispatch(BufferedReader br) throws IOException {
        String headerFirstLine = br.readLine();

        if(headerFirstLine == null) return MainController.showDefaultMessage();

        String[] tokens = headerFirstLine.split(" ");

        // case 1 : get show html
        if(tokens[0].equals(GET_METHOD) && tokens[1].endsWith(SUFFIX_HTML)) {
            return MainController.showHtml(tokens[1]);
        }

        // case 2 : post create user
        if(tokens[0].equals(POST_METHOD) && tokens[1].equals(USER_CREATE)) {
            return UserController.create(br, headerFirstLine);
        }

        if(tokens[0].equals(POST_METHOD) && tokens[1].equals(USER_LOGIN)) {
            return UserController.login(br, headerFirstLine);
        }

        return MainController.showDefaultMessage();
    }



}
