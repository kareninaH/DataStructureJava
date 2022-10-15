package com.kareninah.queue;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Scanner;

/**
 * @FileName com.kareninah.queue.ArrayQueueDemo
 * @Description TODO
 * @Author hgy
 * @Date 2022/10/14:16:22
 * @Version V1.0
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        //测试一把
        //创建一个队列
        Queue queue = new Queue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
//输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
// TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
// TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}

class Queue {
    //队列大小
    private int size;
    //队首指针
    private int front;
    //队尾指针
    private int rear;
    //队列数据
    private int[] data;

    public Queue(int size) {
        this.size = size;
        data = new int[size];
        front = -1; // 队列第一个元素下标减一
        rear = -1; // 队列末尾元素下标
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isMax() {
        return rear == size - 1;
    }

    //添加数据
    public void addQueue(int num) {
        if (isMax()) {
            System.out.println("队列已满!");
            return;
        }
        data[++rear] = num;
    }

    // 取出数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return data[++front];
    }

    // 查看头部数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return data[front + 1];
    }

    // 查看队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < data.length; i++) {
            System.out.printf("data[%d]=%d\n", i, data[i]);
        }
    }
}
