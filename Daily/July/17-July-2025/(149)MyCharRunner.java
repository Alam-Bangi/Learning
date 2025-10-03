class MyCharRunner {
    public static void main(String[] args) {
        MyChar myChar = new MyChar('a');
        System.out.println(myChar.isVowel());
        myChar.isDigit();
        myChar.isAlphabet();
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
}