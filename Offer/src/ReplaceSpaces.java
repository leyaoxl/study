public class ReplaceSpaces {
    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0) return null;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                stringBuilder.append("%");
            } else stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("We Are Happy");
        ReplaceSpaces replaceSpace = new ReplaceSpaces();
        System.out.println(replaceSpace.replaceSpace(stringBuffer));
    }
}
