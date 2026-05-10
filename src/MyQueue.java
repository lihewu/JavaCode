import java.util.Stack;
/**栈模拟队列
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
class MyQueue {
    //声明stackIn 和 stackOut类型，如果不在此声明会
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {//MyQueue的构造方法，一般在构造方法内集中实例化对象
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {//压入队列
        stackIn.push(x);
    }

    public int pop() {//返回队列首元素并删除
        int ret = 0;
        if(stackOut.isEmpty() && !stackIn.isEmpty()){
            while(!stackIn.isEmpty()){
                ret = stackIn.pop();
                stackOut.push(ret);
            }
        }
        ret = stackOut.pop();


        return ret;
    }

    public int peek() {//返回队列首元素
        int ret = 0;
        if(stackOut.isEmpty() && !stackIn.isEmpty()){//如果出栈为空且入栈非空
            while(!stackIn.isEmpty()){
                ret = stackIn.pop();
                stackOut.push(ret);
            }
        }
        ret = stackOut.peek();
        return ret;
    }

    public boolean empty() {
        return stackOut.isEmpty() && stackIn.isEmpty();
    }
}

