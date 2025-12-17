package exercise01;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class studentManager {
    private Connection con;
    private CallableStatement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    ArrayList<Student> students =new ArrayList<>();
        public  void addStudent(  ArrayList<Student> students){
            con=null;
            stmt=null;
            try{
                con=DTB.getConnection();
                if(con!=null){
                 con.setAutoCommit(false);
                 for(Student student: students){
                     stmt= con.prepareCall(
                             "{call AddStudent(?,?)}");
                     stmt.setString(1,student.getName());
                     stmt.setInt(2,student.getAge());
                     stmt.executeUpdate();
                 }
                 con.commit();
                 System.out.println("Thêm sinh viên thành công.");
                }
            } catch (SQLException e) {
                try {
                    con.rollback();
                    System.out.println("Đã xảy ra lỗi.");
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
                e.printStackTrace();}
            finally {
                try {
                    if (stmt != null) stmt.close();
                    if (con != null) con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            }

        public void deleteStudentByAge(Scanner scanner) {
            int age = validate.getInt(scanner,"Nhập tuổi để xóa những học sinh có độ tuổi nhỏ hơn : ");
            Connection connection = null;
            CallableStatement stmt = null;
            try {
                connection = DTB.getConnection() ;
                if (connection != null) {
                    connection.setAutoCommit(false);
                    stmt = connection.prepareCall("{CALL delete_students_by_age(?)}");
                    stmt.setInt(1, age);
                    int rs = stmt.executeUpdate();
                    connection.commit();
                    if (rs == 0) {
                        System.out.println("Không tim thấy học sinh nào có tuổi nhỏ hơn : " + age);
                    }else {
                        System.out.println("Xóa thành công "+ rs + " học sinh có tuổi nhỏ hơn : " + age);
                    }
                }
            } catch (Exception e) {
                try {
                    connection.rollback();
                }catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }finally {
                try {
                    if (stmt != null) stmt.close();
                    if (connection != null) connection.close();

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

