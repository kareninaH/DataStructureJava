package com.kareninah.doublelinkedlist;


/**
 * @FileName com.kareninah.doublelinkedlist.DoubleLinkedListDemo
 * @Description TODO
 * @Author hgy
 * @Date 2022/10/16:16:56
 * @Version V1.0
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode jack = new HeroNode(1, "jack", "111");
        HeroNode tom = new HeroNode(2, "tom", "222");
        HeroNode mark = new HeroNode(20, "mark", "333");
        HeroNode mary = new HeroNode(4, "mary", "444");
        DoubleLinkedList list = new DoubleLinkedList();
        list.addByOrder(jack);
        list.addByOrder(tom);
        list.addByOrder(mark);
        list.addByOrder(mary);
        list.showList();
        System.out.println("修改");
        list.update(new HeroNode(20, "mark20", "20"));
        list.showList();
        System.out.println("删除");
        list.delete(20);
        list.showList();
    }



    static class DoubleLinkedList {
        private HeroNode headNode;

        public DoubleLinkedList() {
            this.headNode = new HeroNode();
        }

        //添加
        public void add(HeroNode heroNode) {
            HeroNode temp = headNode;
            while(true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            temp.next = heroNode;
            heroNode.pre = temp;
        }

        //按id顺序插入
        public void addByOrder(HeroNode heroNode) {
            HeroNode cur = headNode;
            while (true) {
                if (cur.next == null) {
                    //插入在尾部
                    cur.next = heroNode;
                    heroNode.pre = cur;
                    break;
                }
                if (cur.next.id > heroNode.id) {
                    heroNode.next = cur.next;
                    heroNode.pre = cur;
                    cur.next.pre = heroNode;
                    cur.next =heroNode;
                    break;
                }
                if (cur.id == heroNode.id) {
                    System.out.println("存在相同id节点, 插入失败");
                    break;
                }
                cur = cur.next;
            }
        }

        //遍历
        public void showList() {
            HeroNode temp = headNode.next;
            if (temp == null) {
                System.out.println("列表为空");
                return;
            }
            while (true) {
                if(temp == null) {
                    break;
                }
                System.out.println(temp);
                temp = temp.next;
            }
        }

        //修改
        public void update(HeroNode heroNode) {
            HeroNode temp = headNode.next;
            if (temp == null) {
                System.out.println("列表为空");
                return;
            }
            while (true) {
                if (temp ==null) {
                    System.out.println("数据不存在列表中");
                    break;
                }
                if (temp.id == heroNode.id) {
                    temp.name = heroNode.name;
                    temp.nickName = heroNode.nickName;
                    break;
                }
                temp = temp.next;
            }
        }

        //删除
        public void delete(int id) {
            HeroNode temp = headNode.next;
            if (temp == null) {
                System.out.println("列表为空");
                return;
            }
            while (true) {
                if (temp == null) {
                    System.out.println("数据不存在列表中");
                    break;
                }
                if (temp.id == id) {
                    temp.pre.next = temp.next;
                    if (temp.next != null) {
                        temp.next.pre = temp.pre;
                    }
                    break;
                }
                temp = temp.next;
            }
        }

    }


    static class HeroNode {
        private int id;
        private String name;
        private String nickName;
        private HeroNode next;
        private HeroNode pre;

        public HeroNode(int id, String name, String nickName) {
            this.id = id;
            this.name = name;
            this.nickName = nickName;
        }

        public HeroNode() {
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }
}
