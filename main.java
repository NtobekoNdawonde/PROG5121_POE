import java.util.scanner;

Class Login{

  private String storedUsurname;
  private String storedPassword;
  private String storedPhone;
  
  //Username validation
  public boolean checkuserName(String Username){
    return username.contains("_")&&
    username.length()<=5;
  }
  
  //Passwrd validation (NO regex)
  public boolean checkpassword(String Password){
    
    if(password.length()<8) return false;
  
  boolean hasUpper=false;
  boolean hasNumber=false;
  boolean hasSpecial=false;
  
  for(int i=0;i<password.length();i++){
    char ch=password.charAt(i);
   
   if(Character.isUpperCase(ch)){
     hasUppe=true;
   }else if(Character.isUpperCase(ch)){
     hasNumber=true;
   }else if(!Character.isLetterOrDigit(ch)){
     hasSpecial=true;
   }
  } 
  
  return hasUpper && hasNumber && hasSpecial;
}

//Cell phone validation (NO regex)
public boolean checkPhone(String phone){
  
  if(!phone.startsWith("+27")) return false;
  if(phone.length()!=12) return false;
  
  for(int i=3; i < phone.length();i++){
    if(!Character.isDigit(phone.charAt(i))){
      return false;
    }
  }
  
  return true;
}

//Register method public void register(Scanner sc){
  
  System.out.println("===REGISTER===");
  
  System.out.print("Enter username:");
  String username= sc.nextline();
  
  if (checkuserName(username)){
    System.out.println("Username successfullyly captured.");
    
    storedUsurname = username;
  }else{
    System.out.println("Username is not correctly formatted.");
    return;//stop if invalid
  }
  
  System.out.print("Enter password:");
  String password=sc.nextLine();
  
  if(checkpassword(password)){
    System.out.println("Password successfully captured.");
    storedPassword = password;
  }else{
    System.out.println("Password is not correctly formatted.");
    return;
  }
   System.out.print("Enter cell phone(+27...):");
   String phone = sc.nextLine();
   
   if(checkPhone(phone)){
     System.out.println("cell phone number is incorrectly formatted.");
     return;
   }
   System.out.println("Registration successfully!\n");
  }
  
  //Login method public void login(Scanner sc){
     
     System.out.println("===LOGIN===");
     
     System.out.print("Enter username:");
     String username = sc.nextLine();
     
     if(username.equals(storedUsurname)&&
  password.equals(storedPassword)){
    System.out.println("Welcome back! Login successful.");
  }else{
    System.out.println("Username or password incorrect,please try again.");
  }
}

public class main{
  
    public static void runTests(){
    
    Login login = new Login();
    
      System.out.System.out.println("\n===RUNNING TESTS===");
      
      System.out.println("Test Username Valid:"+
      (login.checkUserName("ky1_") == true));
      
      System.out.println("TestUser name Invalid:"+
      (login.checkUserName("kyle!!!!!")==false));
      
      System.out.println("Test Password Valid:"+
      (login.checkPassword("Ch@8sec@ke99!")==true));
      
      System.out.println("Test Password Invalid:"+
      (login.checkPassword("pass-word")==false));
      
      System.out.println("Test Phone Valid:"+
      (login.checkPhone("+2783896876")==true));
      
      System.out.println("Test Phone Invalid:"+
      (login.checkPhone("0838968976")==false)); 
  }
  
  public static void main(string[]args){
    
    Scanner sc= new Scanner(System.in);
    Login user=new Login();
    
    int choice;
    
    do{
      
  System.out.println("\n===MENU===");
      System.out.println("1.Register");
      System.out.println("2.Login");
      System.out.println("3.Run Tests");
      System.out.println("4.Exit");
  
  System.out.print("choose option:");
  
      choice=sc.nextint();
      sc.nextLine();
      
      switch(choice){
        case 1:
          user.register(sc);
          break;
          
         case 2:
          user.login(sc);
          break;
            
        case 3:
          System.out.println("Goodbye!");
          break; 
          
        default:
          System.out.println("Invalid choice.");
      }
  }while(choice!=3);
  
  sc.close();
}


  
