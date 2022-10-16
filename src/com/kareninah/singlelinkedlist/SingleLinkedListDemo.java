package com.kareninah.singlelinkedlist;

/**
 * @FileName com.kareninah.singlelinkedlist.SingleLinkedList
 * @Description TODO
 * @Author hgy
 * @Date 2022/10/15:23:40
 * @Version V1.0
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode jack = new HeroNode(1, "jack", "111");
        HeroNode tom = new HeroNode(2, "tom", "222");
        HeroNode mark = new HeroNode(3, "mark", "333");
        HeroNode mary = new HeroNode(4, "mary", "444");
        SingleLinkedList list = new SingleLinkedList();
        list.addByOrder(tom);
        list.addByOrder(mary);
        list.addByOrder(jack);
        list.addByOrder(mark);
        list.showList();
        list.update(new HeroNode(4, "mary4", "4"));
        System.out.println("修改后");
        list.showList();
//        list.deleteById(1);
//        list.deleteById(4);
//        list.deleteById(3);
//        list.deleteById(2);
        System.out.println("删除后");
        list.showList();
        System.out.println("链表反转");
        list.reverse();
        list.showList();
    }


    static class SingleLinkedList {
        private final HeroNode headNode;

        public SingleLinkedList() {
            headNode = new HeroNode();
        }

        //按id顺序添加
        public void addByOrder(HeroNode heroNode) {
            HeroNode temp = headNode;
            //记录id是否重复
            boolean flag = false;

            //遍历节点查找可插入位置
            while (true) {
                if (temp.next == null) {
                    //在链表尾, 可添加
                    break;
                }
                if (temp.next.id > heroNode.id) {
                    //当前节点的下一节点id大于出入的节点id, 可添加
                    break;
                } else if (temp.next.id == heroNode.id) {
                    //id重复
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                System.out.println("当前id已有数据");
            } else {
                heroNode.next = temp.next;
                temp.next = heroNode;
            }
        }

        //遍历
        public void showList() {
            HeroNode temp = headNode.next;
            if (temp == null) {
                System.out.println("链表为空");
                return;
            }
            while (true) {
                if (temp == null) {
                    //遍历完毕
                    break;
                }
                System.out.println(temp);
                temp = temp.next;
            }
        }
        //修改id相等的节点信息
        public void update(HeroNode heroNode) {
            HeroNode temp = headNode;
            while (true) {
                if (temp == null) {
                    System.out.println("未找到可修改的节点");
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
        //根据id删除节点
        public void deleteById(int id) {
            HeroNode temp = headNode;
            while (true) {
                if (temp == null) {
                    System.out.println("未找到可删除的节点");
                    break;
                }
                if (temp.next.id == id) {
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
            }
        }

        //链表反转
        public void reverse() {
            //定义一个临时头结点
            HeroNode reverseHead = new HeroNode();
            HeroNode cur = headNode.next;
            HeroNode next;
            while (true) {
                //遍历原链表
                if (cur == null) {
                    //遍历完毕
                    break;
                }
                //将头节点的next指向当前遍历节点的下一个节点
                next = cur.next;
                //将当前遍历的节点, 插入到临时头结点和next中间, 即放在链表最前端
                cur.next = reverseHead.next;
                reverseHead.next = cur;
                cur = next;
            }
            //最后将原头结点的next指向临时头结点的next
            headNode.next = reverseHead.next;
        }
    }


    static class HeroNode {
        private int id;
        private String name;
        private String nickName;
        private HeroNode next;

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
