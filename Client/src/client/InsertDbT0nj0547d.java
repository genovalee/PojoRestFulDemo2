package client;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

public class InsertDbT0nj0547d {
    private Connection conn = null;
    private List<T0nj0547d> t47d = new ArrayList<T0nj0547d>();

    public InsertDbT0nj0547d() {
    }

    public InsertDbT0nj0547d(Connection conn, List<T0nj0547d> t47d) {
        this.conn = conn;
        this.t47d = t47d;
    }

    public void InsertDbT0nj0547d() throws SQLException {
        Date date = new Date(System.currentTimeMillis());
        Timestamp today = new Timestamp(date.getTime());
        String sql = "INSERT INTO t0nj0547d(bussrfno, regofc, it, salit, salitcomt, txdat) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        for (T0nj0547d dt : t47d) {
            ps.setString(1, dt.getBussrfno());
            ps.setString(2, dt.getRegofc());
            ps.setString(3, dt.getIt());
            ps.setString(4, dt.getSalit());
            ps.setString(5, dt.getSalitcomt());
            ps.setTimestamp(6, today);
            ps.execute();
        }
        ps.close();
    }
}
