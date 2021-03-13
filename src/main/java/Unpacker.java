import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Unpacker {

    private Integer num = 20;
    private String errorMsg = "String is unvalid.";

    public String unpack(String incomeString) {
        if (isValid(incomeString)) {
            Pattern pattern = Pattern.compile("\\d");
            String[] elements = incomeString.split("\\[|\\]");
            ArrayList<Object> newArray = new ArrayList<>();
            ArrayList<Object> last = new ArrayList<>();
            String outgoingString = "";


            for (String str : elements) {
                if (str != "") {
                    newArray.add(str);
                }
            }
            for (Object obj : newArray) {
                Matcher matcher = pattern.matcher((CharSequence) obj);
                if (matcher.find()) {
                    int i = Integer.parseInt((String) obj);
                    last.add(i);
                } else {
                    last.add(obj);
                }
            }
            for (int i = 0; i < last.size(); i++) {
                int nexIndex = i + 1;
                if (last.get(i).getClass() == num.getClass() && last.get(nexIndex).getClass() == num.getClass()
                        && last.get(nexIndex + 1).getClass() == incomeString.getClass()) {
                    for (int k = 1; k < (int) last.get(i); k++) {
                        for (int j = 0; j < (int) last.get(nexIndex); j++) {
                            outgoingString += last.get(nexIndex + 1);
                        }
                    }
                } else if (last.get(i).getClass() == num.getClass()
                        && last.get(nexIndex).getClass() == incomeString.getClass()) {
                    for (int k = 0; k < (int) last.get(i); k++) {
                        outgoingString += last.get(i + 1);
                    }
                } else if (last.get(i).getClass() == incomeString.getClass()) {
                    if (nexIndex <= last.size() - 1 && last.get(nexIndex).getClass() == incomeString.getClass()) {
                        outgoingString += last.get(nexIndex);
                    }
                }


            }
            return outgoingString;
        }
        return errorMsg;
    }

    public boolean isValid(String incomeString){     //проверка валидности строки
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9\\[|\\]]");
        Matcher matcher = pattern.matcher(incomeString);
        if(matcher.find()){
            return false;
        }
        return true;
    }
}
