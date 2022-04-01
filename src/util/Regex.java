package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static final String USER_EMAIL_REGEX = "[a-zA-z0-9]+@[A-Za-z0-p]+.[a-z]";
    public static final String USER_NAMES_REGEX = "[A-Za-z]{3,15}";
    public static final String USER_FIRST_LAST_NAME_REGEX = "[A-Za-z]{1,}";
    public static final String USER_PASS_REGEX = "[[A-Z]+[a-z]+[0-9]+[!-_.@]+]{5,15}";
    public static final String MOVIE_NAMES_REGEX = "[A-Za-z]{1,50}";
    public static final String MOVIE_DIRECTOR_STUDIO_NAME_REGEX = "[A-Za-z]{2,}";
    public static boolean regexValidation(String parameter, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(parameter);
        if(matcher.find()){
            return true;
        }
        return false;
    }
}
