package com.reda.bootstrap;

import com.mysql.cj.jdbc.MysqlXid;
import com.reda.entity.MyXid;
import com.reda.utils.DataSourceUtils;

import javax.sql.XAConnection;
import javax.sql.XADataSource;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class XATrxBootstrap {

    private static final String conn1 = "jdbc:mysql://localhost:3306/test";
    private static final String conn2 = "jdbc:mysql://localhost:3306/test2";

    public static void main(String[] args) throws SQLException, XAException {
        XADataSource dataSource1 = DataSourceUtils.xaDataSource(conn1, "root", "1qaz2wsx");
        XADataSource dataSource2 = DataSourceUtils.xaDataSource(conn2, "root", "1qaz2wsx");

        XAConnection xaConn1 = dataSource1.getXAConnection();
        XAResource xaRes1 = xaConn1.getXAResource();
        Connection conn1 = xaConn1.getConnection();
        Statement stmt1 = conn1.createStatement();

        XAConnection xaConn2 = dataSource2.getXAConnection();
        XAResource xaRes2 = xaConn2.getXAResource();
        Connection conn2 = xaConn2.getConnection();
        Statement stmt2 = conn2.createStatement();

        Xid xid1 = new MyXid(new byte[]{0x01}, new byte[]{0x02},100);
        Xid xid2 = new MyXid(new byte[]{0x11}, new byte[]{0x12},100);
        xaRes1.start(xid1,XAResource.TMNOFLAGS);
        stmt1.execute("delete from user where id=1");
        xaRes1.end(xid1,XAResource.TMSUCCESS);

        xaRes2.start(xid2, XAResource.TMNOFLAGS);
        stmt2.execute("insert into user2(name) values ('wqfeeg')");
        xaRes2.end(xid2, XAResource.TMSUCCESS);

        int ret1 = xaRes1.prepare(xid1);
        int ret2 = xaRes2.prepare(xid2);

        if (ret1 == XAResource.XA_OK && ret2 == XAResource.XA_OK) {
            xaRes1.commit(xid1,false);
            xaRes1.commit(xid2,false);
        }

    }
}

