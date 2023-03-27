import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
// create a student class
class Student {
    String Reg_no;
    String Name;
    String email;
    String Phone;
    String stu_class;
    String Department;
// declare argument constructor
    Student(String reg, String nm, String email, String phone, String stu_class, String dept) {
        this.Reg_no = reg;
        this.Name = nm;
        this.email = email;
        this.Phone = phone;
        this.stu_class = stu_class;
        this.Department = dept;
    }
// Display method to display student details
    void display() {
        System.out.println("\n** Details of a " + this.Name + " . **");
        System.out.println("Reg No : " + this.Reg_no);
        System.out.println("Name : " + this.Name);
        System.out.println("Email :" + this.email);
        System.out.println("Phone: " + this.Phone);
        System.out.println("Class : " + this.stu_class);
        System.out.println("Department :" + this.Department);
    }
}

public class lab6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // System.out.print("how many student want to enter: ");
        // int n = Integer.parseInt(input.nextLine());
        Student[] obj = new Student[100];
        int c = 0;

        boolean flag = true;
        //Start Do...while loop for menu dreven program. till user does not want to Exit.
        do {
            System.out.println("\n**************");
            System.out.println(
                    "---- Your Choices: -------------------\n---- 1. Add a student -----------------\n---- 2. Search for a student ----------\n---- 3. Update the details of a student\n---- 4. Display all students ----------\n---- 5. Exit --------------------------");
            System.out.print("Enter Choice: ");
            int ch = Integer.parseInt(input.nextLine());
            switch (ch) {
                
                case 1:// case 1 used to add a student 
                    System.out.println("\n** Enter Student " + (c + 1) + " Details **");
                    System.out.print("Reg No : ");
                    String rg = input.nextLine();

                    System.out.print("Name : ");
                    String nm = input.nextLine();

                    System.out.print("Email : ");
                    String em = input.nextLine();

                    System.out.print("Phone : ");
                    String phone = input.nextLine();

                    System.out.print("Class: ");
                    String cl = input.nextLine();

                    System.out.print("Departement: ");
                    String dp = input.nextLine();

                    obj[c] = new Student(rg, nm, em, phone, cl, dp);
                    int x = filedetails(c, obj);// Create a text file for students
                    String fnm = nm.concat(".txt");

                    c = c + 1;

                    break;
                case 2:// this case to used to search the student details 
                    System.out.println("Search Student by..... \n 1. Name \n 2. Register No ");
                    System.out.println("Press (1 Or 2): ");
                    int a = Integer.parseInt(input.nextLine());
                    boolean ct = true;
                    if (a == 1) {
                        System.out.print("Enter Student Name: ");
                        String nm1 = input.nextLine();
                        for (int i = 0; i < obj.length; i++) {
                            if (nm1.equalsIgnoreCase(obj[i].Name)) {
                                obj[i].display();
                                ct = false;
                                break;

                            }
                        }
                        if (ct) {
                            System.out.println("Not found..................");
                        }

                    } else if (a == 2) {
                        System.out.print("Enter Student Register no: ");
                        String rgn = input.nextLine();
                        for (int i = 0; i < obj.length; i++) {
                            if (rgn.equalsIgnoreCase(obj[i].Reg_no)) {
                                obj[i].display();
                                ct = false;
                                break;
                            }
                        }
                        if (ct) {
                            System.out.println("Not found..................");
                        }
                    }
                    break;
                case 3:// this case used to update the students detsils 
                    System.out.print("Enter Student Register no: ");
                    String rgn = input.nextLine();
                    boolean ct1 = true;
                    for (int i = 0; i < obj.length; i++) {
                        if (rgn.equalsIgnoreCase(obj[i].Reg_no)) {

                            System.out.print("Name : ");
                            obj[i].Name = input.nextLine();

                            System.out.print("Email : ");
                            obj[i].email = input.nextLine();

                            System.out.print("Phone : ");
                            obj[i].Phone = input.nextLine();

                            System.out.print("Class: ");
                            obj[i].stu_class = input.nextLine();

                            System.out.print("Departement: ");
                            obj[i].Department = input.nextLine();

                            int x1 = filedetails(i, obj); // update student text file

                            ct1 = false;
                            break;

                        }
                    }
                    if (ct1) {
                        System.out.println("Not found..................");
                    }
                    break;
                case 4:// display all students details
                    for (int i = 0; i < obj.length; i++) {
                        obj[i].display();
                    }

                    break;
                case 5: // for exit

                    flag = false;
                    break;

                default:
                    break;
            }
        } while (flag);

    }
// for create file for particuler array of object
    static int filedetails(int n, Student[] arr) {
        String nm = arr[n].Name;
        String fnm = nm.concat(".txt");
        try {
            File file = new File(fnm);
            if (file.exists()) {
                System.out.println("file exist");

            } else {
                System.out.println("file not exist");
                if (file.createNewFile()) {
                    System.out.println("file created");

                } else {
                    System.out.println("file creation error");
                }
            }
            FileWriter writedetails = new FileWriter(file);
            writedetails.write("Reg No : " + arr[n].Reg_no + "\n");
            writedetails.write("Name : " + arr[n].Name + "\n");
            writedetails.write("Email: " + arr[n].email + "\n");
            writedetails.write("Phone : " + arr[n].Phone + "\n");
            writedetails.write("Class : " + arr[n].stu_class + "\n");
            writedetails.write("Department : " + arr[n].Department);

            writedetails.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

}