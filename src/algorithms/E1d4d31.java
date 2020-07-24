package algorithms;


import java.util.Stack;

public class E1d4d31<Item> {
    Stack<Item> sLeft = new Stack<Item>();
    Stack<Item> sRight = new Stack<Item>();
    Stack<Item> sTemp = new Stack<Item>();
    boolean TempIsRight = false;//false表示中转栈存的是左栈数据，true表示中转栈存右栈数据。

    //
    public boolean isEmpty() {
        return sLeft.isEmpty() && sRight.isEmpty() && sTemp.isEmpty();
    }

    public int size() {
        return sLeft.size() + sRight.size() + sTemp.size();
    }

    public void pushLeft(Item item) {
        sLeft.push(item);
    }

    public Item popLeft() {
        if (!sLeft.isEmpty())
            return sLeft.pop();//左栈有内容时直接弹出
        else if (!sTemp.isEmpty() && TempIsRight)//左栈无内容，中转栈有内容，中转栈是右栈内容时，从中转栈中弹出
            return sTemp.pop();
        else if (!sTemp.isEmpty() && !TempIsRight)//左栈无内容，中转栈有内容，中转栈是左栈内容时，把中转栈内容全部倒入左栈，然后从左栈弹出
        {
            while (!sTemp.isEmpty())
                sLeft.push(sTemp.pop());
            return sLeft.pop();
        } else if (sTemp.isEmpty() && !sRight.isEmpty())
            //左栈无内容，中转栈无内容，右栈有内容，把右栈内容全部倒入中转栈，中转栈存入内容标记为右栈，然后从中转栈弹出。
        {
            while (!sRight.isEmpty())
                sTemp.push(sRight.pop());
            TempIsRight = true;
            return sTemp.pop();
        } else//左栈无内容，中转栈无内容，右栈无内容时，弹出null
        {
            return null;
        }
    }

    public void pushRight(Item item) {
        sRight.push(item);
    }

    public Item popRight()//与popLeft原理相同
    {
        if (!sRight.isEmpty())
            return sRight.pop();
        else if (!sTemp.isEmpty() && !TempIsRight)
            return sTemp.pop();
        else if (!sTemp.isEmpty() && TempIsRight) {
            while (!sTemp.isEmpty())
                sRight.push(sTemp.pop());
            return sRight.pop();
        } else if (sTemp.isEmpty() && !sLeft.isEmpty()) {
            while (!sLeft.isEmpty())
                sTemp.push(sLeft.pop());
            TempIsRight = false;
            return sTemp.pop();
        } else {
            return null;
        }
    }
}