import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class MyStack {

    Stack<Character> stack;

    public MyStack(){
        stack = new Stack<>();
        stack.push('l');
        stack.push('i');
        stack.push('h');
        stack.push('e');
        stack.push('w');
        stack.push('u');
    }

    public void prt(){
        System.out.println(stack.toString());
    }

    public static void main(String[] args) {
        MyStack stack1 = new MyStack();
        stack1.prt();
    }


}

//class MyStack {
//    //声明对象
//    Queue<Integer> queue;
//
//    public MyStack() {//实例化构造函数
//        /**
//         * Java中Queue为抽象接口，无实体类，但是提供了以下两种实体类
//         * 1.ArrayDeque,动态数组实现，速度快，性能高
//         * 2.LinkedList
//         */
//        queue = new ArrayDeque<>();
//    }
//
//    public void push(int x) {//压栈
//        queue.add(x);
//    }
//
//    public int pop() {//出栈顶元素并删除
//        int size = queue.size();
//        int temp = 0;
//        for(int i = 0; i < size-1; i++){
//            temp = queue.remove();
//            queue.add(temp);
//        }
//        temp = queue.remove();
//        return temp;
//    }
//
//    public int top() {//获取栈顶元素
//        int size = queue.size();
//        int temp = 0;
//        for(int i = 0; i < size; i++){
//            temp = queue.remove();
//            queue.add(temp);
//        }
//        return temp;
//    }
//
//    public boolean empty() {
//        return queue.isEmpty();
//    }
//}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */