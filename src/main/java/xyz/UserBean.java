//package beans;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.enterprise.context.ApplicationScoped;
//import javax.inject.Named;
//
//@Getter
//@Setter
//@Named(value = "userBean")
//@ApplicationScoped
//public class UserBean {
//    private UserService userService = new UserService();
//
//    private User user;
//    private Attempt attempt;
//
//    public UserBean() {
//        user = new User();
//        attempt = new Attempt();
//    }
//    public void findUserOnDb(){
//        User newUser = userService.findUser(user.getId());
//        if(newUser!=null){
//            this.user = newUser;
//            System.out.println("yay got it");
//        }else {
////            saveUser();
//            System.out.println("create it");
//        }
//
//    }
//
//    public void saveUser() {
//        userService.saveUser(user);
//    }
//
//    public void addAttempt() {
//        user.addAuto(attempt);
//        attempt.setUser(user);
//        userService.updateUser(user);
//        // Очистить auto для следующего ввода
//        attempt = new Attempt();
//    }
//
//
//}
