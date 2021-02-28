class Solution {
    public String solution(String new_id) {
        String id = new_id.toLowerCase();
        id = removeSpecificChars(id);
        id = compressContinuousDots(id);
        id = removeEdgeDots(id);
        id = replaceEmptyCharToA(id);
        id = removeLengthOverChars(id);
        id = concatLastChar(id);
        return id;
    }
    
    public static String removeSpecificChars(String id) {
        char[] charArr = id.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if ((charArr[i] >= 'a' && charArr[i] <= 'z') || (charArr[i] >= 'A' && charArr[i] <= 'Z') || charArr[i] == '-' || charArr[i] == '_' || charArr[i] == '.' || (charArr[i] >= '0' && charArr[i] <= '9')) {
                continue;
            }
            charArr[i] = ' ';
        }
        return new String(charArr).replace(" ", "");
    }
    
    public static String compressContinuousDots(String id) {
        String removedContinuousDotId = new String("");
        char[] charArr = id.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '.' && removedContinuousDotId.length() > 0 && removedContinuousDotId.charAt(removedContinuousDotId.length() - 1) == '.') {
                continue;
            }
            removedContinuousDotId = removedContinuousDotId + charArr[i];
        }
        return removedContinuousDotId;
    }
    
    public static String removeEdgeDots(String id) {
        char[] charArr = id.toCharArray();
        if (charArr[0] == '.') {
             for (int i = 0; i < charArr.length; i++) {
                if (charArr[i] == '.') {
                    charArr[i] = ' ';
                    break;
                }
            }
        }
        
        if (charArr[charArr.length - 1] == '.') {
            for (int i = charArr.length - 1; i >= 0; i--) {
                if (charArr[i] == '.') {
                    charArr[i] = ' ';
                    break;
                }
            }   
        }
        
        return new String(charArr).replace(" ", "");
    }
    
    public static String replaceEmptyCharToA(String id) {
        if (id.length() == 0) {
            id += 'a';
        }
        return id;
    }
    
    public static String removeLengthOverChars(String id) {
        if (id.length() >= 16) {
            id = id.substring(0, 15);
            
            char[] charArr = id.toCharArray();
            if (charArr[charArr.length - 1] != '.') {
                return id;
            }
            
            for (int i = charArr.length - 1; i >= 0; i--) {
                if (charArr[i] == '.') {
                    charArr[i] = ' ';
                } else {
                    break;
                }
            }
            return new String(charArr).replace(" ", "");
        }
        return id;
    }
    
    public static String concatLastChar(String id) {
        if (id.length() > 3 || id.length() < 1) {
            return id;
        }
        
        while (id.length() != 3) {
            id += id.charAt(id.length() - 1);
        }
        return id;
    }
}
