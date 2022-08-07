public class TreeNode {
    public static void main(String[] args) {
        String s = "asdhjg";
        System.out.println(s.charAt(2));
        char[] c = s.toCharArray();
        System.out.println("1"+c[0]+"2");
        if(Character.isSpace(c[0])){
            System.out.println("!!!");
        }
    }
}
