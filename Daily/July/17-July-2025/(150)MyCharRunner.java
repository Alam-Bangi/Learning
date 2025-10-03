class MyCharRunner {
    public static void main(String[] args) {
        MyChar myChar = new MyChar('a');
        System.out.println(myChar.isVowel());
        System.out.println(myChar.isDigit());
        System.out.println(myChar.isAlphabet());
        System.out.println(myChar.isConsonant());
        System.out.println(myChar.printLowerCaseAlphabets());
        System.out.println(myChar.printUpperCaseAlphabets());
    }
}class MyChar {
    private char ch;

    public MyChar(char ch) {
        this.ch = ch;
    }

    public boolean isVowel() {
        if(ch== 'a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
            return true;
        }
        if(ch== 'A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') {
            return true;
        }
        return false;
    }
    public boolean isDigit() {
        if(ch >= 48 && ch <= 57) {
            return true;
        }
        return false;
    }
    public boolean isAlphabet() {
        if(ch >= 97 && ch <= 122) {
            return true;
        }
        if(ch >= 65 && ch <= 90) {
            return true;
        }
        return false;
    }
    public boolean isConsonant() {
        if(isAlphabet() && !isVowel()) {
            return true;
        }
        return false;
    }
    public void printLowerCaseAlphabets() {
        for(char ch = 'a'; ch <= 'z'; ch++) {
            System.out.println(ch);
        }
    }
    public void printUpperCaseAlphabets() {
        for(char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.println(ch);
        }
    }
}