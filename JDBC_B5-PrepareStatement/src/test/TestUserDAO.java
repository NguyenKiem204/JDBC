package test;

import dao.UserDAO;
import dao.UserDAO2;
import model.User;

import java.util.ArrayList;

public class TestUserDAO {
    public static void main(String[] args) {
//        User user = new User("nkiem347", "12345", "Nguyễn Văn Kiểm");
//        UserDAO.getInstance().insert(user);

//        User user2 = new User("user2", "abc", "Lê Thái Hòa");
//        UserDAO.getInstance().update(user2);

//        User user3 = new User();
//        user3.setUserName("user2");
//        UserDAO.getInstance().delete(user3);

//       ArrayList<User> listUser =  UserDAO.getInstance().selectAll();
//       for(User user: listUser){
//           System.out.println(user);
//       }

        User user4 = new User();
        user4.setUserName("user1");
        User userFound = UserDAO.getInstance().selectById(user4);
        System.out.println(userFound);


//        UserDAO2 không dùng PrepareStatement mà dùng Statement,
//        chỉ cần hacker tận dùng lỗi SQL Injection để tấn công, do dùng Statement là cộng chuỗi
//        chỉ cần dk where sử dụng or và 1 dk bất kì đúng thì sẽ hiển thị ra hết
        User u_find = new User("x\' or 1=1;--", "", "");
        User u_result = UserDAO2.getInstance().selectById(u_find);
        System.out.println(u_result);


    }
}
