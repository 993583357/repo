package Lesson.enhancer;

public class Test {
    public static void main(String[] args) {
        UserService u = new UserService();
        MyEnhancer1 m = new MyEnhancer1();
        UserService proxyObj = (UserService) m.getProxyObj(u.getClass());
        proxyObj.deleteUses();
        proxyObj.selectUses();

    }
}
