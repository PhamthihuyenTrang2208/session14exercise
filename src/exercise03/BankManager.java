package exercise03;
import java.sql.*;

import exercise01.DTB;

public  class BankManager  {
    private int id_from;
    private int id_to;
    private double amount;
    public static void transfer(int id_from, int id_to, double amount) {
        Connection con = null;
        CallableStatement cs = null;
        try {
             con = DTB.getConnection();
            con.setAutoCommit(false);

            cs = con.prepareCall("{call transfer_funds(?,?,?,?)}");
            cs.setInt(1, id_from);
            cs.setInt(2, id_to);
            cs.setDouble(3, amount);

            cs.registerOutParameter(4, Types.VARCHAR); //
            cs.execute();


            String rs = cs.getString(4);
            System.out.println(  rs );

            con.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try { if (con != null) con.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            System.out.println("Chuyển tiền thất bại!");
        } finally {
            try { if (cs != null) cs.close(); } catch (Exception ignored) {}
            try { if (con != null) con.close(); } catch (Exception ignored) {}
        }
    }}