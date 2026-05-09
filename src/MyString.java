public class MyString {
    public static void main(String[] args) {
        String sentence = "Java,Python,C++";
        String[] languages = sentence.split(",");
        for(String str : languages){
            System.out.println(str);
        }

        String str = "hello lihewu  !";
        // String[] s = str.split(" ");//只能划分单个分隔符
        String[] s = str.split("\\s+");
        for(String s1 : s){
            System.out.println(s1);
        }

        String str2 = "    中文空格   ";
        System.out.println(str2);
        str2 = str2.trim();
        System.out.println(str2);

    }



//    public static void main(String[] args) {
//
//        //实例化一个String(Stringy也是引用数据类型)
//        String str = "lihewu";//String 可以直接赋值，无需写new
//        System.out.println("str's length is " + str.length());
//
//        //通过new来创建Stirng
//        String str2 = new String("new lihewu");
//        for(char i : str.toCharArray()){
//            System.out.print(i );
//        }
//        System.out.println();
//
//        //charAt();
//        System.out.println(str.charAt(2));
//
//        //toUpperCase()
//        System.out.println(str.toUpperCase());
//    }
}
