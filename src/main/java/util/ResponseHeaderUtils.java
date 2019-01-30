package util;

public class ResponseHeaderUtils {
    public static final String NEW_LINE = System.lineSeparator();

    public static String generate200Header(int lengthOfBodyContent) {
        StringBuilder sb = new StringBuilder()
                .append("HTTP/1.1 200 OK")
                .append(NEW_LINE)
                .append(generateContentType())
                .append(generateContentLength(lengthOfBodyContent))
                .append(NEW_LINE);
        return sb.toString();
    }

    public static String generate302Header(String path) {
        StringBuilder sb = new StringBuilder()
                .append("HTTP/1.1 302 Found")
                .append(NEW_LINE)
                .append("Location: ")
                .append(path)
                .append(NEW_LINE)
                .append(generateContentType())
                .append(NEW_LINE);
        return sb.toString();
    }

    private static String generateContentType() {
        StringBuilder sb = new StringBuilder()
                .append("Content-Type: text/html;charset=utf-8")
                .append(NEW_LINE);
        return sb.toString();
    }

    private static String generateContentLength(int lengthOfBodyContent) {
        StringBuilder sb = new StringBuilder()
                .append("Content-Length: ")
                .append(lengthOfBodyContent)
                .append(NEW_LINE);
        return sb.toString();
    }
}
