package Telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Browsable,Callable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb=new StringBuilder();
        Pattern pattern=Pattern.compile("[0-9]");
        for (String url : urls) {
            Matcher matcher=pattern.matcher(url);
            if (matcher.find()) {
                sb.append("Invalid URL!").append(System.lineSeparator());
            } else {
                sb.append(String.format("Browsing: %s!",url)).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb=new StringBuilder();
        Pattern pattern=Pattern.compile("^[0-9]+$");
        for (String number : this.numbers) {
            Matcher matcher=pattern.matcher(number);
            if (matcher.find()) {
                sb.append("Calling... ").append(number).append(System.lineSeparator());
            } else {
                sb.append("Invalid number!").append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}
