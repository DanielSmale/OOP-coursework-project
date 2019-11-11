package DataModel;


public class User {

    private String givenName;
    private String surname;
    private String address;
    private String idNumber;

    public void Login() {
        String loginName;
        String loginSurname;
        String loginIDNum;
        
        System.out.println("Enter your first name: ");
        loginName = System.in.toString();

        System.out.println("Enter your second name: ");
        loginSurname = System.in.toString();

        System.out.println("Enter your id number: ");
        loginIDNum = System.in.toString();

        if (givenName == loginName && surname == loginSurname && idNumber == loginIDNum) {
            System.out.println("Sucessfully logged in");
        } else {
            System.out.println("Incorrect login");
        }

    }

}
