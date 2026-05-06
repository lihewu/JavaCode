public class MyString {
    public static void main(String[] args) {

        //实例化一个String(Stringy也是引用数据类型)
        String str = "lihewu";//String 可以直接赋值，无需写new
        System.out.println("str's length is " + str.length());

        //通过new来创建Stirng
        String str2 = new String("new lihewu");
        for(char i : str.toCharArray()){
            System.out.println(i);
        }
    }
}
