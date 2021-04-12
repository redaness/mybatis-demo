package com.reda.entity;

import javax.transaction.xa.Xid;

public class MyXid implements Xid {

    private int formatId;
    private byte[] transactionId;
    private byte[] branchQualifier;

    public MyXid(byte[] transactionId, byte[] branchQualifier,int formatId) {
        this.formatId = formatId;
        this.transactionId = transactionId;
        this.branchQualifier = branchQualifier;
    }

    @Override
    public int getFormatId() {
        return formatId;
    }

    @Override
    public byte[] getGlobalTransactionId() {
        return transactionId;
    }

    @Override
    public byte[] getBranchQualifier() {
        return branchQualifier;
    }
}
