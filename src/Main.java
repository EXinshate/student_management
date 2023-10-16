import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<student> array = new ArrayList<student>();
        while(true){
            System.out.println("----欢迎来到学生管理系统----");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看所有学生");
            System.out.println("5.退出");
            System.out.println("请输入你的选择");

            Scanner in = new Scanner(System.in);
            String line = in.nextLine();

            switch (line) {
                case "1":
                    System.out.println("添加学生");
                    addStudent(array);
                    break;
                case "2":
                    System.out.println("删除学生");
                    deleteStudent(array);
                    break;
                case "3":
                    System.out.println("修改学生");
                    updateStudent(array);
                    break;
                case "4":
                    System.out.println("查看所有学生");
                    findAllStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用！");
                    System.exit(0);
            }
        }
    }
    public static void addStudent(ArrayList<student> array) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入学生学号");
        String sid = in.nextLine();
        System.out.println("请输入学生姓名");
        String name = in.nextLine();
        System.out.println("请输入学生年龄");
        String age = in.nextLine();
        System.out.println("请输入学生住址");
        String address = in.nextLine();
        student s = new student();
        s.setSid(sid);
        s.setName(name);
        s.setAddress(address);
        s.setAge(age);

        array.add(s);
        System.out.println("添加学生成功！");
    }
    public static void deleteStudent(ArrayList<student> array){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要删除的学生学号：");
        String sid = in.nextLine();

        for (int i = 0; i < array.size(); i++) {
            student s = new student();
            if(s.getSid().equals(sid)){
                array.remove(i);
                break;
            }
        }
        System.out.println("删除成功！");
    }
    public static void updateStudent(ArrayList<student> array){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要修改的学生学号：");
        String sid = in.nextLine();
        System.out.println("请输入学生新姓名：");
        String name = in.nextLine();
        System.out.println("请输入学生新年龄：");
        String age = in.nextLine();
        System.out.println("请输入学生新居住地：");
        String address = in.nextLine();

        student s = new student();
        s.setSid(sid);
        s.setName(name);
        s.setAddress(address);
        s.setAge(age);
        for (int i = 0; i < array.size(); i++) {
            student s1 = new student();
            if (s1.getSid().equals(sid)){
                array.set(i,s);
                break;
            }
        }
        System.out.println("修改成功！");
    }
    public static void findAllStudent(ArrayList<student> array) {
        if(array.size()==0){
            System.out.println("无信息，请添加信息后查询!");
            return;
        }
        System.out.println("学号\t\t姓名\t\t年龄\t\t居住地");
        for (int i = 0; i < array.size(); i++) {
            student s = array.get(i);
            System.out.println(s.getSid() + "\t\t" + s.getName() + "\t\t" + s.getAge() + "岁\t" + s.getAddress());
        }
    }
}