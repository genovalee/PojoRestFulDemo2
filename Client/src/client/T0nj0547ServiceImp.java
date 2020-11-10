package client;

import client.exception.ErrorMessage;

import client.exception.NotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import javax.naming.NamingException;

import javax.sql.DataSource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;


@Path("/")
public class T0nj0547ServiceImp implements T0nj0547Service {
    private Connection conn;

    public T0nj0547ServiceImp() throws NamingException, SQLException {
        super();
        InitialContext ic = new InitialContext();
        DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/t078DS");
        conn = ds.getConnection();
        conn.setAutoCommit(false);
    }

    @Override
    @POST
    @Produces("application/json")
    @Path("/add")
    public Response addT0nj0547(T0nj0547 t47) throws NamingException, SQLException {
        try {
            InsertDbT0nj0547 insT0nj0547 = new InsertDbT0nj0547(conn, t47);
            insT0nj0547.InsertDbT0nj0547();
            if (t47.getT0nj0547d().size() > 0) {
                InsertDbT0nj0547d insT0nj0547d = new InsertDbT0nj0547d(conn, t47.getT0nj0547d());
                insT0nj0547d.InsertDbT0nj0547d();
            }
            conn.commit();

            String resp = "{\"message\":\"資料已新增\",\"status\":\"" + Response.Status.CREATED + "\"}";
            return Response.status(Response.Status.CREATED).entity(resp).build();
        } catch (SQLException ex) {
            ex.printStackTrace();
            conn.rollback();
            System.out.println(ex.getMessage());
            String resp = "{\"message\":\"" + ex.getMessage().replace("\"", "\'") + "\"}";
            return Response.status(Response.Status.CREATED).entity(resp).build();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("資料庫連線異常");
                }
            }
        }
        return null;
    }

    @Override
    @GET
    @Produces("application/json")
    @Path("/get")
    public T0nj0547 getT0nj0547ByBussRfnoRegoFc(@QueryParam("bussrfno") @DefaultValue("98765433") String bussrfno,
                                                @QueryParam("regofc") @DefaultValue("376430000A")
                                                String regofc) throws NotFoundException {
        PreparedStatement ps = null, ps2 = null;
        String sql =
            "select bussrfno, bussnm, costsid, costsidcomt, regofc, regofccomt, busslocation from t0nj0547 where bussrfno=? and regofc=?";
        String sql2 = "select bussrfno, regofc, it, salit, salitcomt from t0nj0547d where bussrfno=? and regofc=?";
        List<T0nj0547d> t0nj0547ds = new ArrayList<T0nj0547d>();

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, bussrfno);
            ps.setString(2, regofc);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps2 = conn.prepareStatement(sql2);
                ps2.setString(1, rs.getString("bussrfno"));
                ps2.setString(2, rs.getString("regofc"));
                ResultSet rs2 = ps2.executeQuery();
                while (rs2.next()) {
                    T0nj0547d t0nj0547d = extractT0nj0547dFromResultSet(rs2);
                    t0nj0547ds.add(t0nj0547d);
                }
            }
            return extractT0nj0547FromResultSet(rs, t0nj0547ds);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorMessage errorMessage = new ErrorMessage("1001", "t0nj0547 not found!", Response.Status.NOT_FOUND);
            throw new NotFoundException(errorMessage);
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("資料庫連線異常");
                }
            }
        }
        return null;
    }

    private T0nj0547 extractT0nj0547FromResultSet(ResultSet rs, List<T0nj0547d> t0nj0547ds) throws SQLException {
        T0nj0547 t0nj0547 = new T0nj0547();
        t0nj0547.setBussrfno(rs.getString("bussrfno"));
        t0nj0547.setBussnm(rs.getString("bussnm"));
        t0nj0547.setCostsid(rs.getString("costsid"));
        t0nj0547.setCostsidcomt(rs.getString("costsidcomt"));
        t0nj0547.setRegofc(rs.getString("regofc"));
        t0nj0547.setRegofccomt(rs.getString("regofccomt"));
        t0nj0547.setBusslocation(rs.getString("busslocation"));
        t0nj0547.setT0nj0547d(t0nj0547ds);
        return t0nj0547;
    }

    private T0nj0547d extractT0nj0547dFromResultSet(ResultSet rs) throws SQLException {
        T0nj0547d t0nj0547d = new T0nj0547d();
        t0nj0547d.setBussrfno(rs.getString("bussrfno"));
        t0nj0547d.setRegofc(rs.getString("regofc"));
        t0nj0547d.setIt(rs.getString("it"));
        t0nj0547d.setSalit(rs.getString("salit"));
        t0nj0547d.setSalitcomt(rs.getString("salitcomt"));
        return t0nj0547d;
    }
}
