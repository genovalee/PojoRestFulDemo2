package client;

import java.sql.SQLException;

import javax.naming.NamingException;

import javax.ws.rs.core.Response;

public interface T0nj0547Service {
    public Response addT0nj0547(T0nj0547 t47) throws NamingException, SQLException;

    public T0nj0547 getT0nj0547ByBussRfnoRegoFc(String bussrfno, String regofc);
}
